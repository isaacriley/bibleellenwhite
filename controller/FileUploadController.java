/**
 * 
 */
package com.biblewhiteapp.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.biblewhiteapp.beans.Images;
import com.biblewhiteapp.beans.forms.portal.ImageCreationForm;
import com.biblewhiteapp.constants.AdminConstants;
import com.biblewhiteapp.repository.AdminUserProfileRepository;
import com.biblewhiteapp.repository.ImageRepository;
import com.biblewhiteapp.utils.LoggingPlusUtils;

/**
 * Dedicated controller for handling file uploads
 * @author riley
 *
 */
@Controller
public class FileUploadController {
	//public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
	//public static String uploadDirectory = "C:\\uploads\\";
	private static final long  MAX_UPLOAD_SIZE=10485760;
	private static final String INACTIVE_SESSION_MESSAGE="Inactive Sessions are deactivated after 30 minutes";
	
	@Autowired
	private AdminUserProfileRepository adminUserProfileRepository;
	@Autowired
	private ImageRepository imageRepository;
	
	/* true if null*/
	private boolean isSessionInactive(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		return session == null;		
	}

	
	@PostMapping("/uploadAvatar")
	public String uploadAvatar(	@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, 
			HttpServletRequest  request, Model model) {
		
		HttpSession session = request.getSession();
		if(!(isSessionInactive(request))){
			String email = session.getAttribute("email").toString();
			model.addAttribute("email", email);
			
			if (file.isEmpty()) {
	            redirectAttributes.addFlashAttribute("error", "Please select a file to upload");
	            return "redirect:user-profile";
	        }
			//we have a file
			String filename = file.getOriginalFilename();
			
			if(file.getSize() >= MAX_UPLOAD_SIZE) {
				model.addAttribute("error", "The upload pic must be less than 10 mega-bytes");
		            return "user-profile";
			}
			
			try {
				byte[] avatar = file.getBytes();
				adminUserProfileRepository.saveAvatar(email, avatar);
				adminUserProfileRepository.saveAvatarFilename(filename, email);
			} catch (IOException e) {
				LoggingPlusUtils.writeToLogsAsIs("!! File write failure: "+e.getStackTrace().toString());
				e.printStackTrace();
			}
				//redirectAttributes.addFlashAttribute("good", "Successfully uploaded your picture: "+ filename.toString());
			 return "redirect:user-profile";
		}else {
			model.addAttribute("error", INACTIVE_SESSION_MESSAGE);
			return "logout";
		}//else inactive session
		
	}
	

	@PostMapping("/superadmin/createimage")
	public String uploadCreateImage(@RequestParam("file") MultipartFile file, 
			RedirectAttributes redirectAttributes, HttpServletRequest  request, 
			@Valid @ModelAttribute("imageCreationForm") ImageCreationForm imageCreationForm,
			BindingResult bind, Model model) {
	
		if(!(isSessionInactive(request))){
		
			if (file.isEmpty()) {
	            redirectAttributes.addFlashAttribute("error", "Please select a file to upload");
	            return "redirect:user-profile";
	        }
			
			Images image = new Images();
			String purpose = "";
			//we have a file
			String filename = file.getOriginalFilename();
			if(file.getSize() >= MAX_UPLOAD_SIZE) {
				model.addAttribute("error", "The upload pic must be less than 10 mega-bytes");
		            return "user-profile";
			}
			
			try {
				byte[] avatar = file.getBytes();
				purpose = imageCreationForm.getPurpose();
				//unique check
				Optional<Images> check = imageRepository.getImageByPurpose(purpose);
				if(check.isPresent()) {
					redirectAttributes.addFlashAttribute("error", AdminConstants.DUPLICATE_EMAIL_IMG);
					return"redirect:/superadmin/createimage";
				}
				image.setFilename(filename);
				image.setPurpose(purpose);
				image.setImage(avatar);
				image.setEncodedstring(Base64.getEncoder().encodeToString(avatar));
				image.setCreatedon(LoggingPlusUtils.getNowDateTime());
				imageRepository.save(image);
			} catch (IOException e) {
				LoggingPlusUtils.writeToLogsAsIs("!! File write failure: "+e.getStackTrace().toString());
				e.printStackTrace();
			}
			 redirectAttributes.addFlashAttribute("good", 
					 	"Successfully uploaded your "+purpose+" image: "+ filename.toString());
			 return "redirect:/superadmin/createimage";
		}else {
			model.addAttribute("error", INACTIVE_SESSION_MESSAGE);
			return "redirect:/login";
		}//else inactive session
		
	}
	
}

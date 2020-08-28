/**
 * 
 */
package com.biblewhiteapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.biblewhiteapp.beans.User;
import com.biblewhiteapp.beans.forms.ContactForm;
import com.biblewhiteapp.beans.forms.UnsubscribeForm;
import com.biblewhiteapp.beans.forms.UserForm;
import com.biblewhiteapp.repository.ContactRepository;
import com.biblewhiteapp.repository.EllenReferencesRepository;
import com.biblewhiteapp.repository.UserRepository;
import com.biblewhiteapp.services.ContactService;
import com.biblewhiteapp.services.EllenWhiteReferencesService;
import com.biblewhiteapp.services.EmailService;
import com.biblewhiteapp.services.UserService;
import com.biblewhiteapp.utils.LoggingPlusUtils;

/**
 * Controller for handling sundry tasks related to users -- ex. adding email registered users
 * @author riley
 *
 */
@Controller
public class UsersController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService usersService;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	ContactService contactService;
	
	@Autowired
	ContactRepository contactRepository;

	@Autowired
	EllenReferencesRepository ellenRepository;
	
	@Autowired
	EllenWhiteReferencesService ellenWhiteReferencesService;
	
	
	@GetMapping("/thanks")
	public String showThanks() {
		return "thanks";
	}
	
	@GetMapping("/contact-response")
	public String showContactResponse() {
		return "contact-response";
	}
	
	@GetMapping("loginError")
	public String showLoginError() {
		return "loginError";
	}
	

	@GetMapping("/contact")
	public String showContactForm(Model model) {
		model.addAttribute("contactForm", new ContactForm());
		return "contact";
	}
	
	@PostMapping("/contact")
	public String addContactUsUser(@Valid @ModelAttribute("contactForm")ContactForm contactForm,
			 BindingResult bind, Model model, ModelMap modelMap, 
			 RedirectAttributes redirectAttribute, HttpServletRequest request) {
		LoggingPlusUtils.writeToLogsAsIs("\nPre-check New Contact Us: "+contactForm+"\n");
		
		if(bind.hasErrors()){
			model.addAttribute("error", "Please correct the errors in the form");
			return "contact";
		}else {
			model.addAttribute("contactForm", new ContactForm());
			contactService.addContact(contactForm);
			LoggingPlusUtils.writeToLogsAsIs("\nNew Contact Us: "+contactForm+"\n");
			redirectAttribute.addFlashAttribute("good", "Your concerns will be addressed promptly.");
			emailService.sendContactUsResponseEmail(contactForm);			
			return "redirect:/thanks";
		}
	}
	
	@GetMapping("/signup")
	public String showSignupForm(Model model) {
		model.addAttribute("userForm", new UserForm());
		return "signup";
	}
		
	@PostMapping("/signup")
	public String addNewUser(HttpServletRequest request,
			@Valid @ModelAttribute("userForm")UserForm userForm,
				BindingResult bindingResult, Model model,	ModelMap modelMap) {
					
		if(bindingResult.hasErrors()) {
			LoggingPlusUtils.writeToLogsAsIs("\n Encountered Form Error\n"+userForm+"\n");
			modelMap.addAttribute("error", "Please correct the errors in the form");
			return "signup";
		}else {
			User user = userRepository.getUserByEmail(userForm.getEmailAddress());
			if(user != null) {//already there
				modelMap.addAttribute("error", "Email address already registered");
				return "signup";
			}
		
			user = usersService.addUser(userForm);
			modelMap.addAttribute("good", "Thanks for signing up. You'll receive your daily emails promptly");
			String token = user.getSubtoken();
			model.addAttribute("token",token);
			userRepository.save(user);
			emailService.sendNewSignupResponseEmail(token);
			return "thanks";
		}//else
					
	}//method
	

	@GetMapping("/unsubscribe")
	public String showUnsubscribe(Model model, @RequestParam("token") String token){
		model.addAttribute("unsubscribeForm", new UnsubscribeForm());
		String message = "We are sorry to see you go. Enter your email address to be removed from the mailing list";
		model.addAttribute("message", message);
		model.addAttribute("token", token);
		return "unsubscribe";
		
	}
	
	@PostMapping("/unsubscribe")
	public String handleUnsubscribe(@Valid @ModelAttribute("unsubscribeForm")UnsubscribeForm unsubscribeForm,
			HttpServletRequest request, RedirectAttributes redirectAttribute, Model model) {
		String token = request.getParameter("token");
		User user = userRepository.findBySubcribeToken(token);
		LoggingPlusUtils.writeToLogsAsIs("\nUnsubscribe Form: "+unsubscribeForm);
		if(user ==null) {
			String error="We experienced an error. Please contact us";
			model.addAttribute("message", error);
			model.addAttribute("contactForm", new ContactForm());
			return "contactus";
		}else {

			String email = user.getEmail();
			if(email.equalsIgnoreCase(unsubscribeForm.getEmail())) {
				userRepository.delete(user);
				String message="Even though you have unsubscribed, you may still use the app.";
				model.addAttribute("message", message);
				return "thanks";
			}else {
				String badEmail="We could not validate that email address";
				redirectAttribute.addFlashAttribute("error", badEmail);
				return "redirect:/unsubscribe?token="+token;
			}//else			
		}//outer else
			
	}
	
}

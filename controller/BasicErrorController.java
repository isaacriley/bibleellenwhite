/**
 * 
 */
package com.biblewhiteapp.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.biblewhiteapp.constants.AdminConstants;
import com.biblewhiteapp.services.superadmin.EconsoleService;
import com.biblewhiteapp.utils.LoggingPlusUtils;

/**
 * Generic error controller that routes errors from requests to the econsole etc.
 * @author riley
 *
 */
@Controller
public class BasicErrorController implements ErrorController {
	@Autowired
	private EconsoleService econsoleService;

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "error";
	}

	@RequestMapping("/")
	public String handleError(HttpServletRequest request, Model model,
			RedirectAttributes redirect) {
		  String status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE).toString();
		   Integer statusCode = Integer.valueOf(request.getAttribute("javax.servlet.error.status_code").toString());
		   Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
		   String headerErrorPath = request.getHeader(getErrorPath());
		   String errorMessage = request.getAttribute(RequestDispatcher.ERROR_SERVLET_NAME).toString();
		  
		  // String cause = "HTML "+statusCode;
	    if (status != null) {
	        
	        if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()){
	        	econsoleService.buildEconsole(request, exception,  this.getClass().toString(), statusCode);
	        	redirect.addFlashAttribute("error", AdminConstants.HTML_500_ERROR);
	        	return "redirect:/home";
	        } else if(statusCode == HttpStatus.UNAUTHORIZED.value()) {
	        	redirect.addFlashAttribute("error", AdminConstants.HTML_401_ERROR);
	        	econsoleService.buildEconsole(request, exception,  this.getClass().toString(), statusCode);
	        	return "redirect:/login";
	        }else if(statusCode == HttpStatus.NOT_FOUND.value()) {
	        	redirect.addFlashAttribute("error", AdminConstants.HTML_404_ERROR);
	        	econsoleService.buildEconsole(request, exception,  this.getClass().toString(), statusCode);
	        	return "redirect:/home";
	        }else if(statusCode == HttpStatus.FORBIDDEN.value()) {
	        	redirect.addFlashAttribute("error", AdminConstants.HTML_403_ERROR);
	        	econsoleService.buildEconsole(request, exception,  this.getClass().toString(), statusCode);
	        	return "redirect:/login";
	        }else if(statusCode == HttpStatus.METHOD_NOT_ALLOWED.value()) {
	        	redirect.addFlashAttribute("error", AdminConstants.HTML_405_ERROR);
	        	econsoleService.buildEconsole(request, exception,  this.getClass().toString(), statusCode);
	        	return "redirect:/login";
	        }else if(statusCode == HttpStatus.BAD_REQUEST.value()) {
	        	redirect.addFlashAttribute("error", AdminConstants.HTML_400_ERROR);
	        	return "redirect:/home";
	        }else  {
	        	LoggingPlusUtils.writeToLogsAsIs("%%%%%%%%%%%%%% START ERROR DETECTED %%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
	        	LoggingPlusUtils.writeToLogsAsIs("\nError Detected:"+status.toString()
	        		+"\n## Additional Error Info:\nHeader Error Path: "+headerErrorPath+
	        			"\nError Message: "+errorMessage+"\n");
	        	LoggingPlusUtils.writeToLogsAsIs("%%%%%%%%%%%%%% END ERROR DETECTED %%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
	        	redirect.addFlashAttribute("error", AdminConstants.GEN_ERROR);
	        	return "redirect:/home";
	        }//last else
	    }//if null
	    redirect.addFlashAttribute("error", "The last attempt failed. Please try again.");
	    return "redirect:/home";
	}
	    
}

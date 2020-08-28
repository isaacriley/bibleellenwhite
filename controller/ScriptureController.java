/**
 * 
 */
package com.biblewhiteapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.biblewhiteapp.beans.Scripture;
import com.biblewhiteapp.beans.forms.ReferenceSearchForm;
import com.biblewhiteapp.services.ScriptureService;
import com.biblewhiteapp.utils.LoggingPlusUtils;

/**
 * @author riley
 *
 */
@Controller
public class ScriptureController {
	
	@Autowired
	private ScriptureService scriptService;
	
	@PostMapping("/home")
	public String getScripture(@ModelAttribute("referenceSearchForm")ReferenceSearchForm refSearch, 
			Model model, ModelMap modelMap) {
		
		model.addAttribute("referenceSearchForm", new ReferenceSearchForm());
		Scripture scripture =  scriptService.getScripture(refSearch.getBookName(), refSearch.getChapter(),
					refSearch.getVerse());
		modelMap.addAttribute("scripture", scripture);
		LoggingPlusUtils.writeToLogsAsIs("\nScripture:"+scripture.toString());
		
		return "index";
	}
	
}

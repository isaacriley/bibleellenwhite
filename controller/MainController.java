/**
 * 
 */
package com.biblewhiteapp.controller;

import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.biblewhiteapp.beans.EllenWhiteReferences;
import com.biblewhiteapp.beans.Scripture;
import com.biblewhiteapp.beans.Volunteer;
import com.biblewhiteapp.beans.forms.ContactForm;
import com.biblewhiteapp.beans.forms.PrintReferenceForm;
import com.biblewhiteapp.beans.forms.ReferenceSearchForm;
import com.biblewhiteapp.beans.forms.VolunteerForm;
import com.biblewhiteapp.constants.AdminConstants;
import com.biblewhiteapp.repository.EllenReferencesRepository;
import com.biblewhiteapp.repository.ScriptureRepository;
import com.biblewhiteapp.repository.VolunteerRepository;
import com.biblewhiteapp.services.ContactService;
import com.biblewhiteapp.services.EllenWhiteReferencesService;
import com.biblewhiteapp.services.EmailService;
import com.biblewhiteapp.services.ScriptureService;
import com.biblewhiteapp.services.TrafficService;
import com.biblewhiteapp.utils.LoggingPlusUtils;

/**
 * Controller that handles user interactions for bible searches from the
 * search page and bridges them to the model
 *@author riley
 *
 */
@Controller
@RequestMapping("/")
public class MainController {
	
	private static final String DISPLAY_VERSE_0= "A zero (\"0\") was submitted as the verse. "
			+ " Displaying Ellen White references for all of ";

	private static final int PAGE_SIZE = 10;

	private static final int TOTAL_BIBLE_TEXTS = 31102;
	
	@Autowired
	EllenReferencesRepository ellenRepository;
	
	@Autowired
	EllenWhiteReferencesService ellenService;
	
	@Autowired
	ScriptureService scriptService;
	
	@Autowired
	ScriptureRepository scriptRepository;

	@Autowired
	private ContactService contactService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private VolunteerRepository volunteerRepository; 
	@Autowired
	private TrafficService trafficService;
	
	@GetMapping({"/", "/home", "/referenceSearch", "/search"})
	public String showHome(Model model, HttpSession session, HttpServletRequest request) {
		
		model.addAttribute("referenceSearchForm", new ReferenceSearchForm());
		try {
			EllenWhiteReferences ref= ellenRepository.getLastRow();
			model.addAttribute("lastbook", ref.getBiblebook());
			model.addAttribute("lastchap", ref.getBiblechapter());
			model.addAttribute("lastverse", ref.getBibleverse());
			model.addAttribute("numrefs", ellenRepository.getNumRecords());
			model.addAttribute("numtexts", TOTAL_BIBLE_TEXTS);
			
			//build traffic entry
			trafficService.createNewSession("guest"+LoggingPlusUtils.getRandomNumberAsInt(1000000)+"@guest.com", 
					"", "", AdminConstants.ROLE_GUEST, request.getSession().getId());
			
		}catch(Exception e) {
			LoggingPlusUtils.writeToLogsAsIs("\nEmpty database: "+e.getMessage());
			e.printStackTrace();		
		}
		return "index";
	}
	
	@GetMapping("/nohits")
	public String showNoHits(Model model, HttpSession session, HttpServletRequest request) {
		
		EllenWhiteReferences ref= ellenRepository.getLastRow();
		model.addAttribute("lastbook", ref.getBiblebook());
		model.addAttribute("lastchap", ref.getBiblechapter());
		model.addAttribute("lastverse", ref.getBibleverse());
		model.addAttribute("numrefs", ellenRepository.getNumRecords());
		model.addAttribute("numtexts", TOTAL_BIBLE_TEXTS);
		return "nohits";
	}
	
	@GetMapping("/sorry")
	public String showSorry() {
		return "sorry";
	}

	@GetMapping("/error-401")
	public String show401ErrorPage() {
		return "error-401";
	}
	
	@GetMapping("/error-403")
	public String show403ErrorPage() {
		return "error-403";
	}
	
	@GetMapping("/error-404")
	public String show404ErrorPage() {
		return "error-404";
	}
	
	@GetMapping("/gen-logout")
	public String showGeneralLogout() {
		return "gen-logout";
	}
	
	@GetMapping("/error-500")
	public String show500ErrorPage() {
		return "error-500";
	}
	
	@GetMapping("/about")
	public String showAbout() {
		return "about";
	}
	
	@GetMapping("/contactus")
	public String showContactOnly(Model model) {
		model.addAttribute("contactForm", new ContactForm());
		return "contactus";
	}
	
	@PostMapping("/contactus")
	public String addContactUsUser(@Valid @ModelAttribute("contactForm")ContactForm contactForm,
			 BindingResult bind, Model model, RedirectAttributes redirectAttribute,ModelMap modelMap,
			 HttpServletRequest request) {
		
		if(bind.hasErrors()){
			modelMap.addAttribute("error", "Please correct the errors in the form");
			return "contact";
		}else {
		
			model.addAttribute("contactForm", new ContactForm());
			contactService.addContact(contactForm);
			LoggingPlusUtils.writeToLogsAsIs("\nNew Contact Us: "+contactForm+"\n");
			redirectAttribute.addFlashAttribute("message", "Your concerns will be addressed promptly.");
			emailService.sendContactUsResponseEmail(contactForm);
			return "redirect:/thanks";
		}//else no errors
	}

	@GetMapping("/generror")
	public String showGeneralErrorPg() {
		return "generror";
	}
	
	@GetMapping("/digest-template")
	public String showDigestEmail() {
		return "digest-template";
	}
	

	@GetMapping({"/results"})
	public String searchForReferences(@Valid @ModelAttribute("referenceSearchForm") ReferenceSearchForm refSearch,
			Model model, ModelMap modelMap, @PageableDefault(size = PAGE_SIZE)Pageable pageable,
			 @RequestParam(defaultValue="0")int page,
			 HttpSession session, HttpServletRequest request) {
		
		model.addAttribute("referenceSearchForm", new ReferenceSearchForm());
		model.addAttribute("currentPage", page);
	
		Scripture scripture = new Scripture();
		String book = refSearch.getBookName();
		int chapter = refSearch.getChapter();
		int verse = refSearch.getVerse();
		model.addAttribute("book", book);
		model.addAttribute("chapter", chapter);
		model.addAttribute("verse", verse);
		scripture.setBook(book);
		scripture.setChapter(chapter);
		scripture.setVerse(verse);
		
		if(verse == 0 && chapter >0) {
			scripture.setBibletext(DISPLAY_VERSE_0+book+" "+chapter+"....");
			
			model.addAttribute("bible", scripture);
		}else {//individual text reference
			Scripture script = scriptService.getScripture(book, chapter, verse);
			if(script == null) {
				model.addAttribute("error", "This doesn't seem to be a valid Bible text");
			}else {
				//model.addAttribute("bible", scripture);
				scripture.setBibletext(script.getBibletext());
				modelMap.addAttribute("bible", scripture);
			}
		}
		
		Page<EllenWhiteReferences> refs = 
				ellenRepository.getEllenWhiteReferencesForBible(book, chapter, verse, pageable);
		if(refs.getTotalElements() >0) {
			model.addAttribute("refs", refs);
			int current = refs.getNumber();
			int size = refs.getSize();
			int startit =1, endit= (int)(refs.getTotalElements() < size? refs.getTotalElements(): size);
			if(page >0) {
				startit = (page * size) +1;
				endit= (page+1) * size;
				if(endit > refs.getTotalElements())
					endit= (int)refs.getTotalElements();
				if(startit > refs.getTotalElements())
					startit= (int)refs.getTotalElements();
			}
				
			model.addAttribute("start", startit);
			model.addAttribute("end", endit);
			
			/*paging indices*/
			int startpg = Math.max(0, current - (PAGE_SIZE -1));
			int endpg = Math.min(startpg + (PAGE_SIZE -1),refs.getTotalPages());
			
			model.addAttribute("current",current);
			model.addAttribute("startpg", startpg);
			model.addAttribute("endpg", endpg);
			model.addAttribute("totalPages", refs.getTotalPages());
			model.addAttribute("totalElements", refs.getTotalElements());
			model.addAttribute("size", refs.getSize());  
			model.addAttribute("refs", refs.getContent());
			return "results";
		}else {
			modelMap.addAttribute("miss", scripture);
			return "nohits";		
		}//else no hit on search
	}
	
	@GetMapping("/printRef")
	public String showPrintRefScreen(Model model) {
		model.addAttribute("printReferenceForm", new PrintReferenceForm());
		return "printRef";
	}
	
	@PostMapping("/printRef")
	public String printReference(ModelMap model,  HttpSession session, HttpServletRequest request,
			@ModelAttribute("printReferenceForm")PrintReferenceForm  printReferenceForm) {

		String refName= printReferenceForm.getQuoteName();
		String refPage= printReferenceForm.getQuotePage();
		String quote = printReferenceForm.getQuote();
		//LoggingPlusUtils.writeToLogsAsIs("\n\nOff print Form: "+printReferenceForm); 
		model.addAttribute("refName", refName);
		model.addAttribute("refPage", refPage);
		model.addAttribute("quote", quote);
		model.addAttribute("today", LoggingPlusUtils.getHumanFriendlyDate());
		return "printRef";
	
	}
	
	@GetMapping("/volunteer")
	public String showVolunteerScreen(Model model, HttpSession session, HttpServletRequest request) {
		model.addAttribute("volunteerForm", new VolunteerForm());
		return "volunteer";
	}
	
	@PostMapping("/volunteer")
	public String addVolunteer(@Valid @ModelAttribute("volunteerForm")VolunteerForm volunteerForm,
			 BindingResult bind, Model model, ModelMap modelMap, 
			 RedirectAttributes redirectAttribute , HttpServletRequest request) {
		LoggingPlusUtils.writeToLogsAsIs("\nPre-check New Volunteer: "+volunteerForm+"\n");
		
		if(bind.hasErrors()){
			model.addAttribute("error", "Please correct the errors in the form");
			return "volunteer";
		}else {
			Date vdate = LoggingPlusUtils.getCurrentDate();
			String fullname = volunteerForm.getFullName();
			String emailaddress = volunteerForm.getEmailAddress();
			Optional<Volunteer> check = volunteerRepository.getVolunteerByEmail(emailaddress);
			if(check.isPresent()) {
				redirectAttribute.addFlashAttribute("error", emailaddress+" is already listed as a Volunteer. Our System"
						+ " Administrator will contact you shortly.");
				return "redirect:/home";
			}
			String church = volunteerForm.getChurch();
			String helps = volunteerForm.getHelps();
			Volunteer volunteer = new Volunteer();
			volunteer.setFullname(fullname); volunteer.setEmailaddress(emailaddress);
			volunteer.setChurch(church);volunteer.setHelps(helps); 
			volunteer.setVolunteerdate(vdate);
			//LoggingPlusUtils.writeToLogsAsIs("\nVolunteer Form: "+volunteerForm);
			volunteerRepository.save(volunteer);
			redirectAttribute.addFlashAttribute("good", "Thanks for volunteering; we appreciate it. We'll send further instructions "
					+ "to your email address shortly.");
			//emailService.sendContactUsResponseEmail(volunteerForm);			
			return "redirect:/home";
		}
	}
	
	
}

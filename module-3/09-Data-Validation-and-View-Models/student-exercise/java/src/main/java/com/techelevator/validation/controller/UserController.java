package com.techelevator.validation.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.validation.model.Login;
import com.techelevator.validation.model.Registration;

@Controller
public class UserController {
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String getMainScreen() {
		return "homePage";
	}

	
	
	@RequestMapping(path="/register", method=RequestMethod.GET)
	public String getRegistrationForm(ModelMap modelHolder) {
		if( ! modelHolder.containsAttribute("registration")) {
			modelHolder.put("registration", new Registration());
		}
		return "registration";
	}

	
	@RequestMapping(path="/register", method=RequestMethod.POST)
	public String processRegistration(@Valid @ModelAttribute("registration") Registration registrationData, 
			BindingResult result, RedirectAttributes flash) {
		if(result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "registration", result);
			flash.addFlashAttribute("registration", registrationData);
			return"redirect:/register";
		}
		
		
		return "redirect:/confirmation";
	}

	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String getLoginForm(ModelMap modelHolder) {
		if( ! modelHolder.containsAttribute("login")) {
			modelHolder.put("login", new Login());
		}
		return "login";
	}

	
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String processLogin(@Valid @ModelAttribute Login loginData, BindingResult result, 
			RedirectAttributes flash) {
		if(result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "login", result);
			flash.addFlashAttribute("login", loginData);
			return"redirect:/login";
		}
		
		return "redirect:/confirmation";
	}
	
	@RequestMapping(path="/confirmation", method=RequestMethod.GET)
	public String displayConfirmationPage() {
		return "confirmation";
	}

	
}

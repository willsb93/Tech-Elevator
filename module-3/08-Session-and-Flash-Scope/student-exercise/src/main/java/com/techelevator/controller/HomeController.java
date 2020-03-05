package com.techelevator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.techelevator.model.Favorite;

@Controller
public class HomeController {

	
	
	
	@RequestMapping("/")
	public ModelAndView redirectToFavoriteThingsPage1() {
		// Because we want to return a 301 status code, we need to use RedirectView
		// rather than redirect:
		// Return a redirect relative to the context of the application
		RedirectView redirect = new RedirectView("/Page1", true);
		redirect.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
		return new ModelAndView(redirect);
	}
	

}

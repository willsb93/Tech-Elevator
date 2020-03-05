package com.techelevator.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.techelevator.model.Favorite;

@Controller
@SessionAttributes("favoriteThings")
public class FavoriteThingsController {
	
	
	@RequestMapping(path = "/Page1", method = RequestMethod.GET)
	public String getPage1() {
		return "page1";
	}
	
	@RequestMapping(path = "/Page2", method = RequestMethod.POST)
	public String getPage2(ModelMap map, @RequestParam String color) {
		Favorite favorite = new Favorite();
		favorite.setColor(color);
		map.put("favoriteThings", favorite);
		
		return "page2";
	}
	
	@RequestMapping(path = "/Page3", method = RequestMethod.POST)
	public String getPage3(ModelMap map, @RequestParam String food) {
		Favorite favorite = (Favorite) map.get("favoriteThings");
		favorite.setFood(food);
		map.put("favoriteThings", favorite);
		return "page3";
	}
	
	@RequestMapping(path = "/Page4", method = RequestMethod.POST)
	public String getPage4(ModelMap map,  @RequestParam String season ) {
		Favorite favorite = (Favorite) map.get("favoriteThings");
		favorite.setSeason(season);
		map.put("favoriteThings", favorite);
		
		return "page4";
	}


}

package com.techelevator.npgeek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SessionAttributes("choice")
@Controller
public class ParkController {
	@Autowired
	private ParkDAO parkDAO;
	@Autowired
	private SurveyDAO surveyDAO;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String getHomePage(HttpServletRequest request, ModelMap map) {

		request.setAttribute("parks", parkDAO.getAllParkData());

		return "homePage";
	}

	@RequestMapping(path = "/details", method = RequestMethod.GET)
	public String getDetailsPage(HttpServletRequest request, ModelMap map) {
		String parkCode = request.getParameter("parkCode");
		if (!map.containsAttribute("choice")) {
			map.addAttribute("choice", "Farenheit");
		}
		List<Weather> weathers = parkDAO.getWeatherByParkCode(parkCode);
		updateTemperatureFormat(weathers, (String) map.get("choice"));
		
		map.addAttribute("weathers", weathers);
		Park park = parkDAO.getParkByParkCode(parkCode);
		request.setAttribute("park", park);

		return "details";

	}
	


	@RequestMapping(path = "/degreetype", method = RequestMethod.POST)
	public String getDetailsWithDegreeType(HttpServletRequest request, ModelMap map) {
		String parkCode = request.getParameter("parkCode");
		Park park = parkDAO.getParkByParkCode(parkCode);
		List<Weather> weathers = parkDAO.getWeatherByParkCode(parkCode);
		String degreeType = request.getParameter("Degrees");
		map.put("choice", degreeType);
		updateTemperatureFormat(weathers, degreeType);
		map.addAttribute("park", park);
		request.setAttribute("degree", degreeType);
		request.setAttribute("weathers", weathers);

		return "/details";
	}

	@RequestMapping(path = "/survey", method = RequestMethod.GET)
	public String getSurveyPage(HttpServletRequest request, ModelMap map) {
		if (!map.containsAttribute("survey")) {
			map.addAttribute("survey", new Survey());
		}

		List<Park> allParks = parkDAO.getAllParkData();
		map.addAttribute("parkList", allParks);

		return "survey";
	}

	@RequestMapping(path = "/surveyconfirmation", method = RequestMethod.POST)
	public String getConfirmationPage(@Valid @ModelAttribute("survey") Survey survey, BindingResult result,
			RedirectAttributes attr, @RequestParam String parkName, ModelMap map) {
		List<Park> allParks = parkDAO.getAllParkData();
		map.addAttribute("parkList", allParks);

		if (result.hasErrors()) {
			return "survey";
		}
		survey.setParkCode(parkDAO.getParkByParkName(parkName));
		surveyDAO.addNewSurveyToDatabase(survey);
		map.addAttribute("popularparks", surveyDAO.listMostPopularParks());

		return "redirect:/confirmation";

	}


	@RequestMapping(path = "/confirmation", method = RequestMethod.GET)
	public String getRedirectConfirmationPage(ModelMap map, Survey survey) {

		map.addAttribute("popularparks", surveyDAO.listMostPopularParks());
		return "confirmation";
	}
	
	

	private void updateTemperatureFormat(List<Weather> weathers, String degreeType) {
		for (Weather weather : weathers) {
			if (degreeType.equalsIgnoreCase("Celsius")) {
				weather.setCelsius(true);
			} else {
				weather.setCelsius(false);
			}

		}

	}
}

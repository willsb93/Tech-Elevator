package com.techelevator.ssg.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.techelevator.ssg.model.forum.ForumDao;
import com.techelevator.ssg.model.forum.ForumPost;
import com.techelevator.ssg.model.store.Product;
import com.techelevator.ssg.model.store.ProductDao;

@Controller

@SessionAttributes("shoppingCart")
public class HomeController {

	
	
	@Autowired
	private ForumDao forumDao;
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/")
	public String displayHomePage() {
		return "homePage";
	}
	
	
	@RequestMapping("/alienWeight")
	public String displayAlienWeight(HttpServletRequest request) {
		return "alienWeight";
	}
	
	@RequestMapping("/alienWeightResults")
	public String displayAlienWeightResults(HttpServletRequest request){
		
		String planet = request.getParameter("choosePlanet");
		double earthWeight = Double.parseDouble(request.getParameter("enterEarthWeight"));
		double alienWeight = 0;
		
		if(planet.equalsIgnoreCase("mercury")) {
			alienWeight = earthWeight * .37;
		}else if(planet.equalsIgnoreCase("jupiter")) {
			alienWeight = earthWeight * 2.65;
		}else if(planet.equalsIgnoreCase("venus")) {
			alienWeight = earthWeight * .90;
		}else if(planet.equalsIgnoreCase("saturn")) {
			alienWeight = earthWeight * 1.13;
		}else if(planet.equalsIgnoreCase("earth")) {
			alienWeight = earthWeight;
		}else if(planet.equalsIgnoreCase("uranus")) {
			alienWeight = earthWeight * 1.09;
		}else if(planet.equalsIgnoreCase("mars")) {
			alienWeight = earthWeight * .38;
		}else if(planet.equalsIgnoreCase("neptune")) {
			alienWeight = earthWeight * 1.43;
		}
		
		System.out.println(alienWeight);
		
		request.setAttribute("planet", planet);
		request.setAttribute("alienWeight", alienWeight);
		
		return "alienWeightResults";
	}
	
	@RequestMapping("/alienAge")
	public String displayAlienAge(HttpServletRequest request) {
		return "alienAge";
	}
	
	@RequestMapping("/alienAgeResults")
	public String displayAlienAgeResults(HttpServletRequest request){
		
		String planet = request.getParameter("choosePlanet");
		double earthAge = Double.parseDouble(request.getParameter("enterEarthAge"));
		double alienAge = 0;
		
		if(planet.equalsIgnoreCase("mercury")) {
			alienAge = earthAge * 4.15;
		}else if(planet.equalsIgnoreCase("jupiter")) {
			alienAge = earthAge * .08;
		}else if(planet.equalsIgnoreCase("venus")) {
			alienAge = earthAge * 1.63;
		}else if(planet.equalsIgnoreCase("saturn")) {
			alienAge = earthAge * .03;
		}else if(planet.equalsIgnoreCase("earth")) {
			alienAge = earthAge;
		}else if(planet.equalsIgnoreCase("uranus")) {
			alienAge = earthAge * .012;
		}else if(planet.equalsIgnoreCase("mars")) {
			alienAge = earthAge * .53;
		}else if(planet.equalsIgnoreCase("neptune")) {
			alienAge = earthAge * .006;
		}
		
		System.out.println(alienAge);
		request.setAttribute("earthAge", earthAge);
		request.setAttribute("planet", planet);
		request.setAttribute("alienAge", alienAge);
		
		return "alienAgeResults";
	
	}
	
	@RequestMapping("/alienTravelTime")
	public String displayAlienTravelTime(HttpServletRequest request) {
	
		return "alienTravelTime";
	}
	
	@RequestMapping("/alienTravelTimeResults")
	public String displayAlienTravelTimeResults(HttpServletRequest request){
		
		String planet = request.getParameter("choosePlanet");
		String transportationMethod = request.getParameter("transportationMethod");
		double earthAge = Double.parseDouble(request.getParameter("enterEarthAge"));
		double TravelAge = 0;
		double distanceToPlanet =0; 
		double travelSpeed = 0;
		double totalYearsNeeded = 0;
		
		if(planet.equalsIgnoreCase("mercury")) {
			distanceToPlanet = 56974146.0;
		}else if(planet.equalsIgnoreCase("jupiter")) {
			distanceToPlanet = 390674710.0;
		}else if(planet.equalsIgnoreCase("venus")) {
			distanceToPlanet = 25724767.0;
		}else if(planet.equalsIgnoreCase("saturn")) {
			distanceToPlanet = 792248270.0;
		}else if(planet.equalsIgnoreCase("earth")) {
			distanceToPlanet = 0.0;
		}else if(planet.equalsIgnoreCase("uranus")) {
			distanceToPlanet = 1692662530.0;
		}else if(planet.equalsIgnoreCase("mars")) {
			distanceToPlanet = 48678219.0;
		}else if(planet.equalsIgnoreCase("neptune")) {
			distanceToPlanet = 2703959960.0;
		}
		
		if(transportationMethod.equalsIgnoreCase("walking")) {
			travelSpeed = 3.0;
		}else if(transportationMethod.equalsIgnoreCase("car")) {
			travelSpeed = 100.0;
		}else if(transportationMethod.equalsIgnoreCase("bullet train")) {
			travelSpeed = 200.0;
		}else if(transportationMethod.equalsIgnoreCase("boeing 747")) {
			travelSpeed = 570.0;
		}else if(transportationMethod.equalsIgnoreCase("concorde")) {
			travelSpeed = 1350.0;
		}
		
		totalYearsNeeded = (distanceToPlanet/travelSpeed)/8760;
		earthAge += totalYearsNeeded;
		
		
		request.setAttribute("earthAge", Double.parseDouble(request.getParameter("enterEarthAge")));
		request.setAttribute("transportationMethod", planet);
		request.setAttribute("totalYearsNeeded", totalYearsNeeded);
		request.setAttribute("planet", planet);
		
		return "alienTravelTimeResults";
	
	}
	

	@RequestMapping(path = "/forum", method = RequestMethod.GET)
	public String displayForum(HttpServletRequest request, ModelMap oldReviews) {
		List <ForumPost> oldReview = forumDao.getAllPosts();
		oldReviews.put("review", oldReview);
		
		return "forum";
	}
	
	@RequestMapping (path = "/forumBoard", method = RequestMethod.POST)
	public String forumSubmit(ForumPost post, @RequestParam String username, String subject, String message) {
		
		post.setDatePosted(LocalDateTime.now());
		forumDao.save(post);

	@RequestMapping(path = "/forumPost", method = RequestMethod.GET)
	public String displayAddForumPost(HttpServletRequest request, ModelMap map) {
		if(!map.containsAttribute(("ForumPost"))) {
			
			map.addAttribute("ForumPost", new ForumPost());
		}
		
		return "forumPost";
	}
	
	@RequestMapping (path = "/forumPost", method = RequestMethod.POST)
	public String forumSubmit(@RequestParam String username, String subject, String message,
			@Valid @ModelAttribute("ForumPost") ForumPost forumPost, BindingResult result) {
		
		if(result.hasErrors()) {
			return "forumPost";
		}
		
		forumPost.setDatePosted(LocalDateTime.now());
		
//		ForumPost post = new ForumPost();
//		post.setUsername(username);
//		post.setSubject(subject);
//		post.setMessage(message);
//		post.setDatePosted(LocalDateTime.now());
//		forumDao.save(post);
		forumDao.save(forumPost);
		

		

		
		return "forumBoard";
	}
	
	@RequestMapping(path="/forumBoard", method = RequestMethod.GET)
	public String displayForumBoard(ModelMap map) {
		
		map.addAttribute("posts", forumDao.getAllPosts());
		
		
		return "forumBoard";
	}
	
	
	
	
	@RequestMapping(path = "/store")
	public String displayStorePage(ModelMap map) {
		List<Product> allProducts = new ArrayList<>();
		map.addAttribute("productList", productDao.getAllProducts());
		
		//if session map contains shoppingcart key ----
		if (!map.containsKey("shoppingCart")) {
		Map <Product, Integer> cartMap = new HashMap<Product, Integer>();
		map.addAttribute("shoppingCart", cartMap);
		}
		
	    return "store";
	}
	
	
	@RequestMapping(path = "/productDetail")
	public String displayProductDetailPage(ModelMap map, @RequestParam long id) {
		
		map.addAttribute("product", productDao.getProductById(id));
		
		return "productDetail";
	}
	
	@RequestMapping(path = "/cart")
	public String addToCart(ModelMap map, @RequestParam long id, @RequestParam int quantity) {
//		double finalPrice =  quantity * productDao.getProductById(id).getPrice();
		
		Map<Product, Integer> cartMap = (Map<Product, Integer>) map.get("shoppingCart");
		
		cartMap.put(productDao.getProductById(id), quantity);
		
		
		return "cart";
	}
	
	@RequestMapping(path = "/terminate")
	public String endSession(HttpSession session, ModelMap map) {
		 session.invalidate();
		 map.clear();
		 
		
		return "redirect:/store";
	}
}

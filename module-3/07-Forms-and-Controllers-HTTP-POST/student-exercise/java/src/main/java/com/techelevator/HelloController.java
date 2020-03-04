package com.techelevator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.Review;
import com.techelevator.model.ReviewDao;

@Controller
public class HelloController {

	@Autowired
	private ReviewDao reviewDao;
	
	
	@RequestMapping(path = "/greeting", method = RequestMethod.GET)
	public String displayGreeting(HttpServletRequest request, ModelMap oldReviews) {
		List <Review> oldReview = reviewDao.getAllReviews();
		oldReviews.put("reviews", oldReview);
		return "greeting";
	}
	
	
	@RequestMapping(path = "/writeReview", method = RequestMethod.POST)
	public String displayReview(HttpServletRequest request, Review review) {
		review.setDateSubmitted(LocalDateTime.now());
		reviewDao.save(review);
		return "redirect:/greeting";
	}
}

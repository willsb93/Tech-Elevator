package com.techelevator;

import com.techelevator.dao.FilmDao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * FilmSearchController
 */
@Controller
public class FilmSearchController {

    @Autowired
    FilmDao filmDao;
  
    
    @RequestMapping(path = "/filmList", method = RequestMethod.GET)
    public String showFilmSearchForm(HttpServletRequest request) {
        return "filmList";
    }

    @RequestMapping(path = "/searchFilm", method = RequestMethod.GET)
    public String searchFilms(HttpServletRequest request, @RequestParam(defaultValue = "0") int minimumLength,
            @RequestParam(defaultValue = "500") int maximumLength, @RequestParam String genre, ModelMap modelHolder) {
        modelHolder.put("films", filmDao.getFilmsBetween(genre, minimumLength, maximumLength));
        return "filmList";
    }

}
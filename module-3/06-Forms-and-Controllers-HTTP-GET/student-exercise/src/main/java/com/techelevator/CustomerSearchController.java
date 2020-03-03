package com.techelevator;

import com.techelevator.dao.CustomerDao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerSearchController {

    @Autowired
    private CustomerDao customerDao;
    
    @RequestMapping(path = "/customerList", method = RequestMethod.GET)
	public String showCustomerForm(HttpServletRequest request) {
		return "customerList";
	}
    

    @RequestMapping(path = "/searchCustomer", method = RequestMethod.GET)
    public String searchCustomers(HttpServletRequest request, @RequestParam String search, String sort, ModelMap model) {
        model.put("customers", customerDao.searchAndSortCustomers(search, sort));
        return "customerList";
    }
    
}
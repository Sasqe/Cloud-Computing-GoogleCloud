package com.gcu.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.business.ProductBusinessService;
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.CredentialsModel;



/**
 * The controller that handles all the routing for login
 */
@Controller
public class LoginController 
{
	@Autowired
	SecurityBusinessService security;
	@Autowired
	ProductBusinessService productservice;
	/**
	 * the route to display the login screen with form
	 * @param model (page model)
	 * @return login page
	 */
	@GetMapping("/login")
	public String display(Model model) 
	{
		//display method for landing on the login page
	    //add new loginmodel object to 'loginModel' attribute
	    model.addAttribute("loginModel", new CredentialsModel());
	    //return login view
	    return "login";
	}
	@PostMapping("/doLogin")
	public String doLogin(@Valid CredentialsModel credentials, BindingResult bindingResult, Model model) {
		boolean auth = security.authenticate(credentials);
		if (bindingResult.hasErrors() || auth == false) {
			System.out.println("Auth failed :: Returning User to Login");
			model.addAttribute("title", "Authentication Failed");
			model.addAttribute("loginModel", new CredentialsModel());
			return "login";
		}
		model.addAttribute("products", productservice.findAll());
		return "products";
		
		
	}
}
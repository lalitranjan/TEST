package com.codesters.Controller;

import java.sql.Date;
import java.util.Collection;
import java.util.Map;

import com.codesters.Myservice.CustomerService;
import com.sun.xml.bind.util.AttributesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codesters.model.Customer;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HomeController {

	@Autowired
	 private CustomerService service;
	
	
	@RequestMapping("/")
	public String home() {
		return "SqlHome.html";
	}
	
	@RequestMapping("/signup")
	public String signUp()
	{
		return "signUpPage.html";
	}
	
	@RequestMapping("/registrationSuccessfull")
	public String registerCustomer(@RequestParam String name, @RequestParam String password, @RequestParam Date doB, @RequestParam String userName, @RequestParam long contact,Model model)
	{
		int id = service.register(name,userName, password, doB, contact);
		model.addAttribute("id",id);
		return "RegistrationSuccess.html";
	}
	
	@RequestMapping("/signin")
	public String signIn()
	{
		return "signInPage.html";
	}
	
	@GetMapping("/retrieveCustomer")
	public @ResponseBody Iterable<Customer> getCustomer()
	{

		return service.getAllCustomers();
		
	}

	@GetMapping("/retrieveCustomerById")
	public String getById(@RequestParam int id,@RequestParam String password, Model model)
	{
		Customer c = service.getCustomerbyId(id);
		if(service.logincheck(id,password))
		{
			model.addAttribute("id",c.getId());
			model.addAttribute("name",c.getName());
			model.addAttribute("userName",c.getUserName());
			model.addAttribute("doB",c.getDateOfBirth());
			model.addAttribute("contact",c.getContact());
			return "display.html";
		}
		else
		{
			return "accessDenied.html";
		}
	}
	@GetMapping("/login")
	public String login(@RequestParam int id,@RequestParam String password,Model model)
	{
		boolean result = service.logincheck(id, password);
		if (result == true)
		{
			model.addAttribute("id",id);
			return "loginSuccess.html";
		}
		else
		{
			return "accessDenied.html";
		}
	}

	@RequestMapping("/check")
	public String check()
	{
		return "check.html";
	}
}

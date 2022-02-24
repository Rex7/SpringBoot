package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.staffInterface;

@RestController
public class HomeController {
	
	@Autowired
	staffInterface staffInterface;
	
	
		@GetMapping("/home")
	public ModelAndView home(String username) {
			
		ModelAndView modelView =new ModelAndView();
		modelView.addObject("username", username);
		modelView.setViewName("index");
		
		return modelView;
	}
	
	@RequestMapping("Adduser")
	public ModelAndView AddUser(Staff staff) {
		
		ModelAndView modelAndView=new ModelAndView();
		staffInterface.save(staff);
		modelAndView.setViewName("display");
		
		System.out.println("called"+staff.getStaffName());
		return modelAndView;
	}

}

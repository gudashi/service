package com.gudashi.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gudashi.service.entity.User;
import com.gudashi.service.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	private static int counter = 0;
	private static final String VIEW_INDEX = "index";
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {
		
	    model.addAttribute("message", "Welcome " + name);
        model.addAttribute("counter", ++counter);
        logger.debug("[welcomeName] counter : {}", counter);
		
		return VIEW_INDEX;

	}
	
	@RequestMapping(value = "/{id}.json", method = RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable long id) {		
		return userService.getUserById(id);
	}
}

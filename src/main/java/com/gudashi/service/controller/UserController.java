package com.gudashi.service.controller;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.gudashi.service.entity.User;
import com.gudashi.service.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private static int counter = 0;
	private static final String VIEW_INDEX = "index";
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		model.addAttribute("message", "Welcome");
		model.addAttribute("counter", ++counter);
		logger.debug("[welcome] counter : {}", counter);

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;

	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {
		
		if(NumberUtils.isNumber(name)){
			User user = userService.getUserById(Long.parseLong(name));
			model.addAttribute("user", JSON.toJSONString(user));
			logger.debug("根据ID获取用户："+JSON.toJSONString(user));
		}else {
			model.addAttribute("message", "Welcome " + name);
			model.addAttribute("counter", ++counter);
			logger.debug("[welcomeName] counter : {}", counter);
		}
		
		return VIEW_INDEX;

	}
	
	@RequestMapping(value = "/{id}.json", method = RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable long id) {		
		return userService.getUserById(id);
	}
}

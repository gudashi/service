package com.gudashi.service.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gudashi.service.service.MyStockService;

@Controller
@RequestMapping(value = "/my/stock")
public class MyStockController {
	@Autowired
	private MyStockService service;

	@RequestMapping("/list.json")
	@ResponseBody
	public List<String> getStockList(String userId){
		return service.getStockList(userId);
	}

	@RequestMapping(method=RequestMethod.POST, value="/add.json")
	@ResponseBody
	public String addStock(String userId, @RequestBody String... stockIdArray) {
		try{
			service.addStock(userId, stockIdArray);
			return StringUtils.EMPTY;
		}catch(Exception ex){
			return ex.toString();
		}
	}
}

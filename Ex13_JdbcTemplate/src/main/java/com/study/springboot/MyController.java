package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.jdbc.MyUserDAO;

@Controller
public class MyController {
	@Autowired
	private MyUserDAO userDao;
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		return "JdbcTemplate 사용하기";
	}
	
	//@GETMapping("/user") //잘 안씀
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userlistPage(Model model) 
	{
		model.addAttribute("users", userDao.listForBeanPropertyRowMapper());
		return "userlist";
	}
}

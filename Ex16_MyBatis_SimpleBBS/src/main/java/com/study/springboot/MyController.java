package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.dao.ISimpleBbsDao;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {
	@Autowired
	ISimpleBbsDao dao;
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		// JdbcTemplate : SimpleBBS
		return "redirect:list";
	}
	

	@RequestMapping("/list")
	public String userlistPage(Model model) 
	{
		model.addAttribute("list", dao.listDao());
		return "/list";
	}
	
	@RequestMapping("/view")
	public String view(HttpServletRequest request, Model model) 
	{
		String sId = request.getParameter("id");
		model.addAttribute("dto", dao.viewDao(sId));
		return "/view";
	}
	
	@RequestMapping("/writeForm")
	public String wirteForm() 
	{
		return "/writeForm";
	}
	
	@RequestMapping("/write")
	public String wirte(HttpServletRequest request, Model model) 
	{
		dao.writeDao(request.getParameter("writer"),
					 request.getParameter("title"),
					 request.getParameter("content"));
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) 
	{
		dao.deleteDao(request.getParameter("id"));
		return "redirect:list";
	}
	
}

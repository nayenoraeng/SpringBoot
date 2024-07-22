package com.study.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {

	@RequestMapping("/")
	 public @ResponseBody String root() throws Exception{
		
		return "form 데이터 전달받아 사용하기";
	}
	
	@RequestMapping("/test1")
	public String test1(HttpServletRequest httpServletRequest, Model model) {
		
		String id = httpServletRequest.getParameter("id");
		String name = httpServletRequest.getParameter("name");
		
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		
		return "test1";
	}
	
	@RequestMapping("/test2")
	//스프링부트에서 많이 쓰임. 파라미터가 많아지면 불편해진다.
	public String test2(@RequestParam("id") String id,
						@RequestParam("name") String name,
								Model model) 
	{
		
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		
		return "test2";
	}
	
	/*
		커맨드 객체를 통해 파라미터를 한꺼번에 받아 저장하고, 모델 객체에 저장까지
		해준다. 파라미터를 저장한 DTO를 통해 출력해야하므로 VIEW에서는 getter를
		사용한다.
	*/
	@RequestMapping("/test3")
	public String test3(Member member, Model model) 
	{
		return "test3";
	}
	
	//패스 자체에 변수를 넣어줄 수도 있다.
	@RequestMapping("/test4/{studentId}/{name}")
	//어노테이션에 이름을 생략하지 ㅇ낳고 아래와 같이 이름을 항상 적어준다.
	//스프링 부트 3.2 전까지는 바이트코드를 파싱해서 매개변수 이름을 추론하려고 시도함
	//하지만 스트링부트 3.2 부터는 이런 시도를 하지 않는다.
	public String getStudent(@PathVariable("studentId") String studentId,
							 @PathVariable("name") String name,
							 Model model) 
	{
		model.addAttribute("id", studentId);
		model.addAttribute("name", name);
		return "test4";
	}
	
}

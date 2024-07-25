package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@RequestMapping("/")
	 public @ResponseBody String root() throws Exception{
		
		return "Validator (1)";
	}
	
	@RequestMapping("/insertForm")
	public String intsert1() {
		
		return "createPage";
	}
	
	@RequestMapping("/create") // create 가 호출되면 
	// @Validated 항상 검증하겠다.
	public String intsert2(@ModelAttribute("dto") @Validated ContentDto contentDto,
							BindingResult result)
	{
		String page = "createDonePage";
		System.out.println(contentDto);
		
//		ContentValidator validator = new ContentValidator();
//		validator.validate(contentDto, result);
		
		if(result.hasErrors()) {
			System.out.println("getAllErrors : " + result.getAllErrors());
			
			if(result.getFieldError("writer") != null) {
				System.out.println("1:" +result.getFieldError("writer").getCode());
			}
			if(result.getFieldError("content") != null) {
				System.out.println("1:" +result.getFieldError("content").getCode());
			}
			
			page = "createPage";
		}
		return page;
	}
	
	/*
		어노테이션을 지정하여 해당메서드를 프로젝트가 시작할 떄 먼저 실행시킴
		그럼 WebDataBinder 타입 변수에 우리가 사용할 유효성 검증 클래스가
		프로젝트가 시작 할 때 등록된다.
	*/
	@InitBinder
	protected void initBinder(WebDataBinder binder)
	{
		//개별적으로 생성할 필요 없이 유효성 검증이 필요하면
		//binder 변수에서 꺼내서 사용하면 된다.
		binder.setValidator(new ContentValidator());
	}
	
}

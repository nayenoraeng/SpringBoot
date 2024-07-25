package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.Valid;

@Controller
public class MyController {

	@RequestMapping("/")
	 public @ResponseBody String root() throws Exception{
		
		return "Valid Annotation (4)";
	}
	
	@RequestMapping("/insertForm")
	public String intsert1() {
		
		return "createPage";
	}
	
	@RequestMapping("/create") // create 가 호출되면 
	// @Validated 항상 검증하겠다.
	public String intsert2(@ModelAttribute("dto") @Valid ContentDto contentDto,
							BindingResult result)
	{
		String page = "createDonePage";
		
//		ContentValidator validator = new ContentValidator();
//		validator.validate(contentDto, result);
		
		if(result.hasErrors()) {
						
			if(result.getFieldError("writer") != null) {
				System.out.println("1:" +result.getFieldError("writer").getDefaultMessage());
			}
			if(result.getFieldError("content") != null) {
				System.out.println("1:" +result.getFieldError("content").getDefaultMessage());
			}
			
			page = "createPage";
		}
		return page;
	}
	

//	@InitBinder
//	protected void initBinder(WebDataBinder binder)
//	{
//		//개별적으로 생성할 필요 없이 유효성 검증이 필요하면
//		//binder 변수에서 꺼내서 사용하면 된다.
//		binder.setValidator(new ContentValidator());
//	}
	
}

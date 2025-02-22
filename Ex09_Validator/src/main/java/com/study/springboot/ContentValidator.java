package com.study.springboot;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ContentValidator implements Validator {
	
	@Override
	public boolean supports (Class<?> arg0)
	{
		return ContentDto.class.isAssignableFrom(arg0);
	}
	
	@Override
	public void validate (Object obj, Errors errors)
	{
		ContentDto dto = (ContentDto)obj;
		
		String sWriter = dto.getWriter();
		if(sWriter == null || sWriter.trim().isEmpty()) {
			System.out.println("Writer null or empty");
			errors.rejectValue("writer", "trouble");
		}
		
		String sContent = dto.getContent();
		if(sContent == null || sContent.trim().isEmpty()) {
			System.out.println("Content is null or empty");
			errors.rejectValue("content", "trouble");
		}
			 
	}
	
}

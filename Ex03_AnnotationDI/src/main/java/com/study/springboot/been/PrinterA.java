package com.study.springboot.been;

import org.springframework.stereotype.Component;

@Component("printerA")
public class PrinterA implements Printer{

	@Override
	public void Print(String message) {
		System.out.println("PrinterA :" + message);
	}
	
}

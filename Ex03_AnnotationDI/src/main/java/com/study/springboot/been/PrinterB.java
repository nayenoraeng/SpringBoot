package com.study.springboot.been;

import org.springframework.stereotype.Component;

@Component("printerB")
public class PrinterB implements Printer {

	@Override
	
	public void Print(String message) {
		System.out.println("Printer B :" + message);
	}
}

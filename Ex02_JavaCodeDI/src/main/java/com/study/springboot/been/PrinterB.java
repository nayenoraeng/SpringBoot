package com.study.springboot.been;

public class PrinterB implements Printer {

	@Override
	
	public void Print(String message) {
		System.out.println("Printer B :" + message);
	}
}

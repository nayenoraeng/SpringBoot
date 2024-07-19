package com.study.springboot.been;

public class PrinterA implements Printer{

	@Override
	public void Print(String message) {
		System.out.println("PrinterA :" + message);
	}
	
}

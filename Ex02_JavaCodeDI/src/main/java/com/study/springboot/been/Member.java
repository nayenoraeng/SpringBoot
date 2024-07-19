package com.study.springboot.been;

public class Member {
	
	private String name;
	private String nickname;
	private Printer printer;
	
	//기본(디폴트)생성자, 인수생성자, getter, setter, toString() 메서드 추가
	
	public Member()	{ }

	public Member(String name, String nickname, Printer printer)
	{
		this.name = name;
		this.nickname = nickname;
		this.printer = printer;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	public void setPrinter(Printer printer)
	{
		this.printer = printer;
	}
	
	public void print()
	{
		System.out.println("Hello" + name + " : " + nickname);
	}
	

}

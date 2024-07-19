package com.study.springboot.been;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	/*
		bean : spring 이 IoC 방식으로 관리하는 객체
		BeacFactory : 스프링의 IoC를 담당하는 핵심 컨테이너
		어플리케이션 컨텍스트 : 빈팩토리를 확장한 IoC 컨테이너
	*/
	
	/*
		@Bean 어노테이션을 통해 자바빈을 생성 이때 참조변수명은 별도의 설정이
		없으므로 메서드명인 member1로 생성한다.
	*/
	@Bean
	public Member member1() {
		Member member1 = new Member();
		member1.setName("홍길동");
		member1.setNickname("도사");
		member1.setPrinter(new PrinterA());
		
		return member1;
	}
	
	//위와 동일하게 자바빈을 생성하되 name 속성을 부여했으므로 해당명인 hello로 생성된다.
	@Bean(name="hello")
	public Member member2() {
		return new Member("전우치", "도사", new PrinterA());
	}
	
	@Bean
	public PrinterA printerA() {
		return new PrinterA();
	}
	
	@Bean
	public PrinterB printerB() {
		return new PrinterB();
	}


}

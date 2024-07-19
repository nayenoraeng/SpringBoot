package com.study.springboot;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.study.springboot.been.Config;
import com.study.springboot.been.Member;
import com.study.springboot.been.Printer;

//어노테이션에 의해 자동으로 설정이 이루어지고 컴포넌트가 등록이 되기 때문에 먼저 주석처리.
//@SpringBootApplication
public class Ex02JavaCodeDiApplication {

	public static void main(String[] args) {
//		SpringApplication.run(Ex02JavaCodeDiApplication.class, args);
		
		//1. IoC 컨테이너 생성  @SpringBootApplication 역할을 함
		// java 설정파일을 기반으로 스프링 컨테이너를 생성
		ApplicationContext context =
				new AnnotationConfigApplicationContext(Config.class);
		
		//2. Member Bean 가져오기
		//주입을 먼저 받은 후 형변화 한다
		Member member1 = (Member)context.getBean("member1"); //형변환
		//객체의 정보를 toString으로 출력
		member1.print();
		
		//3. Member Bean 가져오기
		//두번째 인수를 통해 타입을 명시하면 별도의 형변환이 필요없다.
		Member member2 = context.getBean("hello", Member.class);
		member2.print();
		
		//4. PrinterB Bean 가져오기
		Printer printer = context.getBean("printerB", Printer.class);
		member1.setPrinter(printer);
		member1.print();
		
		if(member1 == member2) {
			System.out.println("동일한 객체입니다.");
		} else {
			System.out.println("서로 다른 객체입니다.");
		}
	}

}

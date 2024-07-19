import java.util.Date;

public class UnderstandDI {

	public static void main(String[] args)
	{
		Date date = new Date();
		System.out.println(date);

	}
	
	public static void getDate(Date d)
	{
		Date date = d; //약한결합
		System.out.println(date); //콘솔창에 나오지 않음
	}
	
	public static void memberUse1()
	{
		//강한결합 : 직접생성
		//생성자가 Private 으로 바뀌면 에러 발생
		Member member1 = new Member();
	}
	
	public static void memberUse2(Member m)
	{
		//약한 결합 : 생성된 것을 주입받음 - 의존 주입(Member m)
		/*
			생성자가 private 로 바뀌어도 영향을 받지 않음.
			이처럼 약한 결합을 사용하는 프로그래밍은 다른 클래스이ㅡ 변화에 더욱
			안전하고 유연하게 대처할 수 있다. 의존주입을 통해 약한 결합을 사용하는 이유.
		*/
		Member member2 = m;
	}

}

class Member{
	String name;
	String nickname;
	
	public Member() {}
	
//	private Member() {}
	
}

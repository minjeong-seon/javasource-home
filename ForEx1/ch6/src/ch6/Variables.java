package ch6;
//특문: ※ → ← ▼ ◀ ▶ ▲

//선언 위치에 따른 변수의 종류
//생성시기==사용되는 시점//
//	클래스 변수(static): 클래스가 메모리에 올라갔을 때 --클래스에 선언
//	인스턴스 변수(멤버변수): 인스턴스가 생성되었을 때 --클래스에 선언
//	지역변수: 변수 선언문이 수행되었을 때 --메소드 안에 선언

public class Variables {
	//멤버변수, 공유변수 : 클래스 아래 선언
	static int cv;  //클래스 변수(static 변수, 공유변수)
	int num;   //멤버변수(인스턴스 변수)
	
	void method(String name) {
		int tv=0;  //지역변수(메소드 안에 선언)
	}
	
	
	
	
	
	
	
	
	
	
}
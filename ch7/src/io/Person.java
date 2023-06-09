package io;

import java.io.Serializable;

//Serializable 인터페이스: 직렬화(객체를 파일에 쓰기 위함)
public class Person implements Serializable {
	private String name;
	private String job;
	
	public Person(String name, String job) {
		super();
		this.name = name;
		this.job = job;
	}
	
	@Override
	public String toString() {
		return "이름: " + name + " | 직업: " + job ;
	}
	
}

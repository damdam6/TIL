package ploymorphism02;

public class Person {
	String name = "name P초기화 - S 없음";
	String age = "age P초기화";

	public Person() {
		this.age = "P.age(생성자)";
		this.name= "P.name(생성자) - S 없음";
		System.out.println("부모생성자호출");
	}

	public Person(String name, String age) {
		this.name = name;
		this.age = age;
		System.out.println("부모생성자-매개변수호출");
	}

	public void eat() {
		System.out.println("음식을 먹는다.");
	}

}

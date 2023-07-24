package ploymorphism02;

public class Student extends Person {
	String major;
	String age = "age S초기화";

	public Student() {
		this.age = "S.age(생성자)";
		System.out.println("자식생성자호출");

	}
	
	

	public Student(String name, String age, String major) {
		super(name, age);
		this.major = major;
		System.out.println("자식생성자-매개변수super호출");
	}
	public Student(String major) {
		this.major = major;
		System.out.println("자식생성자-매개변수호출");
	}

	
	
	public void study() {
		System.out.println("공부를 한다. (자식 단독)");
	}

	
	public void eat() {
		System.out.println("학생이 음식을 먹는다.");
	}
}

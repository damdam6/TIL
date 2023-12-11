package ploymorphism02;

public class TypeCastingtest {

	public static void main(String[] args) {

		System.out.println("===p=== <기본 Person -> new Person>");
		
		
		System.out.println("[ Person p = new Person(); ]");		
		Person p = new Person();

		Object obj = p; // 자동형변환
		// 자손타입객체를 조상타입으로 형변환 가능

		// 조상타입으로 형변환시 자손타입 메소드&변수 활용불가
		/*
		 * System.out.println(obj.name); System.out.println(obj.age); obj.eat();
		 */
		
		System.out.println();
		System.out.println("[ Student st = new Student(); ]");	
		Student st = new Student();
		System.out.println("---------");
		System.out.print("p instanceof Student: ");
		System.out.println(p instanceof Student);
		System.out.print("p instanceof Person: ");
		System.out.println(p instanceof Person);
		System.out.println("");

		
		
		System.out.println("===p2===<Person -> new Student -> Student>");
		System.out.println("[ Person p2 = new Person(); ]");
		Person p2 = new Person();
		
		

		// 조상타입으로 자손을 참조하려고 했을 때 형변환 생략 불가능
		// Student st = p2;

		// 강제 형변환 자식 > 부모 > 자식만 가능

		// 불가
		// Student st = (Student) p2;

		// 가능
		System.out.println("[ Person p2_2 = new Student(); ]");
		Person p2_2 = new Student();
		System.out.println("[ Student st = (Student) p2_2; ]");
		Student st2 = (Student) p2_2;
		System.out.println("p2_2.name: "+p2_2.name);
		System.out.println("p2_2.age: "+p2_2.age);	

		
		
		System.out.println("------");
		System.out.println("st2.name: "+st2.name);
		System.out.println("st2.age: "+st2.age);
		System.out.print("st2.eat(): ");
		st2.eat();
		System.out.print("st2.study(): ");
		st2.study();
		
		System.out.println("---------");
		System.out.print("p2_2 instanceof Student: ");
		System.out.println(p2_2 instanceof Student);
		System.out.print("p2_2 instanceof Person: ");
		System.out.println(p2_2 instanceof Person);
		
		System.out.println("---------");
		System.out.print("st instanceof Student: ");
		System.out.println(st instanceof Student);
		System.out.print("st instanceof Person: ");
		System.out.println(st instanceof Person);

		System.out.println("");
		
		System.out.println("===p3===<Person -> new Student>");
		
		System.out.println("[ Person p3 = new Student(); ]");
		Person p3 = new Student();
		
		System.out.println("p3.name: "+p3.name);
		System.out.println("p3.age: "+p3.age);

		
		System.out.println("---------");
		System.out.print("p3.eat(): ");
		p3.eat();
		System.out.print("((Person) p3).eat(): ");
		((Person) p3).eat();
		System.out.println("---------");
		System.out.print("p3 instanceof Student: ");
		System.out.println(p3 instanceof Student);
		System.out.print("p3 instanceof Person: ");
		System.out.println(p3 instanceof Person);
		
		

		System.out.println("");
		System.out.println("=======================");
		System.out.println("");
		
		
			
		System.out.println("[ Person ins1 = new Person(); ]");
		Person ins1 = new Person();
		System.out.println("ins1.name: "+ins1.name);
		System.out.println("ins1.age: "+ins1.age);
		System.out.println("");
		System.out.println("[ Person ins2 = new Person(\"ins2/name\", \"ins2/age\"); ]");
		Person ins2 = new Person("ins2/name", "ins2/age");
		System.out.println("ins2.name: "+ins2.name);
		System.out.println("ins2.age: "+ins2.age);
		System.out.println("");
		System.out.println("");
		
		System.out.println("[ Person ins3 = new Student(); ]");
		Person ins3 = new Student();
		System.out.println("ins3.name: "+ins3.name);
		System.out.println("ins3.age: "+ins3.age);

		System.out.println("");
		System.out.println("[ Person ins4 = new Student(\"ins4/name\", \"ins4/age\", \"ins4/major\"); ]");
		Person ins4 = new Student("ins4/name", "ins4/age", "ins4/major");
		System.out.println("ins4.name: "+ins4.name);
		System.out.println("ins4.age: "+ins4.age);

		System.out.println("");
		System.out.println("[ Person ins5 = new Student(\"ins5/major\"); ]");
		Person ins5 = new Student("ins5/major");
		System.out.println("ins5.name: "+ins5.name);
		System.out.println("ins5.age: "+ins5.age);
		
		
		
		

	}

}

# JAVA 상속/생성자 궁금증 테스트

날짜: 2023/07/24
태그: study
세부항목: JAVA문법

JAVA 클래스 상속과 다형성에 대해 공부하던 중 생긴 궁금증에 다양한 테스트를 해보았다. 테스트 내역을 기록해둔다.

부모 클래스 : Person

자식 클래스 : Student

Main 테스트 : TypeCastingtest

### 기본적인 클래스 생성 테스트

```java
System.out.println("===p=== <기본 Person -> new Person>");
		
		System.out.println("[ Person p = new Person(); ]");		
		Person p = new Person();

		System.out.println();

		System.out.println("[ Student st = new Student(); ]");	
		Student st = new Student();

		System.out.println("---------");
		System.out.print("p instanceof Student: ");
		System.out.println(p instanceof Student);
		System.out.print("p instanceof Person: ");
		System.out.println(p instanceof Person);
		System.out.println("");
```

```
===p=== <기본 Person -> new Person>
[ Person p = new Person(); ]
부모생성자호출

[ Student st = new Student(); ]
부모생성자호출
자식생성자호출
---------
p instanceof Student: false
p instanceof Person: true
```

- 조건
    
    Person 클래스를 참조타입으로 사용 ⇒ Person 인스턴스 생성 후 주소값 할당
    
    Student 클래스를 참조타입으로 사용 ⇒ Student 인스턴스 생성 후 주소값 할당
    

- 흥미로운 점
    - 자식 클래스를 생성할 땐 부모 생성자가 먼저 사용된다.
        - 부모 생성자 ⇒ 자식 생성자 순으로 사용되며 이는 상속관계가 연달아 있어도 동일하게 작동한다.
    - 부모 클래스 인스턴스를 가리키는 p는 Student instance가 아니다. 따라서 instanceof 연산자에 false가 반환된다.

### 부모 > 자식 강제 형변환

```java
		System.out.println("===p2===<Person -> new Student -> Student>");
		System.out.println("[ Person p2 = new Person(); ]");
		Person p2 = new Person();
	
		// 조상 타입으로 자손을 참조하려고 했을 때 형변환 생략 불가능
		// Student st = p2; -> 불가

		// 강제 형변환 (원래)자식 > 부모 > 자식만 가능

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
```

```
===p2===<Person -> new Student -> Student>
[ Person p2 = new Person(); ]
부모생성자호출
[ Person p2_2 = new Student(); ]
부모생성자호출
자식생성자호출
[ Student st = (Student) p2_2; ]
p2_2.name: P.name(생성자) - S 없음
p2_2.age: P.age(생성자)
------
st2.name: P.name(생성자) - S 없음
st2.age: S.age(생성자)
st2.eat(): 학생이 음식을 먹는다.
st2.study(): 공부를 한다. (자식 단독)
---------
p2_2 instanceof Student: true
p2_2 instanceof Person: true
---------
st instanceof Student: true
st instanceof Person: true
```

- 설명
    - 자식 > 부모 > 자식
        
        ```java
        //부모클래스 참조 타입으로 student 인스턴스를 묵시적 형변환했다
        Person p2_2 = new Student();
        // Person이라는 참조타입의 p2_2 객체를 Student참조 타입의 변수에 할당했다.
        Student st2 = (Student) p2_2;
        
        //위의 두 단계를 통해 조상타입으로 자손을 참조할 때 형변환이 생략 불가능한 케이스를 테스트할 수 있었다.
        ```
        
    - 결과 살펴보기
        
        ```
        p2_2.name: P.name(생성자) - S 없음
        p2_2.age: P.age(생성자)
        ------
        st2.name: P.name(생성자) - S 없음
        st2.age: S.age(생성자)
        st2.eat(): 학생이 음식을 먹는다.
        st2.study(): 공부를 한다. (자식 단독)
        ```
        
        - p2_2의 변수는 Person의 생성자를 활용한 값이 할당된다
            
            WHY? Student의 메소드를 오버라이딩하지 않나? 변수는 왜 부모 클래스의 생성자를 사용하는가?
            
        - st2의 생성자는 Student의 생성자를 활용한 값이 할당된다.
        - 자식 클래스로 재 형변환했기 때문에 st2는 자식 클래스의 메소드를 사용할 수 있다.
            
            WHY? 자식 클래스였던 기록이 남아있기 때문에 가능한 것인가? 
            
        

### 부모 참조 타입 - 자식 인스턴스

```java
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
```

```
===p3===<Person -> new Student>
[ Person p3 = new Student(); ]
부모생성자호출
자식생성자호출
p3.name: P.name(생성자) - S 없음
p3.age: P.age(생성자)
---------
p3.eat(): 학생이 음식을 먹는다.
((Person) p3).eat(): 학생이 음식을 먹는다.
---------
p3 instanceof Student: true
p3 instanceof Person: true
```

- 설명
    - p2_2 변수와 동일한 형태의 생성이기 때문에 동일한 의문점이 있다.
        
        ```java
        		System.out.println("[ Person p3 = new Student(); ]");
        		Person p3 = new Student();
        		
        		System.out.println("p3.name: "+p3.name);
        		System.out.println("p3.age: "+p3.age);
        ```
        
        ```
        ===p3===<Person -> new Student>
        [ Person p3 = new Student(); ]
        부모생성자호출
        자식생성자호출
        p3.name: P.name(생성자) - S 없음
        p3.age: P.age(생성자)
        ```
        
        - 부모와 자식 모두 존재하는 age생성자 중 부모의 생성자가 쓰여서 해당 값이 부여되어있다.
            
            → 그런데 부모생성자/자식생성자 모두 작동하여 해당 변수가 생성되는 것 아닌가? 이해할 수 없다…
            
            클래스의 변수는 생성할 때 각각 할당 되는 위치가 다르다.
            
            P.age가 할당된 위치와 S.age가 할당된 위치가 다르다 → Person으로 객체를 지정할 땐 P.age의 변수 범위를 지정한다.
            
            → 메모리에 대한 이해가 필요하다고 한다… 어렵군.
            
    - 클래스 메소드 사용
        
        ```java
        		System.out.println("---------");
        		System.out.print("p3.eat(): ");
        		p3.eat();
        		System.out.print("((Person) p3).eat(): ");
        		((Person) p3).eat();
        ```
        
        ```
        p3.eat(): 학생이 음식을 먹는다.
        ((Person) p3).eat(): 학생이 음식을 먹는다.
        ```
        
        - eat()메소드는 Student클래스에서 오버라이딩 된 메소드이다.
            - 따라서 p3를 Person으로 강제 형변환해도 그대로 Student의 eat()메소드를 사용한다
                
                ⇒ 왜 그런지 모르겠다. 궁금하다. 
                
    
    - instanceof 판정
        
        ```java
        		System.out.println("---------");
        		System.out.print("p3 instanceof Student: ");
        		System.out.println(p3 instanceof Student);
        		System.out.print("p3 instanceof Person: ");
        		System.out.println(p3 instanceof Person);
        ```
        
        ```
        ---------
        p3 instanceof Student: true
        p3 instanceof Person: true
        ```
        
        - instanceof를 판정하는 조건은 무엇일까?
            - 형변환이 가능한 instance라는 조건을 보았다. 흠… 자식>부모 간에도 성립하니 맞는 것 같긴 하다.
            - 그럼 getClassof는 뭐지? 이때 p3는 Student로 나오는데
        

## 부모-자식 클래스 생성자 호출 테스트

자식 클래스 생성 시 부모 생성자가 호출되는 프린트를 찍어보니 다른 형태의 생성자 사용 시에도 어떤 순서로 호출되는지 궁금했다.

```java
		//부모 클래스 > 부모 클래스 / 기본 생성자
		System.out.println("[ Person ins1 = new Person(); ]");
		Person ins1 = new Person();
		System.out.println("ins1.name: "+ins1.name);
		System.out.println("ins1.age: "+ins1.age);
		System.out.println("");

		//부모 클래스 > 부모 클래스 / 매개변수 있는 생성자
		System.out.println("[ Person ins2 = new Person(\"ins2/name\", \"ins2/age\"); ]");
		Person ins2 = new Person("ins2/name", "ins2/age");
		System.out.println("ins2.name: "+ins2.name);
		System.out.println("ins2.age: "+ins2.age);
		System.out.println("");
		System.out.println("");
		

		//부모 참조 타입 > 자식 클래스 / 기본 생성자
		System.out.println("[ Person ins3 = new Student(); ]");
		Person ins3 = new Student();
		System.out.println("ins3.name: "+ins3.name);
		System.out.println("ins3.age: "+ins3.age);
		System.out.println("");

		//부모 참조 타입 > 자식 클래스 / super(매개변수) 생성자 포함 매개변수 생성자
		System.out.println("[ Person ins4 = new Student(\"ins4/name\", \"ins4/age\", \"ins4/major\"); ]");
		Person ins4 = new Student("ins4/name", "ins4/age", "ins4/major");
		System.out.println("ins4.name: "+ins4.name);
		System.out.println("ins4.age: "+ins4.age);
		System.out.println("");

		//부모 참조 타입 > 자식 클래스 / 매개변수 포함 생성자(super 미포함)
		System.out.println("[ Person ins5 = new Student(\"ins5/major\"); ]");
		Person ins5 = new Student("ins5/major");
		System.out.println("ins5.name: "+ins5.name);
		System.out.println("ins5.age: "+ins5.age);
```

```
[ Person ins1 = new Person(); ]
부모생성자호출
ins1.name: P.name(생성자) - S 없음
ins1.age: P.age(생성자)

[ Person ins2 = new Person("ins2/name", "ins2/age"); ]
부모생성자-매개변수호출
ins2.name: ins2/name
ins2.age: ins2/age

[ Person ins3 = new Student(); ]
부모생성자호출
자식생성자호출
ins3.name: P.name(생성자) - S 없음
ins3.age: P.age(생성자)

[ Person ins4 = new Student("ins4/name", "ins4/age", "ins4/major"); ]
부모생성자-매개변수호출
자식생성자-매개변수super호출
ins4.name: ins4/name
ins4.age: ins4/age

[ Person ins5 = new Student("ins5/major"); ]
부모생성자호출
자식생성자-매개변수호출
ins5.name: P.name(생성자) - S 없음
ins5.age: P.age(생성자)
```

- 설명
    - 기본적으로 부모 클래스의 생성자는 무조건 호출된다
        - 기본 생성자가 호출될 것이냐 /  super을 사용한 매개변수포함 생성자가 호출될 것이냐가 다를 뿐이다.
        - 사실 여전히 잘 모르겠다. 매개변수를 사용한 부모생성자를 호출하면 해당 값이 지정되긴 한다. 이때의 값에 대한 테스트도 추가로 가능할 듯 싶다.
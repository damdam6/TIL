# JAVA 객체지향 프로그래밍_git

날짜: 2023/07/20
태그: study
세부항목: JAVA문법

# JAVA 객체지향 프로그래밍

### static


```java
//Person 클래스 선언
package jvm;
public class Person {

	//클래스 변수 
	static int pCount;
	
	String name;
	String hobby;
	int age;
}
```

```java
package jvm;

public class PersonTest {
	public static void main(String[] args) {
		
		Person p1 = new Person();
		
		
//클래스.static변수명 -> 이런식으로 사용하라고 추천
		p1.pCount = 10;
		System.out.println(p1.pCount);
		System.out.println(Person.pCount);

		Person p2 = new Person();
		System.out.println(p2.pCount);

	}
}
```

- static 영역에서는 non-static 영역을 직접 접근이 불가능
    - static 영역 → 미리 메모리에 올라가 있음
        - 인스턴스 생성 여부와 관계x
    - non-static 영역
        - 인스턴스가 만들어져야 쓸 수 있는 것
- non-static 영역에서는 static 영역에 대한 접근이 가능
    - 메모리에 올라가 있나?를 체크해야 됨

```java
package jvm;

public class Person {

	static int pCount;
	
	String name;	
	
	public void count() {
			//non-static -> static 접근 가능
		System.out.println(pCount);
	}
	
	public static void info() {
		//불가능 static -> non-static 접근 불가
//		System.out.println(name);
	}
}
```

## 패키지

### 패키지

- PC의 많은 파일을 관리하기 위해서 폴더를 이용
- 프로그램의 많은 클래스를 관리하기 위해서 패키지 사용

- 패키지는 클래스와 관련있는 인터페이스들을 모아두기 위한 이름 공간
- 패키지 구분은 .(dot) 연산자 이용
- 패키지의 이름은 시중에 나와있는 패키지와 구분되게 지어야
    - 일반적으로 소속이나 회사의 도메인 사용

### import

- 임포트
    - 다른 패키지에 있는 클래스를 사용하기 위해서는 import 과정이 필요하다

## 제한자

### private

클래스 내부 제한

```java
// class는 public 아니면 default
public class Person {
	
	//private : 클래스 내에서만 사용할 수 있는 제한자
	private String name_private;
	private int age;

	public void info() {
		System.out.printf("이름 : %s, 나이 : %d\n", name, age);
	}
}
```

```java
package modifier01_private;

public class PersonTest {
	public static void main(String[] args) {
		Person p = new Person();
		
//private 접근 불가
//		String k = p.name_private;
		p.info();
	}
}
```

### (default)

패키지 제한

```java
package modifier02_default;

// class는 public 아니면 default
public class Person {
	String name; // 접근제한자를 생략하면, 접근제한자가 default
	int age;
	
	public void info() {
		System.out.printf("이름 : %s, 나이 : %d\n", name, age);
	}
}
```

```java
package modifier02_default;

public class PersonTest {
	public static void main(String[] args) {
		Person p = new Person();
		
//같은 패키지 내부에서는 사용가능
		p.age = 10;
		p.name = "default";
	}
}
```

- 타 패키지에서는 사용 불가
    
    ```java
    package modifier02_default2;
    
    import modifier02_default.Person;
    
    public class PersonTest {
    	public static void main(String[] args) {
    		Person p = new Person();
    		
    	}
    }
    ```
    

### protected

패키지 제한 → 상속 시에 타 패키지 사용 가능

```java
package modifier03_protected;

// class는 public 아니면 default
public class Person {
	protected String name;
	protected int age;

	public void info() {
		System.out.printf("이름 : %s, 나이 : %d\n", name, age);
	}
}
```

```java
package modifier03_protected;

public class PersonTest {
	public static void main(String[] args) {
		Person p = new Person();
		
		//다른 클래스 but 같은 패키지
		p.age = 0;
		p.name = "portected";
	}
}
```

- 다른 패키지 → 상속 시에만 가능
    
    ```java
    package modifier03_protected2;
    
    import modifier03_protected.Person;
    
    public class PersonTest {
    	public static void main(String[] args) {
    		Person p = new Person();
    		
    		//일반적으로 불가
    		//p.age = 10;
    	}
    }
    ```
    
    ```java
    package modifier03_protected2;
    
    import modifier03_protected.Person;
    
    //상속 extends
    public class Student extends Person {
    	
    	public static void main(String[] args) {
    		Student s = new Student();
    		
    		s.age = 10;
    		s.name = "protected 상속";
    	}
    	
    }
    ```
    

### public

모든 곳에서 사용 가능

```java
package modifier04_public;

// class는 public 아니면 default
public class Person {
	public String name;
	public int age;
	
	public void info() {
		System.out.printf("이름 : %s, 나이 : %d\n", name, age);
	}
}
```

```java
package modifier04_public;

public class PersonTest {
	public static void main(String[] args) {
		Person p = new Person();

		p.age = 9;
	}
}
```

```java
package modifier04_public2;

import modifier04_public.Person;

//다른 패키지 -> 임포트로 가져옴 
public class PersonTest {
	public static void main(String[] args) {
		Person p = new Person();
		p.age = 10;
	}
}
```

### 접근자(getter) / 설정자(setter)

```java
package modifier05_getter_setter;

public class Person {
	
	//일반적인 방식으로 수정 불가하게 막음
	private String name;
	private int age;
	
	
	//생성자를 이용하여 초기화 가능
	public Person() {
		
	}
	
	public Person(String name, int age) {
		
		this.name = name;
		this.age = age;
	}
	
	//setter & getter
	//메소드를 사용해 접근시키기
	
	//setter(설정자) : set멤버변수명 (국룰이자 관례)
		
	public void setName(String name) {
		this.name = name;
	}
	
	//getter(접근자): get멤버변수명 (국룰이자 관례)
	
	public String getName() {
		
		return name;
	}
	
	
	//생성자, 접근자를 통해 제한 조건을 걸어 접근을 차단할 수 ㅇ ㅣㅆ다
	public void setAge(int age) {
		
		if(age<0) {
			System.out.println("노답");
			return;
		}
		this.age = age;
	}
	
	//getter(접근자): get멤버변수명 (국룰이자 관례)
	
	public int getAge() {
		
		return this.age;
	}

	

	private boolean hungry;

	//boolean타입은 is를 쓴다(get)
	public boolean isHungry() {
		return hungry;
	}

	public void setHungry(boolean hungry) {
		this.hungry = hungry;
	}
	
}
```

```java
package modifier05_getter_setter;

public class PersonTest {
	public static void main(String[] args) {
		
		Person p = new Person();
		//일반적으로는 private 뮷 건드림
		

		
		System.out.println(	p.getName());
		p.setName("set");
		System.out.println(	p.getName());
		
		System.out.println(p.getAge());
		p.setAge(-11);
		

	}
}
```

## 싱글턴 패턴

- 무조건 딱 한 번만 생성됨
    1. 외부에서 생성하지 못하게 막아라.
        
        생성자에 접근제한자를 걸어보기
        
        - 기본생성자를 작성하고 접근제한자를 private하게 만들어라
            - 외부에서 접근불가
    2. 내가 가지고는 있어야함
        
        ⇒ 설계도 상에서 클래스를 선언해주기
        
        ⇒ new로 생성해주기
        
    3. 외부에서 나의 instance를 사용할 수 있도록 getter를 만듦
    4. 외부에서 가져다 쓰고 싶은데.. → 메모리에 미리 올려놓기(static)
        
        ⇒ 기본 생성자가 private이라 생성 불가 
        
    5. static으로 인스턴스 하나 생성 후 getInstance로 접근하기
    

```java
package modifier06_singleton;

//싱글턴 패턴 적용해보기
//
public class Person {
	
	//2.일단 가지고는 있어야 함.
	//5. getInstance(static)에서의 접근을 위해 static 설정
	private static Person instance = new Person();

	//1.외부에서 생성하지 못하게 막아라
	
	private Person() {
		
	}
	

	//3.외부에서 나의 instance를 가져다 쓸 수 있게끔
	//4. static으로 만들어서 -> 미리 메모리에 업로드
	public static Person getInstance() {
		
		//위에서 new 안썼다면 여기서 생성도 가능
/*		if(instance == null) {
			instance = new Person();
		}*/
		return  instance;
	}
}
```

```java
package modifier06_singleton;

public class PersonTest {
	public static void main(String[] args) {
		
		//기본 생성자가 private
		//Person p = new Person();
		
		Person p1 = Person.getInstance();
		Person p2 = Person.getInstance();
		
//같은 인스턴스 지정
		System.out.println(p1);
		System.out.println(p2);
	
	}
}
```

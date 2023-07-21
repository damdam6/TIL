# JAVA 상속성_git

날짜: 2023/07/21
태그: study
세부항목: JAVA문법, SSAFY
velog/blog/git: git

# Inheritance 상속

- 상속
    
    : 어떤 클래스의 특성을 그대로 갖는 새로운 클래스를 정의한 것
    

### 메소드 오버로딩

[코딩교육 티씨피스쿨](http://www.tcpschool.com/java/java_usingMethod_overloading)

---

### 자바 상속성의 특징

- **확장성, 재 사용성**
    1. 부모의 생성자와 초기화 블록은 상속X
- **클래스 선언 시 EXTEND 키워드 명시**
    1. 자바는 다중상속x
- **관계**
    1. 부모 : 상위 super 클래스
    2. 자식 : 하위 sub 클래스
    - 자식 클래스는 부모 클래스의 멤버 변수 메소드를 자신의 것처럼 사용 가능
- **object 클래스는 모든 클래스의 조상 클래스**
    - object는 왜 상속 받지 않았는데 사용 가능한가?
        - 모든 클래스의 조상님
    - java.lang.object → 이미 쓰고 있음(class 제작시)
        - import 없이 사용할 수 있는 이유
        - 먼저 java.lang.* 로딩 된 상태
- **super**

---

### super

- super을 통해 조상의 클래스에 접근 가능
    - super을 통하면 바로 윗 조상 클래스에만 접근하는 것인가?
- super()
    - 가장먼저 올려야함 -> 어떤 동작 후 super()는 불가
    - this() 생성자도 -> 어떤 동작 이후 불가
    - super()  this() : 나열 불가
- Override 가능
    - 부모 클래스의 메소드를 자식 클래스에서 재정의
        
        =/= 오버로딩(overloading) 주의할 것
        

```java
public class User {
	
	// 외부에서 객체 내부의 변수에 직접 접근하지 못하도록 접근 제한자 설정
	private String id;
	private String password;
	private String name;
	private String email;
	private int age;
	

	public User() {
					super() //부모의 기본 생성자 호출 -> 원래도 생기나 생략하는 것
}

	public User(String id, String password, String name, String email, int age) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.age = age;
	}

	public void eat(){
	sysout("냠냠")
}
}
```

```java
public class VipUser extends User {
	
	private String grade;
	private int point;
	
	
	//생성자 정의
	public VipUser() {
		super();
		//가장먼저 올려야함 -> 어떤 동작 후 super()는 불가 
		// this() 생성자도 -> 어떤 동작 이후 불가
		// super()  this() : 나열 불가
	}
	
	public VipUser(String id, String password, String name, String email, int age, String grade, int point) {
		super(id, password, name, email, age);
		this.grade = grade;
		this.point = point;
	}

	public void study(){
			super.eat()
	}

//오버라이드
@Override
	public void eat() {
sysout("먹긴 뭘 먹어")
}

}
```

- heap[ object → person → student ]

---

# Object 클래스

- equals 메서드
    - 두 객체가 같은지 비교하는 메서드
    
    | == | equals  |
    | --- | --- |
    | 주소 비교 | (임의로 객체 비교 메소드를 만들어주어야함) |
    
    ```java
    //학생 객체
    Student obj = new Student("김김", 15, "남");
    Student obj2 = new Student("이이", 15, "여");
    Student obj3 = new Student("김김", 15, "남");
    
    obj.equals(obj3) //false :  객체 자체의 주소를 먼저 비교
    
    @Override //오버라이드 오버로딩 통해서 매소드 정의해주기
    public boolean equals(Student st){
    return(this.getname().equals(st.getname()))
    }
    ```
    
    - hashCode .. 다음 주에

---

# Final 키워드

- final
    - 해당 선언이 최종 상태, 결코 수정 될 수 없음
    - final 클래스 : 상속 금지
    - final 메소드 : override 금지
    - final 변수 : 값 변경 불가
    

---

### TIP

- 하나의 java 파일에 다양한 클래스 만들 수 있다
    - 컴파일러가 java → class로 변환
        - class 수 대로 분할해서 읽음
- 단, public class는 하나
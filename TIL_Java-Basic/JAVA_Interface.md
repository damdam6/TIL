# JAVA 인터페이스 (개인 정리)

날짜: 2023/07/25
태그: study

### 인터페이스를 사용하는 이유는?

> ****인터페이스 사용 이유****
> 
> - 추상 클래스를 통해 객체들 간의 네이밍을 통일할 수 있고 이로 인해 소스의 가독성과 유지보수가 향상됩니다.
> - 확장에는 열려있고 변경에는 닫혀있는 객체 간 결합도(코드 종속성)를 낮춘 유연한 방식의 개발이 가능합니다

[[Java] 자바 인터페이스(Interface) 사용법 & 예제](https://coding-factory.tistory.com/867)

- 인터페이스
    
    통일성을 목적으로 하는 규격 제시
    
    ⇒ 공통적인 기능 명시
    
    ⇒ 인터페이스에서 제시하는 메소드는 강제로 구현해야함
    

```java
public interface Phone {
	int NameN = 22;

	String getCompany();
	String getOS();

}
```

```java
public class Galaxy implements Phone{

		public String getCompany(){
			return "Samsung";
		}
		
		public String getOS(){
			return "Android";
		}

}
```

```java
public class IPhone implements Phone{

		public String getCompany(){
			return "Apple";
		}
		
		public String getOS(){
			return "MAC";
		}

}
```

### 인터페이스의 default와 충돌

- default method
    - 조상 클래스와 동일한 이름의 인터페이스 default 메서드가 있을 경우
        
        ⇒ default 무시함
        
        **클래스의 다중상속이 불가한 이유와 동일한 충돌이 발생하긴 함.
        

```java
interface Movable{
	public abstract void move();
	public abstract void twin();
}

interface Cookable{
	public abstract void cook();
	public abstract void twin();
}

interface Chef extends Movable, Cookable{
	
	public default void info() {
		System.out.println("default 구현하기");
	}
	
	
}

class RobotFather{
	public void info() {
		System.out.println("조상 class의 메서드");
	}
}

class Robot extends RobotFather implements Chef{

	@Override
	public void move() {
		System.out.println("class에서 Override");
		
	}

	@Override
	public void cook() {
		// TODO Auto-generated method stub
		
	}

	public void twin(){
	
	System.out.println("인터페이스 다중상속 -> 정의필요함");

}
	
}

public class RootTest {
	public static void main(String[] args) {
		
		Robot r = new Robot();
		
		r.info();
		r.move();
	}
```

 

```
조상 class의 메서드
class에서 Override
```
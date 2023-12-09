# JAVA  Exception Handling

날짜: 2023/07/27

# Error의 종류

- 컴파일 에러 compile-time error
    - 컴파일 compile : 컴파일러가 코드 오류를 알려주는 것
        - 컴파일러 → 번역 과정에서 오류
    - 코드가 문법적으로 틀리다/수정할 필요가 있다.
    - EX) Syntax error : 문법 구문 오류
- 런타임 에러 runtime error
    - 프로그램 실행 중 발생하는 에러
    - 프로그래머의 설계 미숙이 대부분의 사유
- 논리적 에러 logical error
    - 프로그램이 실행하고 작동하는데는 문제가 없음
    - BUT  사용자의 의도와 다르게 작업 수행
    - 에러메시지 x

## Error vs Exception

### 자바의 오류와 예외

- 에러 error : 프로그램 코드에 의해 수습될 수 없는 오류
    - 메모리 부족, 스택오버플로우
- 예외 exception: 프로그램 코드에 의해 수습될 수 있는 오류
    
    ⇒ Exception handling 목적으로 하는 try catch문
    

## Exception Class of Java

![출처 [https://jithub.tistory.com/278](https://jithub.tistory.com/278)](JAVA%20Exception%20Handling%20953a65a06b784ab4a905c19ac3707c51/Untitled.png)

출처 [https://jithub.tistory.com/278](https://jithub.tistory.com/278)

- Throwable Class
    - Java에서의 모든 오류와 예외의 조상 클래스
    
- Error Class
    - Error 클래스는 외부적 요인으로 인해 발생하는 오류
    - 대처할 수 있는 방안이 없음
    - LinkageError | AssertionError | ThreadDeath | VirtualMachineError
    
- Exception Class
    - Checked Exception
        - 반드시 명시적인 예외처리를 해야하며 컴파일 시점에서 예외 발생과 제대로 처리했는지 확인 된다.
        - IOException SQLException
    - Unchecked Exception
        - 컴파일 후 런타임시 발생할 수 있는 예외이다. 명시적인 예외처리를 해주지 않아도 컴파일 된다.
        - NullPointerException , ArithmeticException, ArrayIndexOutOfBoundsException
    

---

### throw / throws

- 예외 던지기
    - 개발자가 의도적으로 예외를 발생 시키는 것
    - 비즈니스 로직을 구현하는 과정 중 컴파일에는 문제가 없지만 해당 로직이 개발자가 의도한 대로 통과하지 못했을 경우 고의로 예외를 발생시켜야 할 때 사용함
    - throw throws 를 통해 상위 메서드에 예외 전달 → 상위 메서드에서 try catch문 등을 사용하여 예외 처리 가능
    - 목적
        - 예외가 발생할 수 있는 코드가 있다는 것을 인지 → 예외처리 강요
        - 여러 가지 발생 가능한 예외들을 호출한 메서드에서 한 번에 처리할 수 있도록 하기
    - 발생 시킬 수 있는 예외는 Exception 클래스와 그 하위 클래스
        - 기존에 주어진 클래스 목록 중 하나를 꺼내와 제시해야함.
        
        [Exception (Java Platform SE 7 )](https://docs.oracle.com/javase/7/docs/api///java/lang/Exception.html)
        

### 참고자료

[https://jhyonhyon.tistory.com/66](https://jhyonhyon.tistory.com/66)

[https://travelbeeee.tistory.com/454](https://travelbeeee.tistory.com/454)

[https://inpa.tistory.com/entry/JAVA-☕-에러Error-와-예외-클래스Exception-💯-총정리](https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EC%97%90%EB%9F%ACError-%EC%99%80-%EC%98%88%EC%99%B8-%ED%81%B4%EB%9E%98%EC%8A%A4Exception-%F0%9F%92%AF-%EC%B4%9D%EC%A0%95%EB%A6%AC)

[https://kephilab.tistory.com/83](https://kephilab.tistory.com/83)

[http://www.tcpschool.com/java/java_exception_throw#google_vignette](http://www.tcpschool.com/java/java_exception_throw#google_vignette)
# TIL 230713

JDK : java development kit

JRE : java runtime envirnment

JVM : java virtual machine

### 변수 작명 규칙

1. 알파벳 문자와 숫자, ‘$’, ‘_’로 이루어진다 (한글이름도 가능하긴 함)
2. 중간에 공백 X
3. 첫번째 문자는 반드시 알파벳, ‘$’, ‘_’로 시작
4. 대/소문자 구별
5. 자바 언어 키워드 사용 X

### Primitive Data Type (기초형) 
논리형	boolean	true, false

문자형	char	16bit 유니코드, 0 ~ 65535

정수형	byte	8bit, -128~ 127

정수형	short	16bit, -32,768 ~ 32,767

정수형	int	32bit, 

정수형	long	64bit

실수형	float	32bit

실수형	double	64bit

↔ 참조 데이터 타입(reference type) ex)String

```
//반복문

//sysout // ctrl + space 자바 system.out.println 자동완성

int i = 10;
if((i%2)==0) {
	System.out.println(i + "-> 짝수");
}
else if(조건) {
 // if, else if, else
}
else{
	System.out.println(i + "-> 홀수");
}

boolean flag = true;
if (flag) {
	System.out.println("참");
}
else {
	System.out.println("거짓");
}

//switch 문

String test = "A";
		switch (test) {
		case "A":
			System.out.println("A");
			break; //case별로 break을 써줘야함 -> 이후 코드 모두 실행

		case "B":
			System.out.println("B");
			break;
			
		case "C":
			System.out.println("C");
			break;
			
		case 'D' :
			System.out.println("testD");
			break;
		
		
		default:
			System.out.println("안먹어");
		}
```

### 형변환 -> 추가로 공부할 것

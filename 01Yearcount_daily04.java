import java.util.Scanner;

public class Daily_04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] list;
		
		
		while(true) {
			
			System.out.print("60갑자를 입력하세요:");
			
			String GG = sc.nextLine();
			
			if(GG.equals("종료")){
				break;
			}
			else{
				
				list = GG.split("");
				int r_10 = 0;
				int r_12 = 0;
				
				switch(list[0]) {
				
				case "갑":
					r_10 = 4;
					break;
				case "을":
					r_10 = 5;
					break;
				case "병":
					r_10 = 6;
					break;
				case "정":
					r_10 = 7;
					break;
				case "무":
					r_10 = 8;
					break;
				case "기":
					r_10 = 9;
					break;
				case "경":
					r_10 = 0;
					break;
				case "신":
					r_10 = 1;
					break;
				case "임":
					r_10 = 2;
					break;
				case "계":
					r_10 = 3;
					break;
				default:
					System.out.println("잘못된 입력");
					continue;
				}
				
				
				switch(list[1]) {
				
				case "자":
					r_12 = 4;
					break;
				case "축":
					r_12 = 5;
					break;
				case "인":
					r_12 = 6;
					break;
				case "묘":
					r_12 = 7;
					break;
				case "진":
					r_12 = 8;
					break;
				case "사":
					r_12 = 9;
					break;
				case "오":
					r_12 = 0;
					break;
				case "미":
					r_12 = 1;
					break;
				case "신":
					r_12 = 2;
					break;
				case "유":
					r_12 = 3;
					break;
				case "술":
					r_12 = 4;
					break;
				case "해":
					r_12 = 5;
					break;
				default:
					System.out.println("잘못된 입력");
					continue;
				}
				
				int start_y = 0;
				
				for(int i=1800; i<1861; i++) {
					if(i%10 == r_10) {
						if(i%12 == r_12) {
							 start_y= i;
							break;
						}
					}
				}
				
				
				for(int j = start_y; j<=2100; j+=60) {
					System.out.print(j+" ");
				}
				
				System.out.println("");
				
			}
			
			
		}

		
		
		
	}
}

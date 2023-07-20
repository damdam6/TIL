
import java.util.Scanner;

public class Checkmate_04_3 {
	
	public static void main(String[] args) {
		
		//T테스트 케이스
		//N
		//white / black
		// black -> white 공격만 생각
		//가능 1 불가능 0
		//좌표는 1부터 시작
		
		Scanner sc = new Scanner(System.in);
		
		String Inxy;
		int[] WB = new int [4];
		String[] WB_s;
		int go;
		//Interger.valueOf()
		
		int T = sc.nextInt();
		
		int[] T_arr = new int[T];
		
		for(int i =0; i<T;i++) {
			
			go = 0;
			
			int n = sc.nextInt();
			
			Inxy = sc.next();
			
			WB_s = Inxy.split("");
			
			for(int j=0;j<4;j++) {
				WB[j]=Integer.valueOf(WB_s[j]);
			}
			
			//WB W가로+1 W세로+1 B가로+1 B세로+1
			
			for(int p =1; p <n+1; p++) {
				if(
						((p == WB[2])&&(WB[1]==WB[3]))||
						((WB[0] == WB[2])&&(p==WB[3]))||
						((WB[0]-p>=0)&&(WB[1]-p>=0)&&(WB[0]-p == WB[2])&&(WB[1]-p ==WB[3]))||
						((WB[0]+p<n+1)&&(WB[1]+p<n+1)&&(WB[0]+p == WB[2])&&(WB[1]+p ==WB[3]))||
						((WB[0]-p>=0)&&(WB[1]+p<n+1)&&(WB[0]-p == WB[2])&&(WB[1]+p ==WB[3]))||
						((WB[0]+p<n+1)&&(WB[1]-p>=0)&&(WB[0]+p == WB[2])&&(WB[1]-p ==WB[3]))
						
						) {
					go = 1;
				}

			}
			
			T_arr[i]=go;

		}
		
		
		for(int k = 0;k<T_arr.length;k++) {
			System.out.println("#"+(k+1)+" "+T_arr[k]);
		}
		
		
		
	}

}

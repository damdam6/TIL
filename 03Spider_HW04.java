import java.util.Arrays;
import java.util.Scanner;

public class Spider_HW04_3 {

	static int[][] F;
	static int count = 0;
	static int N;

	// 가로로 계속 거미줄 치는 메소드
//	static void web_r_R(int x, int y) {
//		
//		if(y+1<N && F[x][y+1]!=1 && F[x][y+1]!=2) {
//			F[x][y+1]=2;
//			count +=1;
//		}
//		if(y<N-2 && F[x][y+2]!=1) {
//			web_r_R(x,y+1);
//		}
//	}
//	
//	static void web_r_L(int x, int y) {
//		
//		if(y-1>=0 && F[x][y-1]!=1&&F[x][y-1]!=2) {
//			F[x][y-1]=2;
//			count +=1;
//		}
//
//		if(y-2>=0 && F[x][y-2]!=1) {
//			web_r_L(x,y-1);
//		}
//		
//
//	}
//	
//	static void web_c_U(int x, int y) {
//		
//		if(x+1<N && F[x+1][y]!=1 && F[x+1][y]!=2) {
//			F[x+1][y]=2;
//			count +=1;
//		}
//		if(x<N-2 && F[x+2][y]!=1) {
//			web_c_U(x+1,y);
//		}
//	}
//	
//	static void web_c_D(int x, int y) {
//		
//		if(x-1>=0 && F[x-1][y]!=1 && F[x-1][y]!=2) {
//			F[x-1][y]=2;
//			count +=1;
//		}
//		if(x-2>=0 && F[x-2][y]!=1) {
//			web_c_D(x-1,y);
//		}
//	}
	
	
	static void web_go(int x, int y, int x_to, int y_to) {
		
		if(x+x_to >=0 && x+x_to<N &&
				y+y_to >=0 && y+y_to<N && F[x+x_to][y+y_to]!=1 && F[x+x_to][y+y_to]!=2) {
			F[x+x_to][y+y_to]=2;
			count +=1;
		}
		
		if(x+x_to*2 >=0 && x+x_to*2<N &&
				y+y_to*2 >=0 && y+y_to*2<N  && F[x+x_to*2][y+y_to*2]!=1) {
			web_go(x+x_to,y+y_to,x_to,y_to);
		}
		
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		F = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				F[i][j] = sc.nextInt();
			}
		}
		// 0,ok, 1,no, 2, web

//		web_r_R(0, 0);
//		web_r_L(0,0);
//		web_c_U(0,0);
//		web_c_D(0,0);
		
//		web_go(0,0,0,-1);
//		web_go(0,0,0,1);
//		web_go(0,0,1,-1);
//
//		web_go(0,0,1,0);
//
//		web_go(0,0,-1,-1);
//		web_go(0,0,-1,0);
		
		web_go(0,0,1,1);
		
		System.out.println(count);

		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(F[i]));
		}

	}

}

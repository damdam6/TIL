import java.util.Arrays;
import java.util.Scanner;

/*10
1111111111
2132132122
1102121112
1211111121
3122122121
1112321111
2112113221
1221111321
1112122212
3213213213
10
D
D
R
D
D
X
D
X
U
L*/

public class Mine_05_3 {
	
	static int N;
	static int[] m_now = new int[2];
	static int[][] Rock;
	static int pop = 0;
	
	public static void xy_edit(int to_x, int to_y) {
		
		if(Rock[m_now[0]+to_x][m_now[1]+to_y] !=0 ) {
			Rock[m_now[0]+to_x][m_now[1]+to_y] = Rock[m_now[0]+to_x][m_now[1]+to_y]-1;

			
			if(Rock[m_now[0]+to_x][m_now[1]+to_y] ==0) {
				m_now[0] = m_now[0]+to_x;
				m_now[1] = m_now[1]+to_y;
				pop +=1;
			}
			
		}
		else {
			m_now[0] = m_now[0]+to_x;
			m_now[1] = m_now[1]+to_y;
		}
		
	}
	
	public static void X_d(int x, int y) {
		try {
			if(Rock[m_now[0]+x][m_now[1]+y]!=0) {
				Rock[m_now[0]+x][m_now[1]+y] = 0;
				pop+=1;
			}	
			
		}catch(Exception e){
			
		}
	}
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		Rock = new int[N][N];
		String lin = "";
		String[] arr = new String[N];

		for (int i = 0; i < N; i++) {
			lin = sc.next();
			arr = lin.split("");
			for (int k = 0; k < arr.length; k++) {
				Rock[i][k] = Integer.valueOf(arr[k]);
				
				if(Rock[i][k]==0) {
					m_now[0]=i;
					m_now[1]=k;
				}
			}
		}
		//여기까지해서 판 받음
		

		//U 상  D 하 L 좌 R 우 X다이너마이트
		//글자 길 받기

		int M = Integer.valueOf(sc.next());

		String[] root = new String[M];
		for(int i =0; i<M;i++) {
			root[i]=sc.next();
		}
		
		for(String K:root) {
						
			switch(K){
			case "U":
				xy_edit(-1,0);
				break;
			case "D":
				xy_edit(1,0);
				break;
			case "L":
				xy_edit(0,-1);
				break;
			case "R":
				xy_edit(0,1);
				break;
			case "X":
				X_d(0,1);
				X_d(1,1);
				X_d(-1,1);
				X_d(1,0);
				X_d(-1,0);
				X_d(0,-1);
				X_d(1,-1);
				X_d(-1,-1);
				break;
				
			}
			
			
		}

		
		System.out.println(Arrays.toString(m_now));
		System.out.println(pop);
		
		
		System.out.println("-----");
		
		Rock[m_now[0]][m_now[1]] = 7;
		for(int[] k:Rock) {
			System.out.println(Arrays.toString(k));
		}


	}

}

import java.util.Scanner;

public class Appletree_02_3 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] land = new int[n][n];
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				land[i][j]=sc.nextInt();
			}
		}
		
		int sum = 0;
		int max = 0;
		for(int p = 0; p <n; p++) {
			for(int q = 0; q<n; q++) {
				sum = land[p][q];

				if(p+1<n) {
					sum+=land[p+1][q];
				}
				if(p-1>=0) {
					sum+=land[p-1][q];
				}
				if(q-1>=0) {
					sum+=land[p][q-1];
				}
				if(q+1<n) {
					sum+=land[p][q+1];
				}
				
				if(sum>max) {
					max = sum;
				}

				
			}
		}
		System.out.println(max);
		
	}
}

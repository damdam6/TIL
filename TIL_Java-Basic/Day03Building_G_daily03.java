
import java.util.Scanner;

public class Building_G_03_3 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		int n = 0;
		int[] n_mx = new int[T];

		int sum = 0;
		int max = 0;

		int[] r = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] c = { -1, 0, 1, -1, 1, -1, 0, 1 };
		

		for (int i = 0; i < T; i++) {
			

			n = Integer.parseInt(sc.next());

			
			String[][] arr = new String[n][n];

			for (int p = 0; p < n; p++) {
				for (int q = 0; q < n; q++) {
					arr[p][q] = sc.next();
				}
			}
			

			max = 0;

			for (int p = 0; p < n; p++) {
				for (int q = 0; q < n; q++) {

					sum = 0;
					
					// B인 곳에만 세울 수 있음
					if (arr[p][q].equals("B")) {

k_label:				for (int k = 0; k < 6; k++) {
							
							if(p+r[k]<n&&p+r[k]>=0&& q+c[k]<n&&q+c[k]>=0)
							{
								if (arr[p+r[k]][q+c[k]].equals("G")) {
									sum = 2;

									break k_label;
							}	
								
							}
						}

						//주변에 공원이 없다면
						if (sum == 0) {						
							for(int l = 0; l<n; l++) {
								
								//B가 있는 곳 상,하
								if(arr[p][l].equals("B")) {
									sum+=1;
								}
								if(arr[l][q].equals("B")) {
									sum+=1;
								}

								//중앙겹치는곳 빼기
								
							}
							sum -=1;
						}

						if (sum > max) {
							max = sum;
						}
						

					}


				}
			}
			
			n_mx[i] = max;
			
		}
		
		for(int i =0; i<T;i++) {
			System.out.println("#"+(i+1)+" "+n_mx[i]);
		}


	}
	}


import java.util.Scanner;

public class Spider_HW04_3 {

	static int[][] F;
	static int count = 0;
	static int N;

	static void web_go(int x, int y, int x_to, int y_to) {

		if (F[x][y] == 0) {
			F[x][y] = 2;
			count += 1;
		}

		if (x + x_to >= 0 && x + x_to < N && y + y_to >= 0 && y + y_to < N && F[x + x_to][y + y_to] != 1) {

			if (F[x + x_to][y + y_to] == 0) {
				F[x + x_to][y + y_to] = 2;
				count += 1;
			}
			web_go(x + x_to, y + y_to, x_to, y_to);

		} else if (x + x_to * 2 >= 0 && x + x_to * 2 < N && y + y_to * 2 >= 0 && y + y_to * 2 < N
				&& F[x + x_to * 2][y + y_to * 2] != 1) {
			web_go(x + x_to * 2, y + y_to * 2, x_to, y_to);

		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		int[][] F_fix = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				F_fix[i][j] = sc.nextInt();
			}
		}

		// 0,ok, 1,no, 2, web

		F = new int[N][N];
		int maxC = 0;
		int max_x = 0;
		int max_y = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				count = 0;

					
					for (int tt = 0; tt < N; tt++) {
						System.arraycopy(F_fix[tt], 0, F[tt], 0, F_fix.length);
					}

					web_go(i, j, 0, -1);
					web_go(i, j, 0, 1);
					web_go(i, j, 1, -1);
					web_go(i, j, 1, 0);
					web_go(i, j, 1, 1);
					web_go(i, j, -1, -1);
					web_go(i, j, -1, 0);
					web_go(i, j, -1, 1);

					if (count > maxC) {
						maxC = count;
						max_x = i;
						max_y = j;
						
					}

			}

		}
		System.out.println("------");
		System.out.println(maxC);
		System.out.println(max_x + "," + max_y);

	}

}

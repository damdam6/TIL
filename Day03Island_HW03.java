import java.util.Scanner;

public class Island_HW03_3 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		String lin;
		String[] arr;

		// 섬 바다 맵 그리기
		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			lin = sc.next();
			arr = lin.split("");
			for (int k = 0; k < arr.length; k++) {
				map[i][k] = Integer.valueOf(arr[k]);
			}
		}

		// 각 줄마다 맥스기록
		int max_l = 1;
		int count = 1;

		for (int j = 0; j < N; j++) {
			// map[j][?]

			for (int k = 1; k < N - 1; k++) {
				count = 1;
				int t = k;
				while (map[j][t] == 0 && t < N - 1) {
					count += 1;
					t += 1;
				}
				if (count > max_l) {
					max_l = count;
				}

				count = 1;
				t = k;
				while (map[t][j] == 0 && t < N - 1) {
					count += 1;
					t += 1;
				}
				if (count > max_l) {
					max_l = count;
				}

			}

		}
		System.out.println(max_l);

	}

}



import java.util.Scanner;

public class Daily_05 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();

		int N = sc.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int min = B - arr[0];
		if (min < 0) {
			min = -min;
		}

		int check = 0;
		int time = 0;

		for (int k : arr) {
			if (B - k < 0) {
				check = -(B - k);
			} else {
				check = B - k;
			}

			if (check < min) {
				min = check;
			}
		}

		if (min > 600) {
			System.out.println(-1);
		} else {
			System.out.println(check + 1);
		}

	}

}

import java.util.Scanner;

public class Daily03_3 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요");
		System.out.println("");
		System.out.println("1.5판 3승");
		System.out.println("2.3판 2승");
		System.out.println("3.1판 1승");

		System.out.println("");
		System.out.print("번호를 입력하세요.");

		int game = sc.nextInt();
		int win_c = 0;

		switch (game) {

		case 1:
			win_c = 3;
			game = 5;
			break;
		case 2:
			win_c = 2;
			game = 3;
			break;
		case 3:
			win_c = 1;
			game = 1;
			break;
		}

		int c_win = 0;
		int p_win = 0;
		int game_count = 0;
		int com = 0;
		int pla = 0;
		;
		Scanner sc_r;
		while ((c_win < win_c) && (p_win < win_c) && (game_count != game)) {
			System.out.print("가위바위보 중 하나 입력: ");

			sc_r = new Scanner(System.in);
			String pla_s = sc_r.nextLine();

			switch (pla_s) {
			case "가위":
				pla = 1;
				break;
			case "바위":
				pla = 2;
				break;
			case "보":
				pla = 3;
				break;

			}
			com = (int) ((Math.random() * 3) + 1);

			if (com == pla) {
				System.out.println("비겼습니다!!!");
			} else if (com > pla || (com == 1 && pla == 3)) {
				System.out.println("졌습니다!!!");
				c_win += 1;
			} else {
				System.out.println("이겼습니다!!!");
				p_win += 1;
			}

			System.out.println("test " + com);
			game_count += 1;
		}

		if (c_win > p_win) {
			System.out.println("###컴퓨터 승!!!");
		} else if (p_win < c_win) {
			System.out.println("###플레이어 승!!!");
		} else {
			System.out.println("###비겼씁니다.");
		}
	}

}

package Day05.daily.step4;

import java.util.Arrays;
import java.util.Scanner;

public class RestaurantTest {

	public static void main(String[] args) {

		System.out.println("맛집 정보 등록----");

		Restaurant R1 = new Restaurant(10, "맛집1", "서울", "설렁탕", 1);
		Restaurant R2 = new Restaurant(11, "맛집2", "부산", "냉모밀", 2);
		Restaurant R3 = new Restaurant(12, "맛집3", "대전", "알밥", 3);

		System.out.println("리뷰 정보 등록 -----");
		Review Rv1 = new Review(20, 11, "글쓴이1", "맛집2 댓글test1");
		Review Rv2 = new Review(21, 11, "글쓴이2", "맛집2 댓글test2");
		Review Rv3 = new Review(22, 12, "글쓴이3", "맛집3 댓글test1");
		Review Rv4 = new Review(23, 10, "글쓴이4", "맛집1 댓글test1");
		Review Rv5 = new Review(24, 10, "글쓴이5", "맛집1 댓글test2");
		Review Rv6 = new Review(25, 10, "글쓴이6", "맛집1 댓글test3");

		RestaurantManager RM = RestaurantManager.getRM();

		RM.addRestaurant(R1);
		RM.addRestaurant(R2);
		RM.addRestaurant(R3);

		RM.addReview(Rv1);
		RM.addReview(Rv2);
		RM.addReview(Rv3);
		RM.addReview(Rv4);
		RM.addReview(Rv5);
		RM.addReview(Rv6);

		System.out.println("Res 맛집 정보 확인-----");

		for (int i = 0; i < RM.getRestaurantList().length; i++) {
			if (RM.getRestaurantList()[i] != null) {
				System.out.println(RM.getRestaurantList()[i].getResid() + "||" + RM.getRestaurantList()[i].getName()
						+ "||" + RM.getRestaurantList()[i].getSignatureMenu());
			}

		}

		System.out.println("Res 맛집 정보 수정 맛집2(냉우동)-----");
		R2.setSignatureMenu("냉우동");

		System.out.println("R2.setSignatureMenu(\"냉우동\");");

		RM.updateRestaurant(R2);

		for (int i = 0; i < RM.getRestaurantList().length; i++) {
			if (RM.getRestaurantList()[i] != null) {
				System.out.println(RM.getRestaurantList()[i].getResid() + "||" + RM.getRestaurantList()[i].getName()
						+ "||" + RM.getRestaurantList()[i].getSignatureMenu());
			}

		}

		System.out.println("맛집 정보 삭제 맛집2");
		RM.removeRestaurant(R2);
		for (int i = 0; i < RM.getRestaurantList().length; i++) {
			if (RM.getRestaurantList()[i] != null) {
				System.out.println(RM.getRestaurantList()[i].getResid() + "||" + RM.getRestaurantList()[i].getName()
						+ "||" + RM.getRestaurantList()[i].getSignatureMenu());
			}

		}

		System.out.println("맛집id로 맛집 정보 반환 10,11,12----");
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Review[] Rev_r = RM.getRestaurantReview(n);

		for (int i = 0; i < Rev_r.length; i++) {
			if (Rev_r[i] != null) {
				System.out.println("[" + Rev_r[i].getResid() + "||" + Rev_r[i].getReviewid() + "||"
						+ Rev_r[i].getWriter() + "||" + Rev_r[i].getContent() + "]");
			}

		}
		
		System.out.println("리뷰 삭제-----revid21,22,23 삭제");
		RM.removeReveiw(Rv2);
		RM.removeReveiw(Rv3);
		RM.removeReveiw(Rv4);
		
		
		System.out.println("맛집id로 맛집 정보 반환 10,11,12----");
		sc = new Scanner(System.in);

		 n = sc.nextInt();
		Rev_r = RM.getRestaurantReview(n);
		

		for (int i = 0; i < Rev_r.length; i++) {
			if (Rev_r[i] != null) {
				System.out.println("[" + Rev_r[i].getResid() + "||" + Rev_r[i].getReviewid() + "||"
						+ Rev_r[i].getWriter() + "||" + Rev_r[i].getContent() + "]");
			}

		}
		System.out.println("종료");
		
	}

}

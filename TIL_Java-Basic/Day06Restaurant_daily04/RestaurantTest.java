
package Day06Restaurant_daily04;


import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class RestaurantTest {

	public static void main(String[] args) {

		System.out.println("맛집 정보 등록----");

		Restaurant R1 = new Restaurant(10, "맛집1", "서울", "설렁탕", 1);
		Restaurant R2 = new Restaurant(11, "맛집2", "부산", "냉모밀", 2);
		Restaurant R3 = new Restaurant(12, "맛집3", "대전", "알밥", 3);
		KoreanRestaurant R4 = new KoreanRestaurant(13, "맛집4", "대구", "국수", 4, "01", "3:00");
		KoreanRestaurant R5 = new KoreanRestaurant(14, "맛집5", "전주", "비빔밥", 5, "02", "2:30");

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
		RM.addRestaurant(R4);
		RM.addRestaurant(R5);
		

		RM.addReview(Rv1);
		RM.addReview(Rv2);
		RM.addReview(Rv3);
		RM.addReview(Rv4);
		RM.addReview(Rv5);
		RM.addReview(Rv6);

		System.out.println("Res 맛집 정보 확인-----");
		System.out.println(Arrays.toString(RM.getRestaurantList()));
		System.out.println("한식집--");
		System.out.println(Arrays.toString(RM.getKoreanRestaurant()));
		System.out.println("그외--");
		System.out.println(Arrays.toString(RM.getNomRestaurant()));

		System.out.println("Res 맛집 정보 수정 맛집2(냉우동)-----");
		R2.setSignatureMenu("R2 = 냉우동");

		RM.updateRestaurant(R2);
		System.out.println(Arrays.toString(RM.getRestaurantList()));


		System.out.println("맛집 삭제할 맛집 id 입력--");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Restaurant R = RM.getRestaurant(n);

		RM.removeRestaurant(R);
		System.out.println(Arrays.toString(RM.getRestaurantList()));
		
		System.out.println("맛집 id 입력 -----");
		 sc = new Scanner(System.in);
		 n = sc.nextInt();
		 
		System.out.println("맛집id로 맛집 정보 반환 ----");
		
		System.out.println(RM.getRestaurant(n).toString());
		System.out.println("맛집id로 맛집 리뷰 반환----");
		System.out.println(Arrays.toString(RM.getRestaurantReview(n)));
		
	

		System.out.println("종료");
		
	}

}

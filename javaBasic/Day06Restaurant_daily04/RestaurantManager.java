
package Day06Restaurant_daily04;

import Day06User_HW02.User;
import Day06User_HW02.VipUser;

public class RestaurantManager {

	private static int MAX_RESTAURANT_SIZE = 100;
	private static int MAX_REVIEW_SIZE = 1000;

	private static RestaurantManager RM = new RestaurantManager();

	private Restaurant[] Res = new Restaurant[MAX_RESTAURANT_SIZE];
	private Review[] Rev = new Review[MAX_REVIEW_SIZE];

	private int rscnt = 0;
	private int rvcnt = 0;

	private RestaurantManager() {

	}

	public static RestaurantManager getRM() {

		return RM;
	}

	// Res 레스트랑 리스트 Rev 리뷰 리스트
	// 맛집 정보 등록
	public Boolean addRestaurant(Restaurant R) {
		if (rscnt < MAX_RESTAURANT_SIZE) {
			Res[rscnt] = R;
			rscnt++;
			return true;
		} else {
			System.out.println("등록불가");
			return false;
		}

	}

	// 맛집 정보 수정
	public Boolean updateRestaurant(Restaurant R) {
		for (int i = 0; i < rscnt; i++) {
			if (Res[i].getResid() == (R.getResid()) || Res[i].getName() == R.getName()
					|| Res[i].getAddress() == R.getAddress() || Res[i].getRate() == R.getRate()) {
				Res[i] = R;
				return true;
			}
		}
		return false;
	}

	// 맛집 정보 삭제
	public Boolean removeRestaurant(Restaurant R) {

		Boolean TF = false;
		for (int i = 0; i < rscnt; i++) {
			if (Res[i].equals(R)) {
				Res[i] = Res[--rscnt];
				Res[--rscnt] = null;
				TF = true;
				break;
			}
		}

		return TF;
	}

	// 맛집 리스트 반환
	public Restaurant[] getRestaurantList() {
		
		Restaurant[] ResL = new Restaurant[rscnt];
		
		for(int i = 0; i<rscnt;i++) {
			ResL[i] = Res[i];
		}
		return ResL;
	}
	
	//한식 식당
	
	
	public KoreanRestaurant[] getKoreanRestaurant() {
		
		int cnt =0;
		for(Restaurant k: this.getRestaurantList()) {
			if(k instanceof KoreanRestaurant) {
				cnt++;
			}
		}
		
		//배열생성
		KoreanRestaurant[] ResK = new KoreanRestaurant[cnt];
		for(Restaurant k: this.getRestaurantList()) {
			if(k instanceof KoreanRestaurant) {
				ResK[--cnt]= (KoreanRestaurant) k;
			}
		}
		
		return ResK;
	}

	
	public Restaurant[] getNomRestaurant() {
		
		int cnt =0;
		for(Restaurant k: this.getRestaurantList()) {
			if(k instanceof Restaurant && !(k instanceof KoreanRestaurant)) {
				cnt++;
			}
		}
		
		//배열생성
		Restaurant[] ResN = new Restaurant[cnt];
		for(Restaurant k: this.getRestaurantList()) {
			if(k instanceof Restaurant && !(k instanceof KoreanRestaurant)) {
				ResN[--cnt]= k;
			}
		}
		
		return ResN;
	}
	
	

	// 맛집 id로 맛집정보 반환
	public Restaurant getRestaurant(int resid) {
		Restaurant[] R_L = this.getRestaurantList();
		for (int i = 0; i < R_L.length; i++) {
			if (R_L[i].getResid() == resid) {
				return R_L[i];
			}
		}

		return null;

	}

	// 리뷰정보 등록
	public Boolean addReview(Review R) {
		if (rvcnt < MAX_REVIEW_SIZE) {
			Rev[rvcnt++] = R;
			return true;
		}
		return false;
	}

	// 리뷰정보 삭제
	public Boolean removeReveiw(Review R) {

		Boolean TF = false;
		for (int i = 0; i < rvcnt; i++) {
			if (Rev[i].equals(R)) {
				Rev[i] = Rev[--rvcnt];
				Rev[--rvcnt] = null;
				TF = true;
				break;
			}
		}

		return TF;
	}

	// 맛집리뷰 반환
	public Review[] getRestaurantReview(int resid) {
		int count = 0;
		Review[] residR = new Review[rvcnt];
		for (int i = 0; i < rvcnt; i++) {
			if (Rev[i].getResid() == resid) {
				residR[count] = Rev[i];
				count++;
			}
		}

		return residR;

	}
}

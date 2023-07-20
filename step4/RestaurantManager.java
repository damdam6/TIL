package Day05.daily.step4;

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

	// Res 레스트랑 리스트 Rev리뷰리스트
	// 맛집 정보 등록
	public Boolean addRestaurant(Restaurant R) {
		if (rscnt < MAX_RESTAURANT_SIZE) {
			Res[rscnt] = R;
			rscnt++;
			return true;
		}
		return false;
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
		for (int i = 0; i < MAX_RESTAURANT_SIZE; i++) {
			if (Res[i].getResid() == R.getResid()) {

				Res[i] = null;
				rscnt--;
				TF = true;
				break;
			}
		}
		return TF;
	}

	// 맛집 리스트 반환
	public Restaurant[] getRestaurantList() {
		return Res;
	}

	// 맛집 id로 맛집정보 반환
	public Restaurant getRestaurant(int resid) {
		for (int i = 0; i < MAX_RESTAURANT_SIZE; i++) {
			if (Res[i].getResid() == resid) {
				return Res[i];
			}
		}

		System.out.println("없습니다");
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
		for (int i = 0; i < MAX_REVIEW_SIZE; i++) {
			if (Rev[i]!=null && Rev[i].getReviewid() == R.getReviewid()) {
				Rev[i] = null;
				rvcnt--;
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
		for (int i = 0; i < MAX_REVIEW_SIZE; i++) {
			if (Rev[i] != null&&Rev[i].getResid() == resid) {
				residR[count] = Rev[i];
				count++;
			}
		}
		
	
		return residR;
	
	}
}


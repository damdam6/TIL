<<<<<<< HEAD


public class Review {
	

=======
package Day05.daily.step4;

public class Review {
	
>>>>>>> 9a1f1bca099c13c6f0a666380ce9954a025b72b0
	private int reviewid;
	private int resid;
	private String writer;
	private String content;
	
	//생성자
	
<<<<<<< HEAD
=======

	
>>>>>>> 9a1f1bca099c13c6f0a666380ce9954a025b72b0
	public Review(int reviewid, int resid, String writer, String content) {
		this.reviewid = reviewid;
		this.resid = resid;
		this.writer = writer;
		this.content = content;
	}
	
<<<<<<< HEAD
	//tostring 자동
	@Override
	public String toString() {
		return "Review [reviewid=" + reviewid + ", resid=" + resid + ", writer=" + writer + ", content=" + content
				+ "]";
	}
	
=======
>>>>>>> 9a1f1bca099c13c6f0a666380ce9954a025b72b0
	
	//getter and setter
	public int getReviewid() {
		return reviewid;
	}
	public void setReviewid(int reviewid) {
		this.reviewid = reviewid;
	}
	public int getResid() {
		return resid;
	}
	public void setResid(int resid) {
		this.resid = resid;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	

}

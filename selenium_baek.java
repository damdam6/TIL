package selenium_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class selenium_baek {
	public static void main(String[] args) {
		
		
		
	    System.out.println("원하는 티어를 선택해주세요.");
	    
	    System.out.println("브론즈/실버/골드/플래티넘/다이아/루비");
	    Scanner sc = new Scanner(System.in);
	    
	    String ans = sc.nextLine();
	    
	    String check = "null";
	    
	    switch(ans) {
	    
	    case "브론즈": 
	    	check = "#po-tier-f > section:nth-child(2) > div.row.visible-sm.visible-md.visible-lg.hidden-xs > div:nth-child(1) > label:nth-child(1)";
	    	break;
	    		
	    case "실버":
	    	check = "#po-tier-f > section:nth-child(2) > div.row.visible-sm.visible-md.visible-lg.hidden-xs > div:nth-child(7) > label:nth-child(1)";
	    	break;
	
	    case "골드":
	    	check = "#po-tier-f > section:nth-child(2) > div.row.visible-sm.visible-md.visible-lg.hidden-xs > div:nth-child(1) > label:nth-child(2)";
	    	break;
	    	
	    case "플래티넘":
	    	check = "#po-tier-f > section:nth-child(2) > div.row.visible-sm.visible-md.visible-lg.hidden-xs > div:nth-child(7) > label:nth-child(2)";
	    	break;
	    	
	    case "다이아":
	    	check = "#po-tier-f > section:nth-child(2) > div.row.visible-sm.visible-md.visible-lg.hidden-xs > div:nth-child(1) > label:nth-child(3)";
	    	break;
	    	
	    case "루비":
	    	check = "#po-tier-f > section:nth-child(2) > div.row.visible-sm.visible-md.visible-lg.hidden-xs > div:nth-child(7) > label:nth-child(3)";
	    	break;
	    
	    default:
	    	System.out.println("잘못된 티어입니다.");
	    	break;
	    
	    }
		
	    

		WebDriver driver = new ChromeDriver();

	    driver.get("https://www.acmicpc.net/problemset");
	    
	    //옵션 선택
	    WebElement option = driver.findElement(By.cssSelector("body > div.wrapper > div.container.content > div:nth-child(3) > div.col-md-10 > ul > li.pull-right > a"));
	    option.click();

	    WebElement chk= driver.findElement(By.cssSelector(check));
	    chk.click();
	    
	    WebElement applyBtn = driver.findElement(By.cssSelector("#po-form > footer > button:nth-child(1)"));
	    applyBtn.click();
		
		
		
		//검색페이지 결과
		WebElement pageN_t = driver.findElement(By.cssSelector("body > div.wrapper > div.container.content > div:nth-child(6) > div:nth-child(2) > div > ul"));
		
		List<WebElement> pageN = pageN_t.findElements(By.tagName("a"));
		

		//하단부 페이지 랜덤으로 고르기
		int allpg = pageN.size();
		int page = (int) (Math.random()*(allpg-1))+1;
		
		//랜덤 페이지 링크 따와서 진입

		WebElement pagego = driver.findElement(By.cssSelector("body > div.wrapper > div.container.content > div:nth-child(6) > div:nth-child(2) > div > ul > li:nth-child(" +page+") > a"));
		//신규창
		driver.get(pagego.getAttribute("href"));
		
		//신규창에서 표전체 받아오기
		WebElement ProN_t = driver.findElement(By.tagName("tbody"));
		ArrayList<WebElement> ProN = new ArrayList<WebElement>(ProN_t.findElements(By.className("list_problem_id")));
		
		int Ran_pro = (int)(Math.random()*(ProN.size()-1));
		String pro_N = "https://www.acmicpc.net/problem/"+ProN.get(Ran_pro).getText();
		
		WebDriver Propage = new ChromeDriver();
		Propage.get(pro_N);
		
	}


}

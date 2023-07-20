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
		
		
		
	    System.out.println("���ϴ� Ƽ� �������ּ���.");
	    
	    System.out.println("�����/�ǹ�/���/�÷�Ƽ��/���̾�/���");
	    Scanner sc = new Scanner(System.in);
	    
	    String ans = sc.nextLine();
	    
	    String check = "null";
	    
	    switch(ans) {
	    
	    case "�����": 
	    	check = "#po-tier-f > section:nth-child(2) > div.row.visible-sm.visible-md.visible-lg.hidden-xs > div:nth-child(1) > label:nth-child(1)";
	    	break;
	    		
	    case "�ǹ�":
	    	check = "#po-tier-f > section:nth-child(2) > div.row.visible-sm.visible-md.visible-lg.hidden-xs > div:nth-child(7) > label:nth-child(1)";
	    	break;
	
	    case "���":
	    	check = "#po-tier-f > section:nth-child(2) > div.row.visible-sm.visible-md.visible-lg.hidden-xs > div:nth-child(1) > label:nth-child(2)";
	    	break;
	    	
	    case "�÷�Ƽ��":
	    	check = "#po-tier-f > section:nth-child(2) > div.row.visible-sm.visible-md.visible-lg.hidden-xs > div:nth-child(7) > label:nth-child(2)";
	    	break;
	    	
	    case "���̾�":
	    	check = "#po-tier-f > section:nth-child(2) > div.row.visible-sm.visible-md.visible-lg.hidden-xs > div:nth-child(1) > label:nth-child(3)";
	    	break;
	    	
	    case "���":
	    	check = "#po-tier-f > section:nth-child(2) > div.row.visible-sm.visible-md.visible-lg.hidden-xs > div:nth-child(7) > label:nth-child(3)";
	    	break;
	    
	    default:
	    	System.out.println("�߸��� Ƽ���Դϴ�.");
	    	break;
	    
	    }
		
	    

		WebDriver driver = new ChromeDriver();

	    driver.get("https://www.acmicpc.net/problemset");
	    
	    //�ɼ� ����
	    WebElement option = driver.findElement(By.cssSelector("body > div.wrapper > div.container.content > div:nth-child(3) > div.col-md-10 > ul > li.pull-right > a"));
	    option.click();

	    WebElement chk= driver.findElement(By.cssSelector(check));
	    chk.click();
	    
	    WebElement applyBtn = driver.findElement(By.cssSelector("#po-form > footer > button:nth-child(1)"));
	    applyBtn.click();
		
		
		
		//�˻������� ���
		WebElement pageN_t = driver.findElement(By.cssSelector("body > div.wrapper > div.container.content > div:nth-child(6) > div:nth-child(2) > div > ul"));
		
		List<WebElement> pageN = pageN_t.findElements(By.tagName("a"));
		

		//�ϴܺ� ������ �������� ����
		int allpg = pageN.size();
		int page = (int) (Math.random()*(allpg-1))+1;
		
		//���� ������ ��ũ ���ͼ� ����

		WebElement pagego = driver.findElement(By.cssSelector("body > div.wrapper > div.container.content > div:nth-child(6) > div:nth-child(2) > div > ul > li:nth-child(" +page+") > a"));
		//�ű�â
		driver.get(pagego.getAttribute("href"));
		
		//�ű�â���� ǥ��ü �޾ƿ���
		WebElement ProN_t = driver.findElement(By.tagName("tbody"));
		ArrayList<WebElement> ProN = new ArrayList<WebElement>(ProN_t.findElements(By.className("list_problem_id")));
		
		int Ran_pro = (int)(Math.random()*(ProN.size()-1));
		String pro_N = "https://www.acmicpc.net/problem/"+ProN.get(Ran_pro).getText();
		
		WebDriver Propage = new ChromeDriver();
		Propage.get(pro_N);
		
	}


}

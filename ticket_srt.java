package selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//selenium �߰�
//���۵���̹� �߰� �ʿ�


public class ticket_srt {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://etk.srail.kr/main.do");
		
		
		WebElement departureInput = driver.findElement(By.cssSelector("#dptRsStnCd"));
		Select departure = new Select(departureInput);
		departure.selectByVisibleText("����");
		
		WebElement arrivalInput = driver.findElement(By.cssSelector("#arvRsStnCd"));
		Select arrival = new Select(arrivalInput);
//		arrival.selectByVisibleText("�λ�");
		
		//value ���� ����Ͽ� ����
		arrival.selectByValue("0020");
		
		WebElement searchBtn = driver.findElement(By.cssSelector("#search-form > fieldset > a"));
		searchBtn.click();
		

	}

}

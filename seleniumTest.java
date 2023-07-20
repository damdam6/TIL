package selenium_practice;

import java.util.ArrayList;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://naver.com");
		
		WebElement financeBtn = driver.findElement(By.cssSelector("#shortcutArea > ul > li:nth-child(6) > a"));
		financeBtn.click();
		
		//새창이 열리면 새창의 제어권을 부여해야함
		ArrayList<String> windowHandles =new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
		
		
		
		//# 아이디 선택자
		WebElement searchInput = driver.findElement(By.cssSelector("#stock_items"));

		searchInput.sendKeys("삼성전자");
		searchInput.sendKeys(Keys.ENTER);
	}

}

<<<<<<< HEAD
package selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//selenium 추가
//구글드라이버 추가 필요


public class ticket_srt {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://etk.srail.kr/main.do");
		
		
		WebElement departureInput = driver.findElement(By.cssSelector("#dptRsStnCd"));
		Select departure = new Select(departureInput);
		departure.selectByVisibleText("수서");
		
		WebElement arrivalInput = driver.findElement(By.cssSelector("#arvRsStnCd"));
		Select arrival = new Select(arrivalInput);
//		arrival.selectByVisibleText("부산");
		
		//value 값을 사용하여 지정
		arrival.selectByValue("0020");
		
		WebElement searchBtn = driver.findElement(By.cssSelector("#search-form > fieldset > a"));
		searchBtn.click();
		

	}

}
=======
package selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//selenium 추가
//구글드라이버 추가 필요


public class ticket_srt {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://etk.srail.kr/main.do");
		
		
		WebElement departureInput = driver.findElement(By.cssSelector("#dptRsStnCd"));
		Select departure = new Select(departureInput);
		departure.selectByVisibleText("수서");
		
		WebElement arrivalInput = driver.findElement(By.cssSelector("#arvRsStnCd"));
		Select arrival = new Select(arrivalInput);
//		arrival.selectByVisibleText("부산");
		
		//value 값을 사용하여 지정
		arrival.selectByValue("0020");
		
		WebElement searchBtn = driver.findElement(By.cssSelector("#search-form > fieldset > a"));
		searchBtn.click();
		

	}

}
>>>>>>> 9a1f1bca099c13c6f0a666380ce9954a025b72b0

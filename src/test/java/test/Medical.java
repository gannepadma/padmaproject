package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;




public class Medical {
	
		
	@Test
	public void createPatient() throws InterruptedException {
		
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://demo.openemr.io/a/openemr");
		driver.findElement(By.name("authUser")).sendKeys("admin");
		driver.findElement(By.name("clearPass")).sendKeys("pass");
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[3]/div[1]/div[5]/button"))).build().perform();
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[3]/div[1]/div[5]/button")).click();
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Actions act1 = new Actions(driver);
		act1.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu_logo\"]/div/div/span[5]/div/div"))).build().perform();
		driver.findElement(By.xpath("//*[@id=\"menu_logo\"]/div/div/span[5]/div/ul/li[2]/div")).click();
		
		Thread.sleep(5000);
		
		driver.switchTo().frame(driver.findElement(By.name("pat")));
		
		
		Select title = new Select(driver.findElement(By.name("form_title")));
		title.selectByIndex(3);
		driver.findElement(By.id("form_fname")).sendKeys("Big");
		driver.findElement(By.id("form_mname")).sendKeys("Heart");
		driver.findElement(By.id("form_lname")).sendKeys("Problem");
		driver.findElement(By.id("form_DOB")).click();
		Thread.sleep(5000);
		driver.findElement(By.className("xdsoft_today")).click();
		Select gender = new Select(driver.findElement(By.id("form_sex")));
		gender.selectByVisibleText("Female");
			driver.findElement(By.name("create")).click();
			driver.switchTo().defaultContent();
			
			driver.switchTo().frame(driver.findElement(By.id("modalframe")));
			driver.findElement(By.xpath("/html/body/center/input")).click();		
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
		
	}

}

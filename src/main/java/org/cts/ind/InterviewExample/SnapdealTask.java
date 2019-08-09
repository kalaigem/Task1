package org.cts.ind.InterviewExample;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.service.DriverCommandExecutor;

public class SnapdealTask {
	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\kiruba\\InterviewExample\\Driver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		WebElement textbox = driver.findElement(By.id("inputValEnter"));
		textbox.sendKeys("iphone");
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		WebElement pimg = driver.findElement(By.xpath("//img[@class='product-image ']"));
		pimg.click();
		String paranet = driver.getWindowHandle();
		System.out.println(paranet);
		Set<String> childwindow = driver.getWindowHandles();
		
		for(String s:childwindow)
		{
			if(!paranet.equals(s))
				driver.switchTo().window(s);
		}
		WebElement adcard = driver.findElement(By.xpath("//*[@id='add-cart-button-id']/span"));
		adcard.click();
		Thread.sleep(300);
		WebElement pritext = driver.findElement(By.xpath("//span[text()='Rs. 24,972']"));
		
		String text = pritext.getText();
		System.out.println("rs"+text);
		
		
				

	
}

}

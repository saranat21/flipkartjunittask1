package com.org.junit;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkart {

	static WebDriver driver;
	static long startTime;
	static String first;

	@BeforeClass
			public static void beforeClass() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver",
				"F:\\eclipse.ws\\training\\selliniumproject\\src\\web drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);

	}

	@Before
	public void beforeMethod() {

		startTime = System.currentTimeMillis();

	}

	@AfterClass
	public static void afterClass() {

		driver.quit();

	}

	@After
	public void afterMethod() {

		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");

	}

	@Test
	public void m1() throws Throwable {
		driver.findElement(By.xpath("(//input[@autocomplete='off'])[2]")).sendKeys("9597666445");
		driver.findElement(By.xpath("(//input[@autocomplete='off'])[3]")).sendKeys("vijay1995");
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		Thread.sleep(2000);

	}

	@Test
	public void m2() throws InterruptedException {

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("reamle c21y black");
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		Thread.sleep(2000);

	}

	@Test
	public void m3() throws InterruptedException {

		WebElement text = driver.findElement(By.xpath("(//*[@class='_4rR01T'])[1]"));
		first = text.getText();
		System.out.println(first);
		Thread.sleep(3000);
		text.click();
		Thread.sleep(3000);

	}

	public void windowHandle() throws InterruptedException {
		Thread.sleep(5000);
		String par = driver.getWindowHandle();
		Thread.sleep(3000);
		Set<String> child = driver.getWindowHandles();

		for (String x : child) {
			if (par.equals(x)) {
				System.out.println("tab switched");
				driver.switchTo().window(x);
			}
		}

	}

	@Test
	public void m4() throws InterruptedException {

		windowHandle();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement real = driver.findElement(By.xpath("//*[@class='B_NuCI']"));
		wait.until(ExpectedConditions.elementToBeClickable(real));
		String second = real.getText();
		System.out.println(second);

		if (first == second) {
			System.out.println("The Parent Window Name and Child Window Name are SAME");
		} else {
			System.out.println("The Parent and child Window name are NOT SAME");
		}
		WebElement down = driver.findElement(By.xpath("//*[text()='RMX3261 / RMX3263']"));
		JavascriptExecutor jsc = (JavascriptExecutor) driver;
		jsc.executeScript("arguments[0].scrollIntoView(true)", down);
		Thread.sleep(2000);

		WebElement mark = driver.findElement(By.xpath("//*[text()='Smartphones']"));
		System.out.println(mark.getText());
		Thread.sleep(3000);
		Actions ac = new Actions(driver);
		Thread.sleep(3000);
		// ac.moveToElement(mark).perform();
		ac.doubleClick(mark).build().perform();

	}

	@Test
	public void m5() throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("F:\\eclipse.ws\\training\\selliniumproject\\Screenshot\\flipkart.png");
		FileUtils.copyFile(src, des);
		
}
}



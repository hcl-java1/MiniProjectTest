package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {

	WebDriver driver;
	String id = "46";

	@BeforeMethod
	public void Setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\phan.cuong\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://localhost:3000/#");

	}

	@Test(priority = 1)
	public void TittleTest() throws InterruptedException {
		String tittle = driver.getTitle();
		System.out.println("tittle is " + tittle);
		assertEquals(tittle, "React App");
		Thread.sleep(2000);
	}

	@Test(priority = 5)
	public void AddEmployeeTest() throws InterruptedException {
		driver.findElement(By.id("addEmpBtn")).click();
		String name = "test";
		String email = "test@gmail.com";
		String address = "HN";
		String phone = "09090909";
		String dept = "Sale";

		driver.findElement(By.name("ename")).sendKeys(name);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("address")).sendKeys(address);
		driver.findElement(By.name("phone")).sendKeys(phone);
		driver.findElement(By.name("dept")).sendKeys(dept);
		driver.findElement(By.id("addButton")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 6)
	public void EditEmployeeTest() throws InterruptedException {

		driver.findElement(By.xpath("//td[text()='" + id + "']//following-sibling::td//a[@id='editButton']")).click();
		String name = "test1";
		String email = "test@gmail.com";
		String address = "HN";
		String phone = "09090909";
		String dept = "Sale";
		Thread.sleep(1000);
		driver.findElement(By.id("ename")).clear();
		Thread.sleep(500);
		driver.findElement(By.id("ename")).sendKeys(name);
		Thread.sleep(500);
		driver.findElement(By.id("email")).clear();
		Thread.sleep(500);
		driver.findElement(By.id("email")).sendKeys(email);
		Thread.sleep(500);
		driver.findElement(By.id("address")).clear();
		Thread.sleep(500);
		driver.findElement(By.id("address")).sendKeys(address);
		Thread.sleep(500);
		driver.findElement(By.id("phone")).clear();
		Thread.sleep(500);
		driver.findElement(By.id("phone")).sendKeys(phone);
		Thread.sleep(500);
		driver.findElement(By.id("dept")).clear();
		Thread.sleep(500);
		driver.findElement(By.id("dept")).sendKeys(dept);
		driver.findElement(By.id("saveEditButton")).click();
		Thread.sleep(5000);
	}

	@Test(priority = 7)
	public void DeleteTest() throws InterruptedException {

		driver.findElement(By.xpath("//td[text()='" + id + "']//following-sibling::td//a[@id='deleteButton']")).click();
		driver.findElement(By.id("comfirmDeleteButton")).click();
		Thread.sleep(5000);
	}

	@Test(priority = 8)
	public void SearchTest() throws InterruptedException {
		String searchKey = "Phan Hung Cuong";
		driver.findElement(By.id("keyword")).sendKeys(searchKey);
		driver.findElement(By.id("findbtn")).click();
		Thread.sleep(5000);
	}

	@Test(priority = 9)
	public void SearchIdTest() throws InterruptedException {
		String searchKey = "15";
		driver.findElement(By.id("keyword")).sendKeys(searchKey);
		driver.findElement(By.id("findbtn")).click();
		Thread.sleep(5000);
	}
	@Test(priority = 2)
	public void CancelButtonAddTest() throws InterruptedException {
		driver.findElement(By.id("addEmpBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("cancelButton")).click();
	}

	@Test(priority = 3)
	public void CancelButtonEditTest() throws InterruptedException {

		driver.findElement(By.xpath("//td[text()='" + id + "']//following-sibling::td//a[@id='editButton']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("cancelButton1")).click();
	}

	@Test(priority = 4)
	public void CancelButtonDeleteTest() throws InterruptedException {

		driver.findElement(By.xpath("//td[text()='" + id + "']//following-sibling::td//a[@id='deleteButton']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("cancelButton2")).click();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}

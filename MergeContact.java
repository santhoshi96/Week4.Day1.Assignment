package week4.day1.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		//username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		//password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//login button
		driver.findElement(By.className("decorativeSubmit")).click();
		//CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();
		//click Contacts
		driver.findElement(By.linkText("Contacts")).click();
		//click Merge
		driver.findElement(By.linkText("Merge Contacts")).click();
		//Click on Widget of From Contact
		driver.findElement(By.xpath("//span[text()='From Contact']/following::img")).click();
		//switch to SecondWindow
		Set<String> FindContacts = driver.getWindowHandles();
		List<String> lstWindowHandles = new ArrayList<String>(FindContacts);
		driver.switchTo().window(lstWindowHandles.get(1));
		//type contact id in Search
		String firstContact = driver.findElement(By.xpath("(//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).getText();
		WebElement firstElement = driver.findElement(By.xpath("(//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		System.out.println(firstContact);
		firstElement.click();
		//move to first Window
		driver.switchTo().window(lstWindowHandles.get(0));
		//Click on Widget of TO Contact
		driver.findElement(By.xpath("//span[text()='To Contact']/following::img")).click();
		//switch to SecondWindow
		Set<String>FindContacts2 = driver.getWindowHandles();
		List<String>lstWindowHandles2 = new ArrayList<String>(FindContacts2);
		driver.switchTo().window(lstWindowHandles2.get(1));
		//type contact id in Search
		String SecondContact = driver.findElement(By.xpath("(//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).getText();
		WebElement SecondElement = driver.findElement(By.xpath("(//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId'])[2]/a"));
		System.out.println(SecondContact);
		SecondElement.click();
		driver.switchTo().window(lstWindowHandles2.get(0));
		//click Merge
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Thread.sleep(2000);
	    //Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String Title = driver.getTitle();
		System.out.println(Title);
		Thread.sleep(2000);
		if(Title.equals("View Contact | opentaps CRM"))
		{
			System.out.println("Tile is View Contact");
		}else
		{
			System.out.println("Title is not View Contact");
		}
	}

}

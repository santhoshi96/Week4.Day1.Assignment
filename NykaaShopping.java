package week4.day1.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaShopping {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		//Mouseover on Brands
		WebElement Brands = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions Builder = new Actions(driver);
	    Builder.moveToElement(Brands).build().perform();
		//Mouseover on Popular
	    WebElement Popular = driver.findElement(By.xpath("//a[text()='Popular']"));
		Actions Builder1 = new Actions(driver);
	    Builder1.moveToElement(Popular).build().perform();
	    //Click L'Oreal Paris
	    driver.findElement(By.xpath("//img[@src='https://adn-static2.nykaa.com/media/wysiwyg/2019/lorealparis.png']")).click();
	    //Window Handles
	    Set<String> allWindows =driver.getWindowHandles();
	  	List<String> listOfWindows = new ArrayList<String>(allWindows);
	  	driver.switchTo().window(listOfWindows.get(1));
	  	//Confirm the Title 
	  	String title = driver.getTitle();
	  	if(title.contains("L'Oreal Paris"))
	  	{
	  	System.out.println("Tile is L'Oreal Paris");
	  	}
	  	//Click Sort BY
	  	driver.findElement(By.xpath("//span[text()='Sort By : ']")).click();
	  	//Click Customer Top Rated
	  	driver.findElement(By.xpath("//div[@for='3']")).click();
	  	//Click Category
	  	Thread.sleep(2000);
	  	driver.findElement(By.xpath("//div[text()='Category']")).click();
	  	//click Hair
	  	Thread.sleep(2000);
	  	driver.findElement(By.xpath("//span[text()='Hair']")).click();
	  	//Click Hair Care
	  	Thread.sleep(2000);
	  	driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
	  	//click Shampoo
	  	Thread.sleep(2000);
	  	driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
	  	String text = driver.findElement(By.xpath("//ul[@class='pull-left applied-filter-lists']/li")).getText();
	  	if(text.contains("Shampoo")) {
			System.out.println("Filtered with Shampoo");
		}
	  	//click on L'Oreal Paris Colour Protect Shampoo
	  	Thread.sleep(2000);
	  	driver.findElement(By.xpath("//span[contains(text(),'Colour Protect')][1]")).click();
	  	//GO to the new window and select size as 175ml
	  	Set<String> allWindows1 =driver.getWindowHandles();
	  	List<String> listOfWindows1 = new ArrayList<String>(allWindows1);
	  	driver.switchTo().window(listOfWindows1.get(2));
	  	driver.findElement(By.xpath("(//span[@class='size-pallets'])[2]")).click();
	  	//Print the MRP of the product
	  	String price = driver.findElement(By.xpath("//span[@class='post-card__content-price-offer']")).getText();
		price=price.replaceAll("\\D", " ");
		System.out.println("MRP of Shampoo is:"+price);
	  	//Click on ADD to BAG
		driver.findElement(By.xpath("//button[contains(@class,'combo-add-to-btn prdt-des-btn')]")).click();
	    //Go to Shopping Bag 
		driver.findElement(By.className("AddBagIcon")).click();
	    //Print the Grand Total amount
		Thread.sleep(2000);
		String grandTotal = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		grandTotal = grandTotal.replaceAll("\\D","");
		int Total = Integer.parseInt(grandTotal);
		System.out.println("Grand Total:"+Total);
	  	//Click Proceed
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[text() = 'Proceed']")).click();
	  	//Click on Continue as Guest
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[contains(@class,'btn full')])[2]")).click();
	   //Check if this grand total is the same in step 13
		Thread.sleep(2000);
		String grandTotal1 = driver.findElement(By.xpath("(//div[@class='value'])[2]/span")).getText();
		int Total1 = Integer.parseInt(grandTotal1);
		System.out.println("Guest Grand Total is:"+Total1);
		
		if(Total==Total1){
        	System.out.println("Grand Total is same");
        }
        else{
        	System.out.println("Grand Total is not same");
        }
	  	//Close all windows
		driver.quit();
	}

}

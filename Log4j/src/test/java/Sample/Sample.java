package Sample;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Sample {
	
	public static void main(String[] args) throws InterruptedException {
		
		Logger log = (Logger) LogManager.getLogger(Sample.class.getName());
		
		log.debug("Browser has Lanched");
		WebDriver driver = new ChromeDriver();
		
		log.debug("Browser has Maximized");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		log.debug("Browser has Open the URL");
		driver.get("https://omayo.blogspot.com");
		
		driver.findElement(By.xpath("//a[text()='compendiumdev']")).click();
		
		log.debug("Browser has Navigate to Back");
		driver.navigate().back();
				
		System.out.println(driver.getTitle());
		
		if((driver.getTitle()).equals("omayo (QAFox.com)"))
		{
			log.info("Passed");
		}else
		{
			log.error("Failed");
		}
		
		driver.close();
		log.debug("Browser has Closed");
	}

}

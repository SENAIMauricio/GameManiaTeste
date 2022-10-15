package testFront;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GameMania {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getenv("Driver"));
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:4200/");

	}
	
	@Test
	public void testarPagina() {
		String originalTab = driver.getWindowHandle();
		driver.findElement(By.id("login")).click();
		driver.findElement(By.id("simbolo")).click();
		driver.findElement(By.id("cadastro")).click();
		driver.findElement(By.id("logotipo")).click();
		driver.switchTo().window(originalTab);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	@After
	public void fechar() {
		driver.quit();
	}
}

package testFront;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		try {
			Thread.sleep(2000);

			driver.findElement(By.id("login")).click();
			Thread.sleep(2000);

			driver.findElement(By.id("simbolo")).click();
			Thread.sleep(2000);

			driver.findElement(By.id("cadastro")).click();
			Thread.sleep(2000);

			driver.switchTo().window(originalTab);

			
			driver.findElement(By.id("logotipo")).click();
			Thread.sleep(2000);

			driver.switchTo().alert().accept();
			
			driver.findElement(By.id("login")).click();
			Thread.sleep(2000);

			WebElement email = driver.findElement(By.id("email"));
			WebElement senha = driver.findElement(By.id("senha"));
			WebElement submit = driver.findElement(By.id("entrar"));
			String[] listaEmail = {"teste@teste", "aa@aa", "bb@bb"};
			String[] listaSenha = {"123", "abcd", "bbbb"};
			
			for (int i = 0; i < listaEmail.length; i++) {
				email.clear();
				senha.clear();
				email.sendKeys(listaEmail[i]);
				senha.sendKeys(listaSenha[i]);
				submit.click();
				Thread.sleep(2000);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	@After
	public void fechar() {
		driver.quit();
	}
}

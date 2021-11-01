package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.AdicionarItemNoCarrinhoPage;
import pages.RealizarLoginPage;

public class AdicionarItemNoCarrinhoPageTest {
	private WebDriver driver;
	private AdicionarItemNoCarrinhoPage adicionarItemNoCarrinhoPage;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		adicionarItemNoCarrinhoPage = new AdicionarItemNoCarrinhoPage(driver);		
	}
	
	@Test
	public void AdicionarItemNoCarrinho() {
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		adicionarItemNoCarrinhoPage.AdicionarItemNoCarrinho();
		//Aguardar a layer do cart
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#layer_cart > div.clearfix"))); 
		
		WebElement validaTexto = driver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > h2"));
		Assert.assertEquals("Product successfully added to your shopping cart", validaTexto.getText());
	
		validaTexto = driver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span"));
		Assert.assertEquals("Proceed to checkout", validaTexto.getText());
		
		validaTexto = driver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span > span"));
		Assert.assertEquals("Continue shopping", validaTexto.getText());
		
		
	}
	
	@After
	public void quit() {
		driver.quit();
	}
	

}

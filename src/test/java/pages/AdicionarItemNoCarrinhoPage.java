package pages;

import org.openqa.selenium.WebDriver;

import utils.Utils;

public class AdicionarItemNoCarrinhoPage {
	private WebDriver driver;
	private Utils util;
	
	public AdicionarItemNoCarrinhoPage(WebDriver driver) {
		this.driver = driver;
		util = new Utils(driver);
	}
	
	public void AdicionarItemNoCarrinho () {
		driver.get("http://automationpractice.com/index.php");
		util.clickPorCss("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default > span");
		
	}

}

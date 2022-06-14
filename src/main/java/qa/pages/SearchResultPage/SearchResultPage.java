package qa.pages.SearchResultPage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	
	@FindBy(xpath = "//*[text()='Price -- High to Low']")
	private WebElement priceHighToLow;
	
	@FindAll(@FindBy(xpath = "//*[@class='_30jeq3 _1_WHN1']"))
	private static List<WebElement> priceValues;
	
	public void clickOnHighToLow() {
		priceHighToLow.click();
	}
	
	public static List<WebElement> getProductNames() {
		return priceValues;
	}
	
	public SearchResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}

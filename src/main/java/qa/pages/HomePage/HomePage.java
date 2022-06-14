package qa.pages.HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	@FindBy(xpath = "//*[@class='_2KpZ6l _2doB4z']")
	private WebElement closeButton;
	
	@FindBy(xpath = "//*[@class='_3704LK']")
	private WebElement searchTextBox;
	
	@FindBy(xpath = "//*[@class='L0Z3Pu']")
	private WebElement searchIcon;
	
	public void clickCloseButton() {
		closeButton.click();
	}
	
	public void sendSearchItem(String SearchProduct) {
		searchTextBox.sendKeys(SearchProduct);
	}
	
	public void clickSearchIcon() {
		searchIcon.click();
	}
	
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	

}

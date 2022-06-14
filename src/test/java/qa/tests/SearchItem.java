package qa.tests;

import org.testng.annotations.Test;

import qa.base.BaseTest;
import qa.pages.HomePage.HomePage;
import qa.pages.SearchResultPage.SearchResultPage;
import qa.pages.SearchResultPage.SearchResultPageUtility;

public class SearchItem extends BaseTest{
	
	@Test
	public void searchIpad() throws InterruptedException {
		
		HomePage homePage = new HomePage(getDriver());
		SearchResultPage searchResultPage = new SearchResultPage(getDriver());
		SearchResultPageUtility searchResultPageUtility = new SearchResultPageUtility(getDriver());
		homePage.clickCloseButton();
		homePage.sendSearchItem("iPad");
		homePage.clickSearchIcon();
		searchResultPage.clickOnHighToLow();
		Thread.sleep(10000);
		//suppose checking for first 5
		System.out.println(searchResultPageUtility.getPriceList(searchResultPageUtility.getProductDetails(5)));
		
	}

}

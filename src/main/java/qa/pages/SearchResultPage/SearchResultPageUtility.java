package qa.pages.SearchResultPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPageUtility {
	
	WebDriver driver;
	
	public SearchResultPageUtility(WebDriver driver) {
		this.driver=driver;
	}
	
	public ArrayList<LinkedHashMap<String, String>> getProductDetails(int numberOfProduct){
		
		ArrayList<LinkedHashMap<String, String>> listProducts = new ArrayList<LinkedHashMap<String,String>>();
		for(int i=0;i<numberOfProduct;i++) {
			LinkedHashMap<String, String> productDetail = new LinkedHashMap<>();
			String price = SearchResultPage.getProductNames().get(i).getText().substring(1);
			String ProductName = driver.findElement(By.xpath("//*[contains(text(),'"+price+"')]/../../../../div")).getText().split("\\r?\\n")[0];
			productDetail.put(price, ProductName);
			listProducts.add(productDetail);
		}
		
		return listProducts;
	}
	
	public ArrayList<String> getPriceList(ArrayList<LinkedHashMap<String, String>> productDetails) {
		
		ArrayList<String> priceList = new ArrayList<String>();
		Iterator<LinkedHashMap<String, String>> iterator = productDetails.iterator();
		while(iterator.hasNext()) {
			priceList.add(iterator.next().entrySet().iterator().next().getKey());
		}
		return priceList;
		
	}
	
}

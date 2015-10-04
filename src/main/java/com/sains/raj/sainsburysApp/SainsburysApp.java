/**
 * 
 */
package com.sains.raj.sainsburysApp;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sains.raj.model.RipeFruit;
import com.sains.raj.service.HTMLParser;

/**
 * @author Raj_Kamal02
 *
 */
public class SainsburysApp {
	
	//this link navigate to Ripe Fruits page of sainsburys
	 private static final String link =
		        "http://www.sainsburys.co.uk/webapp/wcs/stores/servlet/" +
		        "CategoryDisplay?listView=true&orderBy=FAVOURITES_FIRST&" +
		        "parent_category_rn=12518&top_category=12518&langId=44&" +
		        "beginIndex=0&pageSize=20&catalogId=10137&searchTerm=&" +
		        "categoryId=185749&listId=&storeId=10151&promotionId=#langId=44&" +
		        "storeId=10151&catalogId=10137&categoryId=185749&" +
		        "parent_category_rn=12518&top_category=12518&pageSize=20&" +
		        "orderBy=FAVOURITES_FIRST&searchTerm=&beginIndex=0&" +
		        "hideFilters=true";

	public static void main(String[] args) {

		try {
			// here we are using google Gson to covert java object to json represantation
		
			Gson gson = new GsonBuilder()
			                .disableHtmlEscaping()
					        .setPrettyPrinting()
					        .serializeNulls()
					        .create();

			List<RipeFruit> RipeFruitproducts = HTMLParser.getRipeAndReady(link);
			
			double total = HTMLParser.FindSumOfUnitPrices(RipeFruitproducts);
			
			Map<String, Object> jsonArrayOfProducts = new LinkedHashMap<String, Object>();
			jsonArrayOfProducts.put("results", RipeFruitproducts);
			jsonArrayOfProducts.put("total", total);
			System.out.println(gson.toJson(jsonArrayOfProducts));
		} catch (Exception e) {
			e.printStackTrace(System.err);

		}
	}
}

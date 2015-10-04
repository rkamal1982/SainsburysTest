/**
 * 
 */
package com.sains.raj.service;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sains.raj.model.RipeFruit;


/**
 * @author Raj_Kamal02
 *
 */
public class HTMLParser {
	    
	
	    public static List<RipeFruit> getRipeAndReady(String link) throws IOException {
	        return getRipeAndReadyProducts(Jsoup.connect(link).get());
	    }
	    
	    
	    public static double FindSumOfUnitPrices(List<RipeFruit> RipeFruitproducts) {
	         double total=0.0;
	        for (RipeFruit product : RipeFruitproducts) {
	            total += product.getUnit_price();
	        }
	        return total;
	    }

	    static List<RipeFruit> getRipeAndReadyProducts(Document doc) throws IOException {
	        List<RipeFruit> products = new LinkedList<RipeFruit>();
	        Elements elements = getProductElements(doc);
	        for (Element element : elements) {
	            products.add(getProduct(element));
	        }
	        return Collections.unmodifiableList(products);
	    }

	    static Elements getProductElements(Document doc) {
	        return doc.select(".product");
	    }

	    static RipeFruit getProduct(Element element) throws IOException {
	        String title = getTitle(element);
	        double unitPrice = getUnitPrice(element);
	        String url = getProductUrl(element);
	        Connection.Response response = Jsoup.connect(url).execute();
	        String size = getSize(response);
	        String description = getDescription(response.parse());
	        return new RipeFruit(title,
	                           size,
	                           unitPrice,
	                           description);
	    }

	    static String getTitle(Element element) {
	        return getProductLinkElement(element).ownText();
	    }

	     static double getUnitPrice(Element element) {
	        return Double.parseDouble(
	                   element.select(".pricePerUnit")
	                     .first()
	                     .ownText()
	                     .substring(1));
	    }

	    static String getProductUrl(Element element) {
	        return getProductLinkElement(element).attributes().get("href");
	    }

	    static Element getProductLinkElement(Element element) {
	        return element.select("h3 a[href]").first();
	    }

	    static String getSize(Connection.Response response) {
	    	DecimalFormat df = new DecimalFormat("#,###,##0.00");
	        int numberOfBytes = response.bodyAsBytes().length;
	        return df.format(numberOfBytes / 1024.0) + "kb";
	    }

	    static String getDescription(Document doc) {
	        return doc.select(".productText").first().text();
	    }

}

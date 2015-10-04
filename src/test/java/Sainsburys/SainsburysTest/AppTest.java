package Sainsburys.SainsburysTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.junit.*;

import com.sains.raj.model.RipeFruit;
import com.sains.raj.service.HTMLParser;

/**
 * Unit test for sainsburys App.
 */
public class AppTest {

	private static final double DELTA = 1e-15;
	HTMLParser parser= new HTMLParser();
	@Before
	public void SetUp() {
		HTMLParser parser = new HTMLParser();
	}

	@Test
	public void FindSumOfUnitPricesTest() {
		 List<RipeFruit> products = new ArrayList<RipeFruit>();
		    products.add(new RipeFruit("Sainsbury's Avocado, Ripe & Ready x2", "3kb", 2.0, "Great to Eat"));
	        products.add(new RipeFruit("Sainsbury's Avocado, Ripe & Ready x4", "4kb", 3.0, "Good taste"));
	        assertEquals(5.0, parser.FindSumOfUnitPrices(products),DELTA);
	       
	    }
	
	
	}
	
	

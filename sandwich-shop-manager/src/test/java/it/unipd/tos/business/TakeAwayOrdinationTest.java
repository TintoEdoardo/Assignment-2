package it.unipd.tos.business;

import java.util.ArrayList;
import it.unipd.tos.model.MenuItem;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import it.unipd.tos.business.exception.TakeAwayBillException;

public class TakeAwayOrdinationTest {

 @Test
 public void SumOfElements_EmptyList_ReturnZero() {
 TakeAwayOrdination ordination = new TakeAwayOrdination();
  
  ArrayList<MenuItem> listItem = new ArrayList<MenuItem>();
  
  double recipie = ordination.SumAllElementsPrice(listItem);
  
  assertEquals(0.0, recipie, 0);
 }
 
 @Test
 public void SumOfElements_NotEmptyList_Return1() {
	 TakeAwayOrdination ordination = new TakeAwayOrdination();
	  
	  ArrayList<MenuItem> listItem = new ArrayList<MenuItem>();
	  
	  MenuItem coca = new MenuItem();
	  coca.price = 1.0;
	  
	  listItem.add(coca);
	  
	  double recipie = ordination.SumAllElementsPrice(listItem);
	  
	  assertEquals(1.0, recipie, 0);
	 }
}

////////////////////////////////////////////////////////////////////
// Edoardo Tinto 1170904
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;

public class TakeAwayOrdination implements TakeAwayBill {
 
 public double SumAllElementsPrice(List<MenuItem> itemsOrdered)
 {
  double SumOfAllElements = 0;
  if(!itemsOrdered.isEmpty())
  {
   for(MenuItem i : itemsOrdered)
   {
    SumOfAllElements += i.price;
   }
  }
  return SumOfAllElements;
 }
 
 @Override
 public double getOrderPrice(List<MenuItem> itemsOrdered)
   throws TakeAwayBillException {
 
 return 0;
 }

}

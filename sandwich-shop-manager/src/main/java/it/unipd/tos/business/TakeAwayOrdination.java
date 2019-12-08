////////////////////////////////////////////////////////////////////
// Edoardo Tinto 1170904
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;
import java.util.ArrayList;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItem.elementType;

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
 
 public ArrayList<MenuItem> FindAllBurgers(List<MenuItem> itemsOrdered)
 {
  ArrayList<MenuItem> burgerList = new ArrayList<MenuItem>();
  
   for(MenuItem i : itemsOrdered)
   {
    if(i.itemType == elementType.Panini)
    {
     burgerList.add(i);
    }
   }
   return burgerList;
 }
 
 public MenuItem FindLessExpensiveBurger(List<MenuItem> itemsOrdered)
 {
  MenuItem cheapestBurger;
  ArrayList<MenuItem> burgerList = FindAllBurgers(itemsOrdered);
  if(burgerList.isEmpty())
  {
   cheapestBurger = null;
  }
  else
  {
   cheapestBurger = burgerList.get(0);
   for(MenuItem i : itemsOrdered)
   {
    if(i.price < cheapestBurger.price)
    {
     cheapestBurger = i;
    }
   }
  }
  return cheapestBurger;
 }
 
 public double ApplyDiscount(List<MenuItem> itemsOrdered) {
  ArrayList<MenuItem> burgerList = FindAllBurgers(itemsOrdered);
  if(burgerList.size() > 4)
  {
  double discount = FindLessExpensiveBurger(burgerList).price / 2;
  
  return SumAllElementsPrice(itemsOrdered) - discount;
  }
  else
  {
   return SumAllElementsPrice(itemsOrdered);
  }
 }
 
 public double DiscoutOver50Euros(List<MenuItem> itemsOrdered) {
  double previousPrice = SumAllElementsPrice(itemsOrdered);
  double discount = 0;
  if(previousPrice > 50)
  {
   discount = previousPrice / 10;
  }
  double actualPrice = previousPrice - discount;

  return actualPrice;
 }
 
 public void OrderValidation(List<MenuItem> itemsOrdered) 
    throws TakeAwayBillException{
  if(itemsOrdered.size() > 30)
  {
   throw new TakeAwayBillException("Too many items");
  }
 }
 
 @Override
 public double getOrderPrice(List<MenuItem> itemsOrdered)
   throws TakeAwayBillException {
 
 return 0;
 }

}

package it.unipd.tos.business;

import java.util.ArrayList;
import java.util.List;

import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItem.elementType;

import static org.junit.Assert.*;
import org.junit.Test;
import it.unipd.tos.business.exception.TakeAwayBillException;

public class TakeAwayOrdinationTest {

 //-------- First Issue --------\\
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
 
 //-------- Second Issue --------\\
 
 @Test
 public void FindAllBurgers_NoBurgerList_ReturnEmptyList() {
  TakeAwayOrdination ordination = new TakeAwayOrdination();
  
  ArrayList<MenuItem> listItem = new ArrayList<MenuItem>();
  
  MenuItem water = new MenuItem();
  
  listItem.add(water);
  
  ArrayList<MenuItem> noBurgerList = ordination.FindAllBurgers(listItem);
  assertTrue(noBurgerList.isEmpty());
 }
 
 @Test
 public void FindAllBurgers_OneBurgerList_ReturnNotEmptyList() {
  TakeAwayOrdination ordination = new TakeAwayOrdination();
  
  ArrayList<MenuItem> listItem = new ArrayList<MenuItem>();
  
  MenuItem vegetariano = new MenuItem(elementType.Panini, "vegetariano", 2.5);
  
  listItem.add(vegetariano);
  
  ArrayList<MenuItem> BurgerList = ordination.FindAllBurgers(listItem);
  assertFalse(BurgerList.isEmpty());
 }
 
 @Test
 public void FindLessExpensiveBurger_EmptyList_Exception() {
  TakeAwayOrdination ordination = new TakeAwayOrdination();
  
  ArrayList<MenuItem> listItem = new ArrayList<MenuItem>();

  MenuItem water = new MenuItem();
  
  listItem.add(water);
  
  MenuItem nullItem = ordination.FindLessExpensiveBurger(listItem);
  assertEquals(null, nullItem);
 }
 
 @Test
 public void FindLessExpensiveBurger_BurgersList_CheapestBurger() {
  TakeAwayOrdination ordination = new TakeAwayOrdination();
  
  ArrayList<MenuItem> listItem = new ArrayList<MenuItem>();

  MenuItem primavera = new MenuItem(elementType.Panini, "primavera", 2.0);
  MenuItem vegetariano = new MenuItem(elementType.Panini, "vegetariano", 2.5);
 
  listItem.add(vegetariano);
  listItem.add(primavera); 
  
  MenuItem cheapestBurger = new MenuItem();
  
  cheapestBurger = ordination.FindLessExpensiveBurger(listItem);
  assertEquals(primavera, cheapestBurger);
 }
 
 @Test
 public void ApplyDiscount_FiveBurgers_Discounted() {
  TakeAwayOrdination ordination = new TakeAwayOrdination();
  
  ArrayList<MenuItem> listItem = new ArrayList<MenuItem>();
  
  MenuItem primavera = new MenuItem(elementType.Panini, "primavera", 2.0);
  MenuItem vegetariano = new MenuItem(elementType.Panini, "vegetariano", 2.5);
  MenuItem vegano = new MenuItem(elementType.Panini, "vegano", 2.5);
  MenuItem sopressa = new MenuItem(elementType.Panini, "sopressa", 3.5);
  MenuItem toast = new MenuItem(elementType.Panini, "toast", 3.5);
  
  listItem.add(vegetariano);
  listItem.add(primavera); 
  listItem.add(vegano);
  listItem.add(sopressa); 
  listItem.add(toast);
  
  double ordinationPriceDiscounted = ordination.ApplyDiscount(listItem);
  
  assertEquals(13.0, ordinationPriceDiscounted, 0);
 }
 
 @Test
 public void ApplyDiscount_NoBurgers_Discounted() {
  TakeAwayOrdination ordination = new TakeAwayOrdination();
	  
  ArrayList<MenuItem> listItem = new ArrayList<MenuItem>();
  
  MenuItem water = new MenuItem();
  
  listItem.add(water);
  
  double ordinationPriceDiscounted = ordination.ApplyDiscount(listItem);
  
  assertEquals(0.0, ordinationPriceDiscounted, 0);
 }
 
 //-------- Third Issue --------\\
 
 @Test
 public void DiscountOver50Euros_LessThen50_SumOfAlPrice() {
  TakeAwayOrdination ordination = new TakeAwayOrdination();
	  
  ArrayList<MenuItem> listItem = new ArrayList<MenuItem>();
  
  MenuItem angusPremium = new MenuItem(elementType.Panini, "Angus Premium", 20.0);
  
  listItem.add(angusPremium);
  
  double ordinationPriceNoDiscounted = ordination.DiscoutOver50Euros(listItem);
  
  assertEquals(20.0, ordinationPriceNoDiscounted, 0);
 }
 
 @Test
 public void DiscountOver50Euros_MoreThen50_AppliedDiscount() {
  TakeAwayOrdination ordination = new TakeAwayOrdination();
	  
  ArrayList<MenuItem> listItem = new ArrayList<MenuItem>();
  
  MenuItem angusPremium = new MenuItem(elementType.Panini, "Angus Premium", 20.0);
  MenuItem fritturaImperiale = new MenuItem(elementType.Fritti, "Frittura Imperiale", 35.0);
  
  listItem.add(angusPremium);
  listItem.add(fritturaImperiale);
  
  double ordinationPriceDiscounted = ordination.DiscoutOver50Euros(listItem);
  
  assertEquals(49.5, ordinationPriceDiscounted, 0);
 }
 
 //-------- Fourth Issue --------\\
 @Test
 public void OrderValidation_TooMuchItems_Exception() {
  TakeAwayOrdination ordination = new TakeAwayOrdination();
  
  ArrayList<MenuItem> listItem = new ArrayList<MenuItem>();
  
  MenuItem tmp = new MenuItem();
  
  for(int i = 0; i < 31; i++) {
   listItem.add(tmp);
  }
  
  try {
   ordination.OrderValidation(listItem);
  }
  catch(TakeAwayBillException exception)
  {
   assertEquals("Too many items", exception.errorMessage);
  }
 }
 
 @Test
 public void OrderValidation_LessThe30Items_NoOutput() {
  TakeAwayOrdination ordination = new TakeAwayOrdination();
  
  ArrayList<MenuItem> listItem = new ArrayList<MenuItem>();
  
  MenuItem water = new MenuItem();
  
  listItem.add(water);
  
  boolean test = false;
  try {
   ordination.OrderValidation(listItem);
   test = true;
  }
  catch(TakeAwayBillException exception) {}
  
  assertTrue(test);
 }
 
 //-------- Fifth Issue --------\\
 @Test
 public void AddCommission_LessThen10Euros_AddCommission() {
  TakeAwayOrdination ordination = new TakeAwayOrdination();
  
  ArrayList<MenuItem> listItem = new ArrayList<MenuItem>();
  
  MenuItem water = new MenuItem();
  
  listItem.add(water);
  
  double ordinationPrice = ordination.AddCommission(listItem);
  
  assertEquals(0.5, ordinationPrice, 0);
 }
 
 @Test
 public void AddCommission_MoreThen10Euros_ordinationPrice() {
  TakeAwayOrdination ordination = new TakeAwayOrdination();
  
  ArrayList<MenuItem> listItem = new ArrayList<MenuItem>();
  
  MenuItem angusPremium = new MenuItem(elementType.Panini, "Angus Premium", 20.0);
  
  listItem.add(angusPremium);
  
  double ordinationPrice = ordination.AddCommission(listItem);
  
  assertEquals(20.0, ordinationPrice, 0);
 }
 
}

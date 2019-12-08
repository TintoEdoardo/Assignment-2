package it.unipd.tos.model;

import static org.junit.Assert.*;

import org.junit.Test;

import it.unipd.tos.model.MenuItem.elementType;

public class MenuItemTest {

 @Test
 public void MenuItem_ConstructorParameters_Success() {
  MenuItem item = new MenuItem();

  assertNotNull(item);
 }
 
 @Test
 public void MenuItem_DefaultConstructor_Succes() {
  MenuItem item = new MenuItem(elementType.Bevande, "pepsi", 1.5);
  
  assertNotNull(item);
 }
 
}

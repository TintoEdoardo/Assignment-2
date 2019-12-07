////////////////////////////////////////////////////////////////////
// Edoardo Tinto 1170904
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

public class MenuItem {

 public MenuItem() {
  itemType = elementType.Bevande;
  name = "Acqua";
  price = 0;
 }
 
 public enum elementType {
  Panini,
  Fritti,
  Bevande
 }

 public elementType itemType;
 public String name;
 public double price;
}

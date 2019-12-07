////////////////////////////////////////////////////////////////////
// Edoardo Tinto 1170904
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business.exception;

public class TakeAwayBillException extends Exception {

 public TakeAwayBillException(String errorString){
  errorMessage = errorString;
 }
 
 public String errorMessage;
 
 private static final long serialVersionUID = 1L;
}

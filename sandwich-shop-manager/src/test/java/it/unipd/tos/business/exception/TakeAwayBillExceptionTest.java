package it.unipd.tos.business.exception;

import static org.junit.Assert.*;

import org.junit.Test;

public class TakeAwayBillExceptionTest {

	@Test
	public void TakeAwayBillException_Constructor_Success() {
		TakeAwayBillException exception = new TakeAwayBillException("Exception content");
		assertEquals("Exception content", exception.errorMessage);
	}

}

package test.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import entities.Financing;

public class FinancingTests {
	
	@Test
	public void constructorShouldCreateNewObjectWhenDataValid() {
		Financing financing = new Financing(1000.0, 5000.0, 24);
		assertEquals(1000.0, financing.getTotalAmount());
		assertEquals(5000.0, financing.getIncome());
		assertEquals(24, financing.getMonths());
	}
	
	@Test
	public void constructorShouldThrowExceptionWhenDataInvalid() {
		
		assertThrows(IllegalArgumentException.class, () -> new Financing(50000.0, 1000.0, 24));
	}
}

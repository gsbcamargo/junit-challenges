package test.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import entities.Financing;

public class FinancingTests {
	
	@Test
	public void constructorShouldCreateNewObjectWhenDataValid() {
		Double totalAmount = 1000.0;
		Double income = 5000.0;
		Integer months = 24;
		
		Financing financing = new Financing(totalAmount, income, months);
		
		assertEquals(1000.0, financing.getTotalAmount());
		assertEquals(5000.0, financing.getIncome());
		assertEquals(24, financing.getMonths());
	}
	
	@Test
	public void constructorShouldThrowExceptionWhenDataInvalid() {
		Double totalAmount = 5000.0;
		Double income = 1000.0;
		Integer months = 5;
		
		assertThrows(IllegalArgumentException.class, () -> new Financing(totalAmount, income, months));
	}
}

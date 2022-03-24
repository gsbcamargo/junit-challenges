package test.entities;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import entities.Financing;

public class FinancingTests {

	@Test
	public void constructorShouldCreateNewObjectWhenDataValid() {
		Double totalAmount = 10000.0;
		Double income = 5000.0;
		Integer months = 24;

		Financing financing = new Financing(totalAmount, income, months);

		assertEquals(totalAmount, financing.getTotalAmount());
		assertEquals(income, financing.getIncome());
		assertEquals(months, financing.getMonths());
	}

	@Test
	public void constructorShouldThrowExceptionWhenDataInvalid() {
		Double totalAmount = 5000.0;
		Double income = 1000.0;
		Integer months = 5;

		assertThrows(IllegalArgumentException.class, () -> new Financing(totalAmount, income, months));
	}

	@Test
	public void setTotalAmountShouldUpdateTotalAmountWhenDataValid() {
		Double totalAmount = 10000.0;
		Double income = 5000.0;
		Integer months = 24;
		Double updatedTotalAmount = 1200.0;

		Financing financing = new Financing(totalAmount, income, months);

		financing.setTotalAmount(updatedTotalAmount);

		assertTrue(financing.getTotalAmount() == updatedTotalAmount);
	}

	@Test
	public void setTotalAmountShouldThrowExceptionWhenDataInvalid() {
		Double totalAmount = 10000.0;
		Double income = 5000.0;
		Integer months = 24;
		Double updatedTotalAmount = 120000.0;

		assertThrows(IllegalArgumentException.class, () -> {
			Financing financing = new Financing(totalAmount, income, months);
			financing.setTotalAmount(updatedTotalAmount);
		});
	}

	@Test
	public void setIncomeShouldUpdateIncomeWhenDataValid() {
		Double totalAmount = 10000.0;
		Double income = 5000.0;
		Integer months = 24;
		Double updatedIncome = 12000.0;

		Financing financing = new Financing(totalAmount, income, months);

		financing.setIncome(updatedIncome);

		assertTrue(financing.getIncome() == updatedIncome);
	}

	@Test
	public void setIncomeShouldThrowExceptionWhenDataInvalid() {
		Double totalAmount = 10000.0;
		Double income = 5000.0;
		Integer months = 24;
		Double updatedIncome = 10.0;

		assertThrows(IllegalArgumentException.class, () -> {
			Financing financing = new Financing(totalAmount, income, months);
			financing.setIncome(updatedIncome);
		});
	}
	
	@Test
	public void setMonthsShouldUpdateMonthsWhenDataValid() {
		Double totalAmount = 100000.0;
		Double income = 5000.0;
		Integer months = 48;
		Integer updatedMonths = 36;

		Financing financing = new Financing(totalAmount, income, months);

		financing.setMonths(updatedMonths);

		assertTrue(financing.getMonths() == updatedMonths);
	}
	
	@Test
	public void setMonthsShouldThrowExceptionWhenDataInvalid() {
		Double totalAmount = 100000.0;
		Double income = 5000.0;
		Integer months = 48;
		Integer updatedMonths = 12;
		
		assertThrows(IllegalArgumentException.class, () -> {
			Financing financing = new Financing(totalAmount, income, months);
			financing.setMonths(updatedMonths);
		});
	}
	
	@Test
	public void entryShouldCalculateCorrectly() {
		Double totalAmount = 100000.0;
		Double income = 5000.0;
		Integer months = 48;
		
		Financing financing = new Financing(totalAmount, income, months);
		
		assertEquals(financing.entry(), (totalAmount * 0.2));
	}
	
	@Test
	public void quotaShouldCalculateCorrectly() {
		Double totalAmount = 100000.0;
		Double income = 5000.0;
		Integer months = 48;
		
		Financing financing = new Financing(totalAmount, income, months);
		
		assertEquals(financing.quota(), (totalAmount - financing.entry()) / months);
	}
}

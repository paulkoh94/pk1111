package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import main.models.RentalAgreement;
import main.util.CheckoutUtils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckoutTest {
	CheckoutUtils checkoutUtils;
	
	@BeforeEach
	void setUp() {
		checkoutUtils = new CheckoutUtils();
	}
	
	@Test
	void test1() throws Exception {
		//Entering a percent value 101 should throw an exception
		Throwable exception = assertThrows(Exception.class,
				()-> checkoutUtils.generateRentalAgreement("JAKR", LocalDate.of(2015, 9, 3), 5, 101));
		assertEquals("Invalid discount percent", exception.getMessage());
	}
	
	@Test
	void test2() throws Exception {
		var rentalAgreement = checkoutUtils.generateRentalAgreement("LADW", LocalDate.of(2020, 7, 2), 3, 10);
		
		assertEquals("LADW", rentalAgreement.getToolCode());
		assertEquals("Ladder", rentalAgreement.getToolType());
		assertEquals("Werner", rentalAgreement.getToolBrand());
		assertEquals(3, rentalAgreement.getRentalDaysCount());
		assertEquals(LocalDate.of(2020, 7, 2), rentalAgreement.getCheckoutDate());
		assertEquals(LocalDate.of(2020, 7, 5), rentalAgreement.getDueDate());
		assertEquals(1.99, rentalAgreement.getDailyRentalCharge());
		assertEquals(2, rentalAgreement.getChargeDays());
		assertEquals(3.98, rentalAgreement.getPreDiscountCharge());
		assertEquals(10, rentalAgreement.getDiscountPercent());
		assertEquals(3.98 * 10 / 100, rentalAgreement.getDiscountAmount());
		assertEquals(3.98 - (3.98 * 10 / 100), rentalAgreement.getFinalCharge());
	}
	
	@Test
	void test3() throws Exception {
		var rentalAgreement = checkoutUtils.generateRentalAgreement("CHNS", LocalDate.of(2015, 7, 2), 5, 25);
		
		assertEquals("CHNS", rentalAgreement.getToolCode());
		assertEquals("Chainsaw", rentalAgreement.getToolType());
		assertEquals("Stihl", rentalAgreement.getToolBrand());
		assertEquals(5, rentalAgreement.getRentalDaysCount());
		assertEquals(LocalDate.of(2015, 7, 2), rentalAgreement.getCheckoutDate());
		assertEquals(LocalDate.of(2015, 7, 7), rentalAgreement.getDueDate());
		assertEquals(1.49, rentalAgreement.getDailyRentalCharge());
		assertEquals(3, rentalAgreement.getChargeDays());
		assertEquals(4.47, rentalAgreement.getPreDiscountCharge());
		assertEquals(25, rentalAgreement.getDiscountPercent());
		assertEquals(4.47 * 25 / 100, rentalAgreement.getDiscountAmount());
		assertEquals(4.47 - (4.47 * 25 / 100), rentalAgreement.getFinalCharge());
	}

	@Test
	void test4() throws Exception {
		var rentalAgreement = checkoutUtils.generateRentalAgreement("JAKD", LocalDate.of(2015, 9, 3), 6, 0);
		
		assertEquals("JAKD", rentalAgreement.getToolCode());
		assertEquals("Jackhammer", rentalAgreement.getToolType());
		assertEquals("DeWalt", rentalAgreement.getToolBrand());
		assertEquals(6, rentalAgreement.getRentalDaysCount());
		assertEquals(LocalDate.of(2015, 9, 3), rentalAgreement.getCheckoutDate());
		assertEquals(LocalDate.of(2015, 9, 9), rentalAgreement.getDueDate());
		assertEquals(2.99, rentalAgreement.getDailyRentalCharge());
		assertEquals(3, rentalAgreement.getChargeDays());
		assertEquals(8.97, rentalAgreement.getPreDiscountCharge());
		assertEquals(0, rentalAgreement.getDiscountPercent());
		assertEquals(0, rentalAgreement.getDiscountAmount());
		assertEquals(8.97, rentalAgreement.getFinalCharge());
	}
	
	@Test
	void test5() throws Exception {
		var rentalAgreement = checkoutUtils.generateRentalAgreement("JAKR", LocalDate.of(2015, 7, 2), 9, 0);
		
		assertEquals("JAKR", rentalAgreement.getToolCode());
		assertEquals("Jackhammer", rentalAgreement.getToolType());
		assertEquals("Ridgid", rentalAgreement.getToolBrand());
		assertEquals(9, rentalAgreement.getRentalDaysCount());
		assertEquals(LocalDate.of(2015, 7, 2), rentalAgreement.getCheckoutDate());
		assertEquals(LocalDate.of(2015, 7, 11), rentalAgreement.getDueDate());
		assertEquals(2.99, rentalAgreement.getDailyRentalCharge());
		assertEquals(5, rentalAgreement.getChargeDays());
		assertEquals(2.99 * 5, rentalAgreement.getPreDiscountCharge());
		assertEquals(0, rentalAgreement.getDiscountPercent());
		assertEquals(0, rentalAgreement.getDiscountAmount());
		assertEquals(2.99 * 5 - ((2.99 * 5) * 0), rentalAgreement.getFinalCharge());
	}
	
	@Test
	void test6() throws Exception {
		var rentalAgreement = checkoutUtils.generateRentalAgreement("JAKR", LocalDate.of(2020, 7, 2), 4, 50);
		
		assertEquals("JAKR", rentalAgreement.getToolCode());
		assertEquals("Jackhammer", rentalAgreement.getToolType());
		assertEquals("Ridgid", rentalAgreement.getToolBrand());
		assertEquals(4, rentalAgreement.getRentalDaysCount());
		assertEquals(LocalDate.of(2020, 7, 2), rentalAgreement.getCheckoutDate());
		assertEquals(LocalDate.of(2020, 7, 6), rentalAgreement.getDueDate());
		assertEquals(2.99, rentalAgreement.getDailyRentalCharge());
		assertEquals(1, rentalAgreement.getChargeDays());
		assertEquals(2.99 * 1, rentalAgreement.getPreDiscountCharge());
		assertEquals(50, rentalAgreement.getDiscountPercent());
		assertEquals((2.99 * 1) * 50 / 100, rentalAgreement.getDiscountAmount());
		assertEquals(2.99 * 1 - ((2.99 * 1) * 50 / 100), rentalAgreement.getFinalCharge());
	}
}

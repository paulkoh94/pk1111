package main.checkout;

import java.time.LocalDate;

import main.models.RentalAgreement;

import main.util.CheckoutUtils;

public class Checkout {
	private CheckoutUtils checkoutUtils = new CheckoutUtils();
	
	public RentalAgreement checkout() throws Exception {
		RentalAgreement rentalAgreement = this.checkoutUtils.generateRentalAgreement("JAKR", LocalDate.of(2020, 7, 2), 4, 50);
		
		System.out.println(rentalAgreement.toString());
		
		return rentalAgreement;
	}
}

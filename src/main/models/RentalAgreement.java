package main.models;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class RentalAgreement {
	private String toolCode;
	private String toolType;
	private String toolBrand;
	private int rentalDaysCount;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private Double dailyRentalCharge;
	private int chargeDays;
	private Double preDiscountCharge;
	private int discountPercent;
	private Double discountAmount;
	private Double finalCharge;
	
	public RentalAgreement(String toolCode, String toolType, String toolBrand, int rentalDaysCount, LocalDate checkoutDate,
			LocalDate dueDate, Double dailyRentalCharge, int chargeDays, Double preDiscountCharge, int discountPercent,
			Double discountAmount, Double finalCharge) {
		this.toolCode = toolCode;
		this.toolType = toolType;
		this.toolBrand = toolBrand;
		this.rentalDaysCount = rentalDaysCount;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
		this.dailyRentalCharge = dailyRentalCharge;
		this.chargeDays = chargeDays;
		this.preDiscountCharge = preDiscountCharge;
		this.discountPercent = discountPercent;
		this.discountAmount = discountAmount;
		this.finalCharge = finalCharge;
	}
	
	public String getToolCode() {
		return this.toolCode;
	}
	
	public String getToolType() {
		return this.toolType;
	}
	
	public String getToolBrand() {
		return this.toolBrand;
	}
	
	public int getRentalDaysCount() {
		return this.rentalDaysCount;
	}
	
	public LocalDate getCheckoutDate() {
		return this.checkoutDate;
	}
	
	public LocalDate getDueDate() {
		return this.dueDate;
	}
	
	public Double getDailyRentalCharge() {
		return this.dailyRentalCharge;
	}
	
	public int getChargeDays() {
		return this.chargeDays;
	}
	
	public Double getPreDiscountCharge() {
		return this.preDiscountCharge;
	}
	
	public int getDiscountPercent() {
		return this.discountPercent;
	}
	
	public Double getDiscountAmount() {
		return this.discountAmount;
	}
	
	public Double getFinalCharge() {
		return this.finalCharge;
	}
	
	public String toString() {
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
				
		return "Tool Code: " + toolCode
				+ "\nTool Type: " + toolType + "\n"
				+ "Tool Brand: " + toolBrand + "\n"
				+ "Rental Days: " + String.valueOf(rentalDaysCount) + "\n"
				+ "Checkout Date: " + checkoutDate.toString() + "\n"
				+ "Due Date: " + dueDate.toString() + "\n"
				+ "Daily Rental Charge: " + currencyFormatter.format(dailyRentalCharge) + "\n"
				+ "Charge Days: " + String.valueOf(chargeDays) + "\n"
				+ "Pre-discount Charge: " + currencyFormatter.format(preDiscountCharge) + "\n"
				+ "Discount Percent: " + String.valueOf(discountPercent) + '%' + "\n"
				+ "Discount Amount: " + currencyFormatter.format(discountAmount) + "\n"
				+ "Final Charge: " + currencyFormatter.format(finalCharge);
	}
}

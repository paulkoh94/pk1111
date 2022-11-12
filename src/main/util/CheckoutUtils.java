package main.util;

import main.models.Tool;
import main.models.RentalAgreement;
import main.util.ToolTypeEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.temporal.TemporalAdjusters;


public class CheckoutUtils {
	private ToolServices toolServices = new ToolServices();
	
	public RentalAgreement generateRentalAgreement(String toolCode, LocalDate checkoutDate, int rentalDaysCount, int discountPercent) throws Exception {
		Map<String, Tool> toolMap = toolServices.getTools();
		Tool tool = toolMap.get(toolCode);
		
		if(tool == null) {
			throw new Exception("Invalid tool code");
		}
		
		if(rentalDaysCount < 1) {
			throw new Exception("Invalid rental day count");

		}
		
		if(discountPercent < 0 || discountPercent > 100) {
			throw new Exception("Invalid discount percent");
		}
		
		LocalDate dueDate = checkoutDate.plusDays(rentalDaysCount);
		
		int chargeDays = getChargeDays(tool.getToolType().getId(), checkoutDate, rentalDaysCount);
		double preDiscountCharge = chargeDays * tool.getToolType().getDailyCharge();
		double discountAmount = preDiscountCharge * discountPercent / 100;
		double finalCharge = preDiscountCharge - discountAmount;
		
		return new RentalAgreement(toolCode, ToolTypeEnum.getById(tool.getToolType().getId()).getName(), tool.getBrand(), rentalDaysCount, checkoutDate, dueDate, 
				tool.getToolType().getDailyCharge(), chargeDays, preDiscountCharge, discountPercent, discountAmount, finalCharge);
	}
	
	private int getChargeDays(int toolTypeId, LocalDate checkoutDate, int rentalDaysCount) throws Exception {
		int chargeDays = rentalDaysCount;		
		
		switch(toolTypeId) {
			case 1:
				chargeDays = subtractHolidayCharge(chargeDays, checkoutDate, rentalDaysCount);
				break;
			case 2:
				chargeDays = subtractWeekendCharge(chargeDays, checkoutDate, rentalDaysCount);
				break;
			case 3:
				chargeDays = subtractWeekendCharge(chargeDays, checkoutDate, rentalDaysCount);
				chargeDays = subtractHolidayCharge(chargeDays, checkoutDate, rentalDaysCount);
				break;
			default:
				throw new Exception("Invalid tool type");
		}
		
		return chargeDays;
	}
	
	private int subtractWeekendCharge(int chargeDays, LocalDate checkoutDate, int rentalDaysCount) {
		for(int i = 1; i <= rentalDaysCount; i++) {
			if(checkoutDate.plusDays(i).getDayOfWeek().compareTo(DayOfWeek.SATURDAY) == 0 
					|| checkoutDate.plusDays(i).getDayOfWeek().compareTo(DayOfWeek.SUNDAY) == 0 ) {
				chargeDays--;
			}
		}
		
		return chargeDays;
	}
	
	private int subtractHolidayCharge(int chargeDays, LocalDate checkoutDate, int rentalDaysCount) {
		List<LocalDate> holidays = getHolidays(checkoutDate);
		
		for(int i = 0; i < holidays.size(); i++) {
			if(holidays.get(i).isAfter(checkoutDate) && holidays.get(i).isBefore(checkoutDate.plusDays(rentalDaysCount + 1))) {
				chargeDays--;
			}
		}
		
		return chargeDays;
	}
	
	private List<LocalDate> getHolidays(LocalDate checkoutDate) {
		List<LocalDate> holidayList = new ArrayList<>();
		
		LocalDate independenceDay = LocalDate.of(checkoutDate.getYear(), 7, 4);
		if(independenceDay.isBefore(checkoutDate)) {
			independenceDay = independenceDay.plusYears(1);
		}
		if(independenceDay.getDayOfWeek().compareTo(DayOfWeek.SATURDAY) == 0) {
			independenceDay = independenceDay.minusDays(1);
		} else if(independenceDay.getDayOfWeek().compareTo(DayOfWeek.SUNDAY) == 0) {
			independenceDay = independenceDay.plusDays(1);
		}
		
		LocalDate laborDay = LocalDate.of(checkoutDate.getYear(), 9, 1).with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
		
		if(laborDay.isBefore(checkoutDate)) {
			laborDay = laborDay.plusYears(1);
		}
		
		holidayList.add(independenceDay);
		holidayList.add(laborDay);
		
		return holidayList;
	}
}

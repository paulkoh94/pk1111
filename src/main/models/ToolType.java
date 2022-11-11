package main.models;

public class ToolType {
	private String name;
	private double dailyCharge;
	private boolean weekdayCharge;
	private boolean weekendCharge;
	private boolean holidayCharge;
	
	public ToolType(String name, double dailyCharge, boolean weekdayCharge, boolean weekendCharge, boolean holidayCharge) {
		this.name = name;
		this.dailyCharge = dailyCharge;
		this.weekdayCharge = weekdayCharge;
		this.weekendCharge = weekendCharge;
		this.holidayCharge = holidayCharge;
	}
	
	public ToolType(ToolType toolType) {
		this.name = toolType.getName();
		this.dailyCharge = toolType.getDailyCharge();
		this.weekdayCharge = toolType.getWeekdayCharge();
		this.weekendCharge = toolType.getWeekendCharge();
		this.holidayCharge = toolType.getHolidayCharge();
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getDailyCharge() {
		return this.dailyCharge;
	}
	
	public boolean getWeekdayCharge() {
		return this.weekdayCharge;
	}
	
	public boolean getWeekendCharge() {
		return this.weekendCharge;
	}
	
	public boolean getHolidayCharge() {
		return this.holidayCharge;
	}
}

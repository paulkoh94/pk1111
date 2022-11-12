package main.models;

public class ToolType {
	private int id;
	private double dailyCharge;
	private boolean weekdayCharge;
	private boolean weekendCharge;
	private boolean holidayCharge;
	
	public ToolType(int id, double dailyCharge, boolean weekdayCharge, boolean weekendCharge, boolean holidayCharge) {
		this.id = id;
		this.dailyCharge = dailyCharge;
		this.weekdayCharge = weekdayCharge;
		this.weekendCharge = weekendCharge;
		this.holidayCharge = holidayCharge;
	}
	
	public ToolType(ToolType toolType) {
		this.id = toolType.getId();
		this.dailyCharge = toolType.getDailyCharge();
		this.weekdayCharge = toolType.getWeekdayCharge();
		this.weekendCharge = toolType.getWeekendCharge();
		this.holidayCharge = toolType.getHolidayCharge();
	}
	
	public int getId() {
		return this.id;
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

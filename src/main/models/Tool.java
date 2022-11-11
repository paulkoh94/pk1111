package main.models;

public class Tool {
	private String code;
	private ToolType toolType;
	private String brand;
	
	public Tool(String code, ToolType toolType, String brand) {
		this.code = code;
		this.toolType = new ToolType(toolType);
		this.brand = brand;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public ToolType getToolType() {
		return this.toolType;
	}
	
	public String getBrand() {
		return this.brand;
	}
	
}

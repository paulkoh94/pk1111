package main.util;

import java.util.Arrays;

public enum ToolTypeEnum {
	LADDER(1, "Ladder"),
	CHAINSAW(2, "Chainsaw"),
	JACKHAMMER(3, "Jackhammer");
	
	private final int id;
	private final String name;
	
	ToolTypeEnum (int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public static ToolTypeEnum getById(int id) throws Exception {
		return Arrays.stream(ToolTypeEnum.values())
			.filter(value -> value.getId() == id)
			.findFirst()
			.orElseThrow(() -> new Exception("Invalid tool type id"));
	}
}

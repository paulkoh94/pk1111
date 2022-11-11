package main.util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.models.Tool;
import main.models.ToolType;

public class ToolServices {
	public Map<String, Tool> getTools() {
		Map<String, Tool> toolMap = new HashMap<>();
		List <ToolType> toolTypeList = getToolTypeList();
		
		toolMap.put("CHNS", new Tool("CHNS", toolTypeList.get(1), "Stihl"));
		toolMap.put("LADW", new Tool("LADW", toolTypeList.get(0), "Werner"));
		toolMap.put("JAKD", new Tool("JAKD", toolTypeList.get(2), "DeWalt"));
		toolMap.put("JAKR", new Tool("JAKR", toolTypeList.get(2), "Ridgid"));

		return toolMap;
	}
		
	private List<ToolType>  getToolTypeList() {
		List<ToolType> toolTypeList = new ArrayList<>();
		
		toolTypeList.add(new ToolType("ladder", 1.99, true, true, false));
		toolTypeList.add(new ToolType("chainsaw", 1.49, true, false, true));
		toolTypeList.add(new ToolType("jackhammer", 2.99, true, false, false));
		
		return toolTypeList;
	}
}

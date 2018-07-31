package sin.glouds.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testData")
public class TestDataController extends BaseController {

	@RequestMapping("/fatherData")
	public String fatherData() {
		List<Map<String, String>> data = new ArrayList<>();
		for(int i=1;i<5;i++) {
			Map<String, String> map = new HashMap<>();
			map.put("name", "name" + i);
			map.put("desc", "desc" + i);
			data.add(map);
		}
		return gson.toJson(data);
	}
}

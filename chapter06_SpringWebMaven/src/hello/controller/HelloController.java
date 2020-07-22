package hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class HelloController {
	
//	@RequestMapping(value="/hello", method=RequestMethod.GET)
//	public @ResponseBody String hello() {
//		return "안녕하세요";
//	}
	
//	@RequestMapping(value="/hello", method=RequestMethod.GET)
//	public @ResponseBody JSONObject hello() {
//		JSONObject json = new JSONObject();
//		json.put("name", "hong");
//		json.put("age", "25");
//		return json;
//	}
	
//	@RequestMapping(value="/hello", method=RequestMethod.GET)
//	public @ResponseBody JSONArray hello() {
//		JSONArray array = new JSONArray();
//		
//		JSONObject json = new JSONObject();
//		json.put("name", "hong");
//		json.put("age", "25");
//		array.add(0, json);
//		
//		json = new JSONObject();
//		json.put("name", "conan");
//		json.put("age", "17");
//		array.add(1, json);
//		
//		return array;
//	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public @ResponseBody JSONObject hello() {
		JSONArray array = new JSONArray();
		
		JSONObject json = new JSONObject();
		json.put("name", "hong");
		json.put("age", "25");
		array.add(0, json);
		
		json = new JSONObject();
		json.put("name", "conan");
		json.put("age", "17");
		array.add(1, json);
		
		JSONObject list = new JSONObject();
		list.put("list", array);
		
		return list;
	}

}










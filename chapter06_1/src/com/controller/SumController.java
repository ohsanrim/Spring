package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SumDTO;

@Controller
public class SumController {

	/*
	 * 리턴타입이 String 이면 단순 문자열이 아니라 뷰의 이름으로 사용된다. 뷰의 이름이 아니라 실제 문자열로
	 * 리턴하려면 @ResponseBody를 사용한다.
	 * 
	 * @ResponseBody 
	 * public String input() { 
	 * 
	 * return "바보"; 
	 * 
	 * }
	 */
	@RequestMapping(value = "sum/input.do", method = RequestMethod.GET)
	public ModelAndView input() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/sum/input");
		return mav;
	}
/*
	@RequestMapping(value = "/result.do", method = RequestMethod.GET)
	public ModelAndView result(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		mav.addObject("x", x);
		mav.addObject("y", y);

		mav.setViewName("/sum/result");
		return mav;
	}
*/
/*
	@RequestMapping(value="/result.do", method=RequestMethod.GET)
	public ModelAndView result(
			@RequestParam(required=false, defaultValue="0") String x, 
			@RequestParam(required=false, defaultValue="0") String y) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("x", x);
		mav.addObject("y", y);
		mav.setViewName("/sum/result");
		return mav;
	}

	@RequestMapping(value="/result.do", method=RequestMethod.GET)
	public String result(@RequestParam Map<String, Integer>map,ModelMap modelMap) {
		//알아서 자동으로 map의 키 값으로 들어가게 됨
		ModelAndView mav = new ModelAndView();
		modelMap.put("x", map.get("x"));
		modelMap.put("y",map.get("y"));
		modelMap.put("sum",map.get("y"));
		return "/sum/result";
	}
	*/


}

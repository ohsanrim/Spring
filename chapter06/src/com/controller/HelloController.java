package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping(value="/hello.do",method=RequestMethod.GET)
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("result","Have a nice day!");
		//mav.setViewName("hello");  //dispatcher-servlet 에서 <property name="prefix" value="/view/"/>를 해주면 hello만 적어줘도 view 폴더에 들어가서 찾음
		mav.setViewName("/view/hello");
		return mav;
	}
}

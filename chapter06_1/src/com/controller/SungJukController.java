package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SungJukDTO;

//@RequestMapping("/sungJuk")

@Controller
public class SungJukController {
	@RequestMapping(value = "/input.do", method = RequestMethod.GET)
	public ModelAndView input() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/sungJuk/input");
		return mav;
	}
	
	@RequestMapping(value="sungJuk/result.do", method=RequestMethod.POST)
	public String result(@ModelAttribute SungJukDTO sungJukDTO, Model model) {
		//알아서 자동으로 map의 키 값으로 들어가게 됨
		ModelAndView mav = new ModelAndView();
		sungJukDTO.setTot(sungJukDTO.getKor()+sungJukDTO.getEng()+sungJukDTO.getMath());
		sungJukDTO.setAvg(sungJukDTO.getTot()/3.0);
		model.addAttribute("sungJukDTO",sungJukDTO);
		return "/sungJuk/result";
	}
}

package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class IndexController {
		@RequestMapping(value="/main/index", method=RequestMethod.GET)
		public ModelAndView index() {
			System.out.println("main.index.service 찾아옴");
			String memId=null;
			ModelAndView mav = new ModelAndView();
			mav.setViewName("/main/index"); 
			mav.addObject("memId",memId);
			mav.addObject("display","/template/body.jsp");
			return mav;
		}
}

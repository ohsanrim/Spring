package user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import user.bean.UserDTO;
import user.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user/writeForm", method=RequestMethod.GET)
	public String writeForm() {
		return "/user/writeForm";
	}
	
	@RequestMapping(value="/user/write", method=RequestMethod.POST)
	@ResponseBody
	public void write(@ModelAttribute UserDTO userDTO) {
		userService.write(userDTO);
	}
	
	@RequestMapping(value="/user/checkId", produces="application/String;charset=UTF-8", method=RequestMethod.POST)
	public @ResponseBody String checkId(@RequestParam String id){
		System.out.println("UserController:"+id);
		String result = userService.checkId(id);
		return result;
	}
	
	@RequestMapping(value="/user/deleteForm", method=RequestMethod.GET)
	public String deleteForm() {
		return "/user/deleteForm";
	}
	
	@RequestMapping(value="/user/delete", method=RequestMethod.POST)
	@ResponseBody
	public void delete(@RequestParam String id) {
		userService.delete(id);
	}
	
	@RequestMapping(value="/user/list", method=RequestMethod.GET)
	public String list() {
		return "/user/list";
	}
	@RequestMapping(value="/user/modifyForm", method=RequestMethod.GET)
	public String modifyForm() {
		return "/user/modifyForm";
	}
	
//	@RequestMapping(value="/user/getUserList", method=RequestMethod.POST)
//	@ResponseBody
//	public JSONObject getUserList() {
//		List<UserDTO> list = userService.getUserList();
//		
//		JSONObject json = new JSONObject();
//		if(list!=null) {
//			JSONArray array = new JSONArray();
//			for(int i=0; i<list.size(); i++) {
//				UserDTO userDTO = list.get(i);
//				
//				JSONObject temp = new JSONObject();
//				temp.put("name", userDTO.getName());
//				temp.put("id", userDTO.getId());
//				temp.put("pwd", userDTO.getPwd());
//				
//				array.add(i, temp);
//			}//for
//			
//			json.put("list", array);
//		}
//		return json;
//	}
	
	/*
	@RequestMapping(value="/user/getUserList", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getUserList() {
		List<UserDTO> list = userService.getUserList();
		
		JSONArray array = JSONArray.fromObject(list);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", array);
		return map;
	}
	
	/* 
	1. ResponseBody 가 있고, ModelAndView 가 있을 경우
	: setViewName() 안에 있는 Bean 네임을 찾아서 이동하는데, 이 때 리졸버를 찾아가개 된다. 
	리졸버를 찾을 때 BeanNameViewResolver 로 이동을 하게 되는데  왜냐면 우선순위가 order가 0 이기 때문에 
	BeanNameViewResolver 객체로 먼저 접근을 하게 된다. 
	
	2. ResponseBody 가 있고, ModelAndView 가 없을 경우
	: 화면에 바로 뿌려짐, Spring 이나 따른 객체일 경우 화면에 뿌려진다. 
	
	3. ResponseBody 가 없고, ModelAndView 가 있거나 없을떄
	: jsp로 이동,(InternalResourceViewResolver)
	 
	BeanNameViewResolever
- BeanNameViewResolver는 spring container에 bean으로 등록된 view이름을 찾아 사용하는 resolver.
- modelAndView를 반환할 때 viewName을 셋팅하여 리턴하면 해당 beanName을 가진 view를 찾는다. 
- 커스텀 view 클래스를 view로 사용하는 경우 주로 사용한다.
- 하나의 Dispatcher-Servlet은 다수의 viewResolver를 사용할 수 있다(order 옵션으로 먼저 사용할 resolver 지정하여 사용)
우선순위(order)는 0 부터 0,1,2...의 형태로 부여되며, 우선순위가 높은 viewResolver가 null을 리턴하면, 그 다음 우선순위를 가진 viewResolver에게 view가 요청된다.

- 주의할 점은, InternalResourceViewResolver는 항상 우선순위 마지막에 놓도록 한다.
InternalResourceViewResolver는 항상 view이름에 매핑되는 view 객체를 리턴하기 때문에(prefix, suffix 사용하여) null을 리턴하지 않는다.  InternalResourceViewResolver가 우선순위가 높을 경우 그보다 낮은 우선순위의 viewResolver들은 사용되지 않게 된다.



InternalResourceViewResolver
- Resource를 대상으로 view를 찾는데, 정적 자원 즉, webapp 아래 자원들을 반환값으로 찾게 된다. 컨트롤러가 지정한 view 이름으로부터 실제로 사용될 view를 선택한다.
- 컨트롤러가 지정한 뷰 이름 앞뒤로 prefix 프로퍼티와 suffix 프로퍼티를 붙인 값이 실제로 사용될 자원의 경로가 된다.
	 
	 
	 */
	@RequestMapping(value="/user/getUserList", method=RequestMethod.POST)
	@ResponseBody// 이걸 쓰면 jsp 를 거치지 않고 바로 브라우저 화면에 뿌려버리게 된다. 
	public ModelAndView getUserList() {
		List<UserDTO> list = userService.getUserList();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		return mav;
	}
	@RequestMapping(value="/user/getUserListOne", method=RequestMethod.POST)
	@ResponseBody// 이걸 쓰면 jsp 를 거치지 않고 바로 브라우저 화면에 뿌려버리게 된다. 
	public ModelAndView getUserListOne(@RequestParam String id) {
		UserDTO userDTO = userService.getUserListOne(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("userDTO", userDTO);
		mav.setViewName("jsonView");
		return mav;
	}
	@RequestMapping(value="/user/modify", method=RequestMethod.POST)
	@ResponseBody
	public void modify(@ModelAttribute UserDTO userDTO) {
		userService.modify(userDTO);
	}
	@RequestMapping(value="/user/getSearchUserList", method=RequestMethod.POST)
	@ResponseBody// 이걸 쓰면 jsp 를 거치지 않고 바로 브라우저 화면에 뿌려버리게 된다. 
	public ModelAndView getSearchUserList(@RequestParam String searchOption, @RequestParam String searchText) {
		System.out.println(searchOption);
		System.out.println(searchText);
		List<UserDTO> list = userService.getSearchUserList(searchOption,searchText);
		System.out.println(list.size());
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		return mav;
	}
	
}















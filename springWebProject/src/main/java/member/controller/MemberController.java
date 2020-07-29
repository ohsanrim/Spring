package member.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;
import member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	public MemberDTO memberDTO;
	@Autowired
	public MemberService memberService;
	
	@RequestMapping(value="/member/loginForm", method=RequestMethod.POST)
	public ModelAndView loginForm(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//DB
		MemberDTO memberDTO = new MemberDTO();
		if(pwd!=null) {   //구글 로그인이 아닌 일반 로그인 시
		    memberDTO = memberService.loginMember(id, pwd);
		} else {  //구글 로그인 진행 시 회원가입
		    if(!memberService.isExistId(id)) {  //구글 로그인 연동이 처음인 경우로, 회원가입이 되어있지 않을 경우
		    	//회원가입 진행
		    	memberDTO.setName(request.getParameter("name"));
				memberDTO.setId(request.getParameter("id"));
				memberDTO.setGender("0");
				memberDTO.setTel1("010");
				String [] email= request.getParameter("email").split("@");
				System.out.println(email[0]+" "+email[1]);
				memberDTO.setEmail1(email[0]);
				memberDTO.setEmail2(email[1]);
				memberService.writeMember(memberDTO);
		    }
		  //회원가입 된 회원 정보 다시 담아오기
		    memberDTO = memberService.loginMember(id,"111");
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/main/index"); 
		mav.addObject("display","/template/body.jsp");
		
		//응답
	    String loginCheckTry=null;
	    if(memberDTO!=null) {
	    	if(memberDTO.getId()==null) {
		    	loginCheckTry="fail";
		    	mav.addObject("display","../template/body.jsp");
		    	mav.addObject("loginCheckTry",loginCheckTry);
		    	return mav;
		    } else {
		    	mav.addObject("display","../template/body.jsp");
		    	mav.addObject("loginCheckTry",loginCheckTry);
				HttpSession session = request.getSession();
				session.setAttribute("memName", memberDTO.getName());
				session.setAttribute("memId", memberDTO.getId());
				session.setAttribute("memPwd", memberDTO.getPwd());
				session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
			    return mav;
		    }
	    } else {
	    	loginCheckTry="fail";
	    	mav.addObject("display","../template/body.jsp");
	    	mav.addObject("loginCheckTry",loginCheckTry);
	    	return mav;
	    }
	}
	@RequestMapping(value="/member/logout", method=RequestMethod.GET)
	   public ModelAndView logout(HttpSession session) {
	      session.invalidate();
	      ModelAndView mav = new ModelAndView();
	      mav.setViewName("/main/index");
	      mav.addObject("display","../template/body.jsp");
	      return mav;
	}
	
	@RequestMapping(value="/member/writeForm", method=RequestMethod.GET)
	   public ModelAndView writeForm(HttpSession session) {
	      ModelAndView mav = new ModelAndView();
	      mav.setViewName("/main/index");
	      mav.addObject("display","/member/writeForm.jsp");
	      return mav;
	 }

	@RequestMapping(value="/member/writeResult", method=RequestMethod.POST)
	public ModelAndView write(@ModelAttribute MemberDTO memberDTO) {
		//폼에서 값 받아오기
		System.out.println(memberDTO.getName()+","+memberDTO.getGender());
		//DB
		memberService.writeMember(memberDTO);
		//ModelAndView
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/main/index");
	    mav.addObject("display","/member/writeResult.jsp");
	    return mav;
	 }
	@RequestMapping(value="/member/checkId", method=RequestMethod.GET)
	public String checkId(HttpServletRequest request) {			
		//ModelAndView
	    
		//데이터 받기
		boolean exist=false;
		 String id = request.getParameter("id");
		 System.out.println(id);
		//DB
		 exist=memberService.isExistId(id);
		 System.out.println(exist);
		//응답
		 request.setAttribute("id",id);
		 if(exist) {  
			 return "/member/checkIdFail";
		 } else {
			 return "/member/checkIdOk";
		 }
	 }
	/*
	@RequestMapping(value="/member/checkPost", method=RequestMethod.GET)
	public ModelAndView checkPost(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		 mav = new ModelAndView();
		//데이터
				String sido = request.getParameter("sido");
				String sigungu = request.getParameter("sigungu");
				String roadname = request.getParameter("roadname");
				//DB
				List <ZipcodeDTO> list=new ArrayList<ZipcodeDTO>();
				if(sido!=null&& roadname!=null){
					list=memberService.getZipcodeList(sido, sigungu, roadname);
					System.out.println(list.size());
				}
				if(list!=null) {
			    	mav.addObject("list", list);
			    } 
				mav.setViewName("/member/checkPost");
		return mav;
	}
*/
	
	@RequestMapping(value="/member/checkPost", method=RequestMethod.GET) 
	public String checkPost(HttpServletRequest request) { return "/member/checkPost"; }
	 
	@RequestMapping(value="/member/checkPostSearch", method=RequestMethod.POST)
	@ResponseBody
	 public ModelAndView checkPostSearch(@RequestParam String sido, @RequestParam String sigungu, @RequestParam String roadname) {
		System.out.println("여기옴?");
		List<ZipcodeDTO> list = new ArrayList<ZipcodeDTO>();
		List<String[]> ziplist = new ArrayList<String[]>();
		String zipcode = null;
		String address = null;
		
		if(sido != null){
			list = memberService.getZipcodeList(sido, sigungu, roadname);
		}
		if(list != null) {
			for(ZipcodeDTO zipcodeDTO : list){
				zipcode = zipcodeDTO.getZipcode();
				address = zipcodeDTO.getSido() + " "
					+ zipcodeDTO.getSigungu() + " "
					+ zipcodeDTO.getYubmyundong() + " "
					+ zipcodeDTO.getRi() + " "
					+ zipcodeDTO.getRoadname() + " "
					+ zipcodeDTO.getBuildingname();
				String ar[] = {zipcode, address};
				ziplist.add(ar);
			}
		}
		System.out.println("list 사이즈="+ziplist.size());
		ModelAndView mav = new ModelAndView();
		mav.addObject("ziplist", ziplist);
		mav.setViewName("jsonView");
		return mav;
	   }
	
	@RequestMapping(value="/member/modifyForm", method=RequestMethod.GET)
	   public ModelAndView modifyForm(HttpSession session) {
	      ModelAndView mav = new ModelAndView();
	      String id = (String) session.getAttribute("memId");
	      String pwd = (String) session.getAttribute("memPwd");
	      System.out.println(id+","+pwd);
	      memberDTO = memberService.loginMember(id,pwd);
	      mav.setViewName("/main/index");
	      mav.addObject("memberDTO", memberDTO);
	      mav.addObject("display","/member/modifyForm.jsp");
	      return mav;
	 }
	
	@RequestMapping(value="/member/modify", method=RequestMethod.POST)
	public ModelAndView modify(@ModelAttribute MemberDTO memberDTO) {
		//폼에서 값 받아오기
		System.out.println(memberDTO.getName()+","+memberDTO.getPwd()+","+memberDTO.getId());
		//DB
		memberService.modifyMember(memberDTO);
		//ModelAndView
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/main/index");
	    mav.addObject("display","/member/modify.jsp");
	    return mav;
	 }

	
	
}

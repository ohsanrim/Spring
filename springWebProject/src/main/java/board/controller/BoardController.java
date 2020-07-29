package board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	public BoardDTO boardDTO;
	@Autowired
	public BoardService boardService;

	@RequestMapping(value = "/board/boardWriteForm", method = RequestMethod.GET)
	public ModelAndView boardWriteForm(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/main/index");
		mav.addObject("display", "/board/boardWriteForm.jsp");
		return mav;
	}

	@RequestMapping(value = "/board/boardWrite", method = RequestMethod.POST)
	public ModelAndView boardWrite(HttpSession session, @ModelAttribute BoardDTO boardDTO) {
		ModelAndView mav = new ModelAndView();
		int seq = boardService.seq();
		boardDTO.setSeq(seq);
		boardDTO.setId((String) session.getAttribute("memId"));
		boardDTO.setName((String) session.getAttribute("memName"));
		boardDTO.setEmail((String) session.getAttribute("memEmail") + "@" + (String) session.getAttribute("memEmail2"));
		boardDTO.setLev(0);
		boardDTO.setStep(0);
		boardDTO.setPseq(0);
		boardDTO.setReply(0);
		boardDTO.setHit(0);
		System.out.println(boardDTO.getSubject() + ":" + boardDTO.getContent());
		boardService.insertBoard(boardDTO);
		mav.setViewName("/main/index");
		mav.addObject("display", "/board/boardWrite.jsp");
		return mav;
	}

	@RequestMapping(value = "/board/boardList", method = RequestMethod.GET)
	public ModelAndView boardList(@RequestParam(required = false, defaultValue = "1") String pg ) {
		System.out.println("board실행");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/main/index");
		mav.addObject("display", "/board/boardList.jsp");
		mav.addObject("pg", pg);
		return mav;
	}
	@RequestMapping(value="/board/getBoardList", method = RequestMethod.POST)
	public ModelAndView getBoardList(@RequestParam String pg) {
		//1페이지 당 5개의 글 뽑아오기
		List <BoardDTO> list = boardService.selectAll(pg);
		System.out.println(list.get(0).getName()+list.get(1).getName());
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		BoardPaging boardPaging = boardService.boardPaging(pg);
		mav.addObject("boardPaging", boardPaging);
		return mav;
	}
	@RequestMapping(value="/board/boardSearch", method = RequestMethod.GET)
	public ModelAndView boardSearch(@RequestParam String pg, @RequestParam String searchOption, @RequestParam String keyword) {
		//페이지 처리
		//System.out.println("Search: "+searchOption+","+keyword);
		int option=0;  //검색옵션 설정
		String search="false";  //사용자가 검색을 했을 경우
		if(keyword!=null) {   //사용자가 검색을 했을 경우
			search="true";
			
			if(searchOption!=null) {
				if(searchOption.equals("제목")) {
					option=1;
				} else if(searchOption.equals("작성자")) {
					option=2;
				}
			}
		} else {
			search="false";
		}
		//map 설정
		Map <String , Object> map = new HashMap();
		map.put("searchOption", option);
		map.put("pg", Integer.parseInt(pg));
		map.put("keyword", keyword);
		List<BoardDTO> list= boardService.getBoardList(map);
		//System.out.println("서치 실행했니??");
		BoardPaging boardPaging = boardService.boardPaging(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.addObject("list",list);
		mav.addObject("boardPaging", boardPaging);
		//System.out.println("토탈값"+boardPaging.getTotalA()+ boardPaging.getPagingHTML());
		mav.setViewName("jsonView");
		
		return mav;
	}
	
}

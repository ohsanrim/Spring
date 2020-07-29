package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

public class BoardServiceImpl implements BoardService {
	@Autowired
	public BoardDAO boardDAO;
	@Autowired
	public BoardPaging boardPaging;
	
	public void insertBoard(BoardDTO boardDTO) {
		boardDAO.insertBoard(boardDTO);
	}

	@Override
	public int seq() {
		return boardDAO.seq();
	}

	@Override
	public List<BoardDTO> selectAll(String pg) {
		int endNum=Integer.parseInt(pg)*5;
		int startNum=endNum-4;
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("endNum", endNum);
		map.put("startNum",startNum);
		
		return boardDAO.selectAll(map);
	}

	@Override
	public int getTotalA() {
		
		return boardDAO.getTotalA();
	}

	@Override
	public BoardPaging boardPaging(String pg) {
		int totalA = 0;
		totalA = boardDAO.getTotalA();
		//System.out.println("totalA="+totalA);
		boardPaging.setCurrentPage(Integer.parseInt(pg));
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTML();
		return boardPaging;
	}

	@Override
	public List<BoardDTO> getBoardList(Map <String, Object> map) {
		int endNum = (Integer)map.get("pg")* 5;
		int startNum = endNum - 4;
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		System.out.println("startNum:"+startNum);
		//map 설정
		List<BoardDTO> list = boardDAO.getBoardList(map);
		//System.out.println("마지막까지 전부 실행"+list.size());
		return list;
	}

	@Override
	public int getTotalA(Map map) {
		return boardDAO.getTotalA(map);
	}

	@Override
	public BoardPaging boardPaging(Map<String , Object> map) {
		int totalA = 0;
		//System.out.println("boardPaging:"+map.get("pg"));
		totalA = boardDAO.getTotalA(map);
		//System.out.println("totalA="+totalA);
		boardPaging.setCurrentPage((Integer)map.get("pg"));
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTML();
		return boardPaging;
	}
}

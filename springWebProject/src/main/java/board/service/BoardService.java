package board.service;

import java.util.List;
import java.util.Map;

import board.bean.BoardDTO;
import board.bean.BoardPaging;

public interface BoardService {
	public void insertBoard(BoardDTO boardDTO);
	
	public int seq();

	public List<BoardDTO> selectAll(String pg);

	public int getTotalA();
	
	public int getTotalA(Map map);

	public BoardPaging boardPaging(String pg);
	
	public BoardPaging boardPaging(Map <String, Object> map);

	public List<BoardDTO> getBoardList(Map <String, Object> map);

}

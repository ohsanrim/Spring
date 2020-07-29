package board.dao;

import java.util.List;
import java.util.Map;

import board.bean.BoardDTO;

public interface BoardDAO {
	public void insertBoard(BoardDTO boardDTO);

	public int seq();

	public List<BoardDTO> selectAll(Map<String, Integer> map);
	
	public int getTotalA();

	public int getTotalA(Map map);

	public List<BoardDTO> getBoardList(Map map);


}

package board.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import board.bean.BoardDTO;
@Repository
@Transactional
public class BoardDAOMybatis implements BoardDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertBoard(BoardDTO boardDTO) {
		sqlSession.insert("boardSQL.insertBoard", boardDTO);
	}

	@Override
	public int seq() {
		return sqlSession.selectOne("boardSQL.seq");
	}

	@Override
	public List<BoardDTO> selectAll(Map<String, Integer> map) {
		return sqlSession.selectList("boardSQL.selectAll",map);
	}

	@Override
	public int getTotalA() {
		return sqlSession.selectOne("boardSQL.getTotalA");
	}

	@Override
	public int getTotalA(Map map) {  //검색을 하였을 때
		return sqlSession.selectOne("boardSQL.getTotalA1", map );
	}

	@Override
	public List<BoardDTO> getBoardList(Map map) {
		return sqlSession.selectList("boardSQL.getBoardList",map);
	}
}

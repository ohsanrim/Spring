package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;

@Repository
@Transactional
public class UserDAOMybatis implements UserDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public UserDTO checkId(String id) {
		UserDTO userDTO = sqlSession.selectOne("userSQL.checkId", id);
		return userDTO;
	}

	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write", userDTO);
	}

	@Override
	public void delete(String id) {
		sqlSession.delete("userSQL.delete", id);
	}

	@Override
	public List<UserDTO> getUserList() {
		return sqlSession.selectList("userSQL.getUserList");
	}

	@Override
	public UserDTO getUserListOne(String id) {
		return sqlSession.selectOne("userSQL.getUserListOne",id);
	}

	@Override
	public void modify(UserDTO userDTO) {
		sqlSession.update("userSQL.modify",userDTO);
		
	}

	@Override
	public List<UserDTO> getSearchUserList(String searchOption,String searchText) {
		// TODO Auto-generated method stub
		Map<String , String> map = new HashMap();
		//map.put("searchOption", searchOption);
		map.put("searchText", "%"+searchText+"%");
		return sqlSession.selectList("userSQL.getSearchUserList",map);
	}
	

}












package user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;

@Transactional   //자동으로 AOP 기능이 들어가게 됨(SqlSession 을 자동으로 생성해주고, close() 역시 알아서 추가를 해주게 된다. 
//@Repository("userDAO")
@ComponentScan("user.conf")
public class UserDAOMybatis implements UserDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void write(UserDTO userDTO) {
		
		int su = sqlSession.insert("userSQL.write",userDTO);

	}

	@Override
	public List<UserDTO> getUserList() {
		List <UserDTO>list =sqlSession.selectList("userSQL.getUserList");
		return list;
	}

	@Override
	public int getUserCount(String id) {
		int count=sqlSession.selectOne("userSQL.getUserCount",id);
		return count;
	}

	@Override
	public void modify(UserDTO userDTO) {
		sqlSession.update("userSQL.update",userDTO);

	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		sqlSession.delete("userSQL.delete",id);
	}

}

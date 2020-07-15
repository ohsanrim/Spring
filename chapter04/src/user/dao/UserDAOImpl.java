package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import user.bean.UserDTO;

public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {
	/*
	getJdbcTemplate() 라는 클래스는 부모 클래스인 JdbcDaoSupport 가 들고있음. 때문에 그냥 호출해 주어도 사용이 가능하다. 
	
	 */
	
	@Override
	public void write(UserDTO userDTO) {
		
		/*
		 * String sql ="insert into usertable values(?, ?, ?)";
		 * getJdbcTemplate().update(sql,userDTO.getName(), userDTO.getId(),
		 * userDTO.getPwd());
		 */
		/*
		 * 물음표의 개수가 많을 때에는 map을 사용하여 호출하면 편리하게 쓸 수 이ㅛ다. 
		 * 
		 */
		String sql ="insert into usertable values(:name,:id,:pwd)";
		Map <String,String> map = new HashMap<String , String>();
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());
		map.put("name", userDTO.getName());
		getNamedParameterJdbcTemplate().update(sql, map);
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
	}

	@Override
	public int getUser(String id) {
		String sql = "select count(*) from usertable where id=?";
		return getJdbcTemplate().queryForObject(sql, Integer.class, id);
	}
//	@Override
//	   public UserDTO getUser(String id) {
//	      String sql = "select * from usertable where id = ?";
//	      UserDTO userDTO = null;
//	      try {
//	         userDTO = getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class), id);
//	      } catch (EmptyResultDataAccessException e) {
//	         
//	      }
//	      return userDTO;
//	   }

	@Override
	public void modify(UserDTO userDTO) {
		String sql = "update usertable set name=?, pwd=? where id=?";
		getJdbcTemplate().update(sql,userDTO.getName(), userDTO.getPwd(),userDTO.getId());
	}

	@Override
	public void deleteUser(String id) {
		String sql = "delete usertable where id=?";
		getJdbcTemplate().update(sql,id);
		
	}

}

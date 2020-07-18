package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import user.bean.UserDTO;

@Repository("userDAO")
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {
	@Autowired
	public void setDS(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	@Override
	public void write(UserDTO userDTO) {
		
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

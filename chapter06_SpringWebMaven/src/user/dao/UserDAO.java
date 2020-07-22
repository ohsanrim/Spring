package user.dao;

import java.util.List;

import net.sf.json.JSONObject;
import user.bean.UserDTO;

public interface UserDAO {

	public UserDTO checkId(String id);

	public void write(UserDTO userDTO);

	public void delete(String id);

	public List<UserDTO> getUserList();

	public UserDTO getUserListOne(String id);

	public void modify(UserDTO userDTO);

	public List<UserDTO> getSearchUserList(String searchOption, String searchText);

}

package user.service;

import java.util.List;

import net.sf.json.JSONObject;
import user.bean.UserDTO;

public interface UserService {

	public String checkId(String id);

	public void write(UserDTO userDTO);

	public void delete(String id);

	public List<UserDTO> getUserList();

	public UserDTO getUserListOne(String id);

	public void modify(UserDTO userDTO);

	public List<UserDTO> getSearchUserList(String searchOption, String searchText);

}

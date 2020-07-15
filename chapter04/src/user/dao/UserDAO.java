package user.dao;

import java.util.List;

import user.bean.UserDTO;

public interface UserDAO {
public void write(UserDTO userDTO);

public List<UserDTO> getUserList();

public int getUser(String id);

public void modify(UserDTO userDTO);

public void deleteUser(String id);


}

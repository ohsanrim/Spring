package user.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component
public class UserDTO {
	public String name;
	public String id;
	public String pwd;
}

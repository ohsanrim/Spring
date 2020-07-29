package member.dao;

import java.util.List;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

public interface MemberDAO {

	MemberDTO loginMember(String id, String pwd);

	boolean isExistId(String id);

	void writeMember(MemberDTO memberDTO);

	List<ZipcodeDTO> getZipcodeList(String sido, String sigungu, String roadname);

	void modifyMember(MemberDTO memberDTO);

}

package member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

public interface MemberService {
	public MemberDTO loginMember(String id, String pwd);

	public boolean isExistId(String id);

	public void writeMember(MemberDTO memberDTO);

	public List<ZipcodeDTO> getZipcodeList(String sido, String sigungu, String roadname);
	
	public void modifyMember(MemberDTO memberDTO);
}

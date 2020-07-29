package member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;
import member.dao.MemberDAO;

public class MemberServiceImpl implements MemberService {
	@Autowired
	public MemberDAO memberDAO;
	
	public MemberDTO loginMember(String id, String pwd) {
		return memberDAO.loginMember(id,pwd);
	}

	@Override
	public boolean isExistId(String id) {
		return memberDAO.isExistId(id);
	}

	@Override
	public void writeMember(MemberDTO memberDTO) {
		memberDAO.writeMember(memberDTO);
	}

	@Override
	public List<ZipcodeDTO> getZipcodeList(String sido, String sigungu, String roadname) {
		return memberDAO.getZipcodeList(sido, sigungu, roadname);
	}

	@Override
	public void modifyMember(MemberDTO memberDTO) {
		memberDAO.modifyMember(memberDTO);
		
	}
}

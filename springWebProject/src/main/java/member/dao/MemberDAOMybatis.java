package member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

@Repository
@Transactional
public class MemberDAOMybatis implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public MemberDTO loginMember(String id, String pwd) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);	
		System.out.println("이거는 실행되니???");
		MemberDTO memberDTO =sqlSession.selectOne("memberSQL.loginMember",map);
		return memberDTO;
	}

	@Override
	public boolean isExistId(String id) {
		boolean isExisted=false;
		MemberDTO memberDTO =sqlSession.selectOne("memberSQL.isExisted",id);
		if(memberDTO!=null) isExisted=true;
		System.out.println(memberDTO);
		return isExisted;
	}

	@Override
	public void writeMember(MemberDTO memberDTO) {
		sqlSession.insert("memberSQL.writeMember",memberDTO);
	}

	@Override
	public List<ZipcodeDTO> getZipcodeList(String sido, String sigungu, String roadname) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sido", sido);
		map.put("sigungu", sigungu);
		map.put("roadname", roadname);
		List<ZipcodeDTO> list =sqlSession.selectList("memberSQL.getZipcodeList",map);
		return list;
	}

	@Override
	public void modifyMember(MemberDTO memberDTO) {
		sqlSession.update("memberSQL.modifyMember",memberDTO);
		
	}

}

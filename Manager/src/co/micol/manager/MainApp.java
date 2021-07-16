package co.micol.manager;

import java.util.ArrayList;
import java.util.List;

import co.micol.manager.member.service.MemberService;
import co.micol.manager.member.serviceImple.MemberServiceImpl;
import co.micol.manager.member.vo.MemberVO;

public class MainApp {

	public static void main(String[] args) {
		MemberService memberDao = new MemberServiceImpl(); 
		List<MemberVO> members = new ArrayList<MemberVO>();
		
		members = memberDao.MemberSelectList();
		for(MemberVO vo: members) {
			vo.toString();
		}
	}

}

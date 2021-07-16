package co.micol.manager;

import co.micol.manager.menu.LoginMenu;

public class MainApp { //si프로젝트 mvc패턴

	public static void main(String[] args) {
		LoginMenu menu = new LoginMenu();
		menu.login();
		
//		MemberService memberDao = new MemberServiceImpl(); 
//		List<MemberVO> members = new ArrayList<MemberVO>();
//		
//		members = memberDao.MemberSelectList();
//		for(MemberVO vo: members) {
//			vo.toString();
//		}
	}

}

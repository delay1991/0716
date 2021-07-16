package co.micol.manager.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.micol.manager.board.service.BoardService;
import co.micol.manager.board.serviceImpl.BoardServiceImpl;
import co.micol.manager.member.service.MemberService;
import co.micol.manager.member.serviceImple.MemberServiceImpl;
import co.micol.manager.member.vo.MemberVO;

public class AdminMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberService memDao = new MemberServiceImpl(); //멤버정보수정
	private BoardService boDao = new BoardServiceImpl(); //게시글
	
	
	private void title() {
		System.out.println("--------------------------------");
		System.out.println("---------|   관 리 자  |---------");
		System.out.println("--------------------------------");

	}

	private void adminMenu(MemberVO vo) {
		
		System.out.println(vo.getName()+"관리자님 환영합니다다^_^*");
		title();
		memberList();
	}
	
	private void memberList() {
		//멤버목록가져오기
		List<MemberVO> list = new ArrayList<MemberVO>();
		list = memDao.MemberSelectList();
		for(MemberVO vo : list) {
			vo.toString();
		}
		
	}

	public void run(MemberVO vo) {
		adminMenu(vo);
	}
}

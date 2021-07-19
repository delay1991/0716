package co.micol.manager.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sun.source.tree.MemberSelectTree;

import co.micol.manager.board.service.BoardService;
import co.micol.manager.board.serviceImpl.BoardServiceImpl;
import co.micol.manager.board.vo.BoardVO;
import co.micol.manager.member.service.MemberService;
import co.micol.manager.member.serviceImple.MemberServiceImpl;
import co.micol.manager.member.vo.MemberVO;

public class AdminMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberService memDao = new MemberServiceImpl(); // 멤버정보수정
	private BoardService boDao = new BoardServiceImpl(); // 게시글

	private void title() {
		System.out.println("────────────| 관 리 자 메뉴 |──────────");
		System.out.println("────────────────────────────────────");
		System.out.println("| 1.사용자관리 | 2.게시판관리 | 3. 종 료 |") ;
		System.out.println("────────────────────────────────────");
		System.out.println("원하는 작업을 선택하세요~?");
	}

	private void subMemberTitel() {
		System.out.println("───────────────────── |   사 용 자 관리   |───────────────────────");
		System.out.println("────────────────────────────────────────────────────────────────");
		System.out.println("| 1.멤버 정보 목록 | 2.멤버 정보 조회 | 3.멤버 정보 삭제 |4.  돌아 가기   |");
		System.out.println("────────────────────────────────────────────────────────────────");
		System.out.println("원하는 작업을 선택하세요~?");
	}

	private void subBoardTitle() {
		System.out.println("─────────────────────|  게시판 관리  |───────────────────────");
		System.out.println("──────────────────────────────────────────────────────────");
		System.out.println("| 1.글목록   | 2.글쓰기   | 3.글수정   | 4.글삭제   | 5.돌아 가기 |");
		System.out.println("──────────────────────────────────────────────────────────");
		System.out.println("원하는 작업을 선택하세요~?");
	}

	private void adminMenu(MemberVO vo) {

		System.out.println(vo.getName() + "관리자님 환영합니다다^_^*"); // 7/19여기구성~
		boolean b = false;
		do {
			title(); //주메뉴출력
			int choice;
			switch(choice = sc.nextInt()) {
				case 1:
					userManager();
					
					break;
				case 2:
					boardManager();
					break;
				case 3:
					b = true;
					System.out.println("작업을 종료합니다.");
					break;
			}
		} while (!b);
	}

	private void boardManager() {
		// 게시판관리
		boolean b =false;
		// 사용자관리
		do {
			int chk;
			subBoardTitle();
				switch(chk = sc.nextInt()) {
				case 1:
					boardSelectList(); //글목록
					break;
				case 2:
					boardInsert();//글쓰기
					break;
				case 3:
					boardUpdate();//글수정
					break;
				case 4:
					boardDelete();//글삭제
					break;
				case 5:
					b = true;
					System.out.println("목록으로 돌아갑니다.");
					break;
				}
		}while(!b); 
		
	}

	private void boardDelete() {
		// TODO 글삭제
		BoardVO board = new BoardVO();
		System.out.println("삭제할 글번호를 입력하세요.");
		board.setBoardid(sc.next()); sc.nextLine();
		int n = boDao.boardDelete(board);
		if( n != 0) {
			System.out.println("정상적으로 삭제되었습니다.");
			
		}else {
			System.out.println("삭제실패");
		}
	}
	
	private void boardUpdate() {
		// TODO 글내용만 수정
		BoardVO board = new BoardVO();
		System.out.println("수정할 글번호 입력하세요.");//수정
		board.setBoardid(sc.next()); sc.nextLine();
		System.out.println("수정할 글내용 입력하세요.");
		board.setSubject(sc.nextLine());
		int n=boDao.boardUpdate(board);
		if( n != 0) {
			System.out.println("정상적으로 수정되었습니다.");
			
		}else {
			System.out.println("수정실패");
		}
	}

	private void boardSelectList() {
		// TODO 글목록조회
		List<BoardVO> list = new ArrayList<BoardVO>();
		list = boDao.boardSelectList();
		for(BoardVO vo : list) {
			vo.toString();
		}
		
	}

	private void boardInsert() {
		// TODO 글쓰기
		BoardVO vo = new BoardVO(); //객체생성
		System.out.println("게시판 번호를 입력하세요.");
		vo.setBoardid(sc.next()); sc.nextLine(); //버퍼하나지워주고~~
		System.out.println("게시판 타이틀을 입력하세요.");
		vo.setTitle(sc.nextLine()); 
		System.out.println("게시판 내용을 입력하세요");
		vo.setSubject(sc.nextLine()); 
		System.out.println("작성자를 입력하세요.");
		vo.setWriter(sc.next()); sc.nextLine(); 
		
		int n = boDao.boardInsert(vo);
		if(n != 0) {
			System.out.println("정상적으로 입력되었습니다.");
		}else {
			System.out.println("입력실패");
		}
		
	}



	private void userManager() {
		boolean b =false;
		// 사용자관리
		do {
				int chk;
				subMemberTitel(); //사용자메뉴호출
				switch(chk = sc.nextInt()) {
				case 1:
					memberSelectList(); //멤버목록조회
					break;
				case 2:
					sc.nextLine();
					memberSelect();//멤버조회
					
					break;
				case 3:
					sc.nextLine();
					memberDelete();//멤버삭제
					break;
				case 4:
					b = true;
					System.out.println("목록으로 돌아갑니다.");
					break;
				}
		}while(!b); 
		
	}

	private void memberDelete() {
		//멤버삭제
		MemberVO member = new MemberVO();
		System.out.println("삭제할 아이디를 입력하세요.");
		member.setId(sc.nextLine());
		int n = memDao.memberDelete(member);
		if( n != 0) {
			System.out.println("정상적으로 삭제되었습니다.");
			
		}else {
			System.out.println("삭제실패");
		}
	}

	private void memberSelect() {
		//멤버조회 주거니받거니 ㅜㅜㅜㅜㅜㅜㅜㅜㅜ
		MemberVO member = new MemberVO();
		System.out.println("검색할 아이디를 입력하세요.");
		member.setId(sc.nextLine()); 
		member = memDao.memberSelect(member);
		
		member.toString(); //한행이라 foreach필요없음.
	}

	private void memberSelectList() {
		//멤버목록조회
		System.out.println("──────── 사용자 목록 ───────");
		memDao.MemberSelectList();
		List<MemberVO> members = new ArrayList<MemberVO>();
		members = memDao.MemberSelectList();
		for (MemberVO member : members) {
			member.toString();
		}
	}

	private void memberList() {
		// 멤버목록가져오기
		List<MemberVO> list = new ArrayList<MemberVO>();
		list = memDao.MemberSelectList();
		for (MemberVO vo : list) {
			vo.toString();
		}

	}

	public void run(MemberVO vo) {
		adminMenu(vo);
	}
}

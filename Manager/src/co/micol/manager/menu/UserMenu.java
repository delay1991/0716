package co.micol.manager.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.micol.manager.board.service.BoardService;
import co.micol.manager.board.serviceImpl.BoardServiceImpl;
import co.micol.manager.board.vo.BoardVO;
import co.micol.manager.member.service.MemberService;
import co.micol.manager.member.serviceImple.MemberServiceImpl;
import co.micol.manager.member.vo.MemberVO;

public class UserMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberService memDao = new MemberServiceImpl(); //멤버정보수정
	private BoardService boDao = new BoardServiceImpl(); //게시글

	private void title() {
		System.out.println("──────────────────────────────────────────────────────────────────");
		System.out.println("──────────────────────|  사  용  자  |─────────────────────────────");
		System.out.println("──────────────────────────────────────────────────────────────────");
		System.out.println("| 1.나의 정보 수정 | 2.게시글 보기 | 3.게시글 작성 |4.게시글 삭제 | 5.종료   |");
		System.out.println("──────────────────────────────────────────────────────────────────");
		System.out.println("원하는 작업을 선택하세요~?");
	}

	private void userMenu(MemberVO vo) {//7/19 여기구성
		System.out.println(vo.getName() + "님 입니다^_^*"); 
		//메뉴가 동작할수 있도록 구현하기.
		boolean b = false;
		do {
			title();
			int choice;
			switch(choice = sc.nextInt()) {
			case 1:
				myinfoUpdate();
				break;
			case 2:
				sc.nextLine();
				boardList();
				break;
			case 3:
				sc.nextLine();
				boardInsert();
				break;
			case 4:
				sc.nextLine();
				boardDelete();
				break;
			case 5:
				b = true;
				System.out.println("작업을 종료합니다.");
				break;
			}
		}while(!b);
		
		
		
	}
	private void boardDelete() {
		// TODO 사용자 글삭제
		BoardVO board = new BoardVO();
		System.out.println("삭제할 글번호 입력하세요.");
		board.setBoardid(sc.next());sc.nextLine();
		int n = boDao.boardDelete(board);
		if( n != 0) {
			System.out.println("정상적으로 삭제되었습니다.");
			
		}else {
			System.out.println("삭제실패");
		}
		
	}

	private void boardInsert() {
		// TODO 사용자 글입력
		BoardVO vo = new BoardVO();
		System.out.println("게시글 번호를 입력하세요.");
		vo.setBoardid(sc.next()); sc.nextLine();
		System.out.println("게시글 타이틀을 입력하세요.");
		vo.setTitle(sc.nextLine());
		System.out.println("게시글 내용을 입력하세요.");
		vo.setSubject(sc.nextLine());
		System.out.println("나의 아이디를 입력하세요.");
		vo.setWriter(sc.next()); sc.nextLine();
		
		int n = boDao.boardInsert(vo);
		if(n != 0) {
			System.out.println("정상적으로 입력되었습니다.");
		}else {
			System.out.println("입력실패");
		}
	}

	private void boardList() {
		// TODO 사용자 글리스트
		List<BoardVO> list = new ArrayList<BoardVO>();
		list = boDao.boardSelectList();
		for(BoardVO vo : list) {
			vo.toString();
		}
		
	}

	private void myinfoUpdate() {
		// TODO 사용자 정보수정
		MemberVO vo = new MemberVO();
//		System.out.println("게시글 아이디를 입력하세요.");
//		String boardId =sc.next(); sc.nextLine();
//		vo.setBoardId(boardId);
//		vo. boDa.boardSelect(vo);
//		if(vo.getWrither().equals(id)) {
//			vo = new BoardVO();
//			System.out.println("내용입력");
//			vo.setSubject(sc.nextLine());
//			vo.setWriter(id);
//			vo.set
//		}
		
		System.out.println("수정할 주소를 입력하세요.");
		vo.setAddress(sc.next()); sc.nextLine();
		System.out.println("수정할 전화번호를 입력하세요.");
		vo.setTel(sc.nextLine());
		System.out.println("나의 아이디를 입력하세요.");
		vo.setId(sc.next());
		int n = memDao.memberUpdate(vo);
		if( n != 0) {
			System.out.println("정상적으로 수정되었습니다.");
			
		}else {
			System.out.println("수정실패");
		}
		
	}

	public void run(MemberVO vo) {
		userMenu(vo);

	}

}

package co.micol.manager.board.service;

import java.util.List;

import co.micol.manager.board.vo.BoardVO;

public interface BoardService {
	List<BoardVO> boardSelectList();//게시글목록가져옴
	BoardVO boardSelect(BoardVO vo);//게시글조회
	int boardInsert(BoardVO vo); //게시글추가
	int boardDelete(BoardVO vo); //게시글삭제
	int boardUpdate(BoardVO vo);//게시글수정
	
	
}

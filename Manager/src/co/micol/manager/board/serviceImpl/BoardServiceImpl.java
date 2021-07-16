package co.micol.manager.board.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.manager.Dao;
import co.micol.manager.board.service.BoardService;
import co.micol.manager.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	private Connection conn = Dao.getConnection();
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<BoardVO> boardSelectList() {
		// 게시판 전체목록
		List<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo; // 한개의 객체를 담을곳
		String sql = "select * from board";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) { //목록
				vo = new BoardVO();
				vo.setBoardid(rs.getString("boardid"));
				vo.setWriter(rs.getNString("writer"));
				vo.setTitle(rs.getNString("title"));
				vo.setEnterdate(rs.getDate("enterdate"));
				vo.setHit(rs.getInt("hit"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public BoardVO boardSelect(BoardVO vo) {
		// 게시글조회
		String sql = "select * from board where board id = ?";
		try { //목록+내용
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBoardid());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setBoardid(rs.getString("boardid"));
				vo.setWriter(rs.getNString("writer"));
				vo.setTitle(rs.getNString("title"));
				vo.setSubject(rs.getString("subject"));
				vo.setEnterdate(rs.getDate("enterdate"));
				vo.setHit(rs.getInt("hit"));
				updateHit(vo.getBoardid()); //조회수 증가 시키는 메소드 호출
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	private void updateHit(String boardid) {
		// 조회수증가
		String sql = "update board set hit = hit +1 where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, boardid);
			psmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int boardInsert(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardDelete(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}

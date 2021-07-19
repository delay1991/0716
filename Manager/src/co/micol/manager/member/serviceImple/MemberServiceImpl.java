package co.micol.manager.member.serviceImple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.manager.Dao;
import co.micol.manager.member.service.MemberService;
import co.micol.manager.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private Connection conn = Dao.getConnection();//스택에있는거 바로불러오겠다...DBMS와 연결하는객체
	private PreparedStatement psmt; //초기화안해도됌.. conn을통해 sql명령을 실행하는 객체
	private ResultSet rs; //select 구문을 호출시 결과를 돌려받는 객체
	
	
	@Override
	public List<MemberVO> MemberSelectList() {
		//회원전체목록
		List<MemberVO> members = new ArrayList<MemberVO>();
		MemberVO member;
		String sql = "select * from member";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) { //얼마나돌아올지모르니 while
				member = new MemberVO();
				member.setId(rs.getNString("id"));
				member.setPassword(rs.getNString("password"));
				member.setName(rs.getNString("name"));
				member.setAddress(rs.getNString("address"));
				member.setTel(rs.getNString("tel"));
				member.setAge(rs.getInt("age"));
				member.setAuth(rs.getString("auth"));
				members.add(member);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return members;
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		String sql = "select * from member where id = ?";
		try {
			psmt = conn.prepareStatement(sql); 
			psmt.setString(1, vo.getId()); //?가오니깐 
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getNString("name"));
				vo.setAddress(rs.getNString("address"));
				vo.setTel(rs.getNString("tel"));
				vo.setAge(rs.getInt("age"));
				vo.setAuth(rs.getString("auth"));
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public MemberVO loginCheck(MemberVO vo) {
		//로그인과정
		String sql="select * from member where id = ? and password = ?";
		try{
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setName(rs.getNString("name"));
				vo.setAuth(rs.getString("auth"));
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// TODO 멤버삭제
		int n = 0;
		String sql = "delete from member where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// TODO 멤버수정_주소와 전화번호만 수정가능
		int n = 0;
		String sql = "update member set address =? , tel = ? where id =?";
		try {
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, vo.getAddress());
			psmt.setString(2, vo.getTel());
			psmt.setString(3, vo.getId());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

}

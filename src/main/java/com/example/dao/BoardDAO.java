package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.bean.BoardVO;
import com.example.util.JDBCUtil;

public class BoardDAO {

	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	private final String POSTS_INSERT = "insert into POSTS (title, writer, content, category, modified_date) values (?,?,?,?,?)";
	private final String POSTS_UPDATE = "update POSTS set title=?, writer=?, content=?, category=?, modified_date=? where id=?";
	private final String POSTS_DELETE = "delete from POSTS where id=?";
	private final String POSTS_GET = "select * from POSTS where id=?";
	private final String POSTS_LIST = "select * from POSTS order by id desc"; // 수정

	public int insertPost(BoardVO vo) {
		System.out.println("===> JDBC로 insertPost() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(POSTS_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.setString(4, vo.getCategory());
			stmt.setDate(5, new java.sql.Date(vo.getModifiedDate().getTime()));
			stmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 글 삭제
	public void deletePost(BoardVO vo) { // 메서드명 수정
		System.out.println("===> JDBC로 deletePost() 기능 처리"); // 메서드명 수정
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(POSTS_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int updatePost(BoardVO vo) {
		System.out.println("===> JDBC로 updatePost() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(POSTS_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.setString(4, vo.getCategory());
			stmt.setDate(5, new java.sql.Date(vo.getModifiedDate().getTime()));
			stmt.setInt(6, vo.getSeq());
			stmt.executeUpdate();
			return 1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public BoardVO getPost(int seq) { // 메서드명 수정
		BoardVO one = new BoardVO();
		System.out.println("===> JDBC로 getPost() 기능 처리"); // 메서드명 수정
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(POSTS_GET);
			stmt.setInt(1, seq);
			rs = stmt.executeQuery();
			if (rs.next()) {
				one.setSeq(rs.getInt("id")); // 컬럼명 수정
				one.setTitle(rs.getString("title"));
				one.setWriter(rs.getString("writer"));
				one.setContent(rs.getString("content"));
				one.setCnt(rs.getInt("cnt"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return one;
	}

	public List<BoardVO> getPostList() { // 메서드명 수정
		List<BoardVO> list = new ArrayList<BoardVO>();
		System.out.println("===> JDBC로 getPostList() 기능 처리"); // 메서드명 수정
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(POSTS_LIST);
			rs = stmt.executeQuery();
			while (rs.next()) {
				BoardVO one = new BoardVO();
				one.setSeq(rs.getInt("id")); // 컬럼명 수정
				one.setTitle(rs.getString("title"));
				one.setWriter(rs.getString("writer"));
				one.setContent(rs.getString("content"));
				one.setRegdate(rs.getDate("regdate"));
				one.setCnt(rs.getInt("cnt"));
				list.add(one);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

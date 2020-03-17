package com.example.phonebook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.phonebook.vo.PhoneBookVO;






public class PhoneBookDAOImpl implements PhoneBookDAO {
	private static String dbur1 = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String dbuser = "bituser";
	private static String dbpass = "bituser";
	private Connection getConnection()  throws SQLException {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(dbur1, dbuser, dbpass);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패!");
		}
		return conn;
	}
	@Override
	public List<PhoneBookVO> getList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<PhoneBookVO> list = new ArrayList<>();
		try {
			conn = getConnection();
			stmt =  conn.createStatement();
			String sql = "SELECT id, name, hp, tel FROM phone_book";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Long phoneId = rs.getLong(1);
				String phoneName = rs.getString(2);
				String phoneHp = rs.getString(3);
				String phoneTel = rs.getString(4);
				
				PhoneBookVO pb = new PhoneBookVO(phoneId,
											phoneName,
											phoneHp,
											phoneTel);
				list.add(pb);
			}
		}catch(SQLException e) {
			System.out.println("SQL ERROR");
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e) {}
		}
		return list;
	}
	
	
	@Override
	public boolean insert(PhoneBookVO phoneBookVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertedCount = 0;
		
		try {
			conn = getConnection();
			String sql =  "INSERT INTO Phone_Book VALUES(seq_author_pk.NEXTVAL,?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phoneBookVO.getPhoneName());
			pstmt.setString(2, phoneBookVO.getPhoneHp());
			pstmt.setString(3, phoneBookVO.getPhoneTel());
			
			insertedCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {}
		}
		return 1 == insertedCount;
	}
	
	
	@Override
	public boolean delete(Long id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deletedCount = 0;
		
		try {
			conn = getConnection();
			String sql = "DELETE FROM Phone_Book WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			
			deletedCount = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return deletedCount !=0;
	}

	@Override
	public List<PhoneBookVO> getSearchList(String name) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<PhoneBookVO> list = new ArrayList<>();	
			try {

				conn = getConnection();
				String sql = "SELECT id, name, hp, tel FROM phone_book WHERE name LIKE ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + name + "%");
				
				rs = pstmt.executeQuery();
			
					while (rs.next()) {
					Long phoneId = rs.getLong(1);
					String phoneName = rs.getString(2);
					String phoneHp = rs.getString(3);
					String phoneTel = rs.getString(4);
					
					PhoneBookVO pbv = new PhoneBookVO(phoneId,
													  phoneName,
													  phoneHp,
													  phoneTel);
					list.add(pbv);
				}
				
				
			}catch(SQLException e) {
				System.out.println("SQL ERROR");
			} finally {
				try {
					rs.close();
					pstmt.close();
					conn.close();
				}catch (Exception e) {}
				
			}
		
	
		return list;
	}
	
}

			


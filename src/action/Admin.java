package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Paper;
import service.ConnectSQL;
import support.UserSupport;

public class Admin extends UserSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 123L;
	public String execute() throws SQLException {
		List<Paper> papers = new ArrayList<>();
		Connection conn = ConnectSQL.getConn();

		StringBuffer sql2 = new StringBuffer("SELECT * FROM paper WHERE Status=1");
		PreparedStatement pstmt2 = (PreparedStatement) conn.prepareStatement(sql2.toString());
		ResultSet rs = pstmt2.executeQuery();
		while (rs.next()) {
			Paper temp1 = new Paper();
			temp1.setPaperID(rs.getString(1));
			temp1.setTitle(rs.getString(2));
			temp1.setAuthor(rs.getString(3));
			temp1.setDate(rs.getString(5));
			temp1.setKeyword(rs.getString(9));
			temp1.setPublication(rs.getString(7));
			papers.add(temp1);
		}
		getUser().setPapers(papers);
		return SUCCESS;
	}
	public String pass() throws SQLException {
		Connection conn=ConnectSQL.getConn();
		String sql = "update paper set Status=0 where paperID='"+ getPaperID() + "'";
		PreparedStatement pstmt;
		
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			 pstmt.executeUpdate();
			 pstmt.close();
			conn.close();
			 System.out.println("update paper table success!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return execute();
	}
	public String notpass() throws SQLException {
		Connection conn=ConnectSQL.getConn();
		String sql = "update paper set Status=2 where paperID='"+ getPaperID() + "'";
		PreparedStatement pstmt;
		
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			 pstmt.executeUpdate();
			 pstmt.close();
			conn.close();
			 System.out.println("update paper table success!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			return execute();
		
	}
	
}
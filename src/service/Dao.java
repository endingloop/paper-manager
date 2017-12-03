package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import action.SearchPaper;
import model.Paper;
import model.User;

public class Dao {
	
	static private Logger logger = Logger.getLogger(Dao.class);
	public static Connection getConn() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/paper-manager";
		String username = "root";
		String password = "womende666"; // 不要改动此处！！修改你自己的密码
		Connection conn = null;
		try {
			Class.forName(driver); // classLoader,加载对应驱动
			conn = (Connection) DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static User findUser(String username) throws SQLException {
		User user = null;
		String password = null;
		String result = null;
		List<Paper> papers = new ArrayList<>();
		Connection conn = Dao.getConn();
		String sql = "select password, papers from user where username = '" + username + "'";
		PreparedStatement pstmt;
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			password = rs.getString(1);
			result = rs.getString(2);
			logger.info("find user "+username);
			if (result != null  && !result.isEmpty()) {
				for (String s : result.split(",")) {
					papers.add(findPaper(s));
				}
			}
			user = new User(username, password, papers);
		}
		return user;
	}
	
	public static void inputUser(User user) throws SQLException {
		Connection conn = Dao.getConn();
		String sql = "replace into user values(?,?,?)";
		PreparedStatement pstmt;
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getPaperIdList());
		pstmt.executeUpdate();
		logger.info("register successful");
		pstmt.close();
		conn.close();
	}

	public static Paper findPaper(String paperID) throws SQLException {
		Connection conn = Dao.getConn();
		PreparedStatement pstmt;
		String sql = "SELECT * FROM paper WHERE PaperID= '" + paperID + "'";
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		Paper temp = null;
		if (rs.next()) {
			temp = new Paper();
			temp.setPaperID(rs.getString(1));
			temp.setTitle(rs.getString(2));
			temp.setAuthor(rs.getString(3));
			temp.setSecondAuthor(rs.getString(4));
			temp.setDate(rs.getString(5));
			temp.setSort(rs.getInt(6));
			temp.setPublication(rs.getString(7));
			temp.setStatus(rs.getInt(8));
			temp.setKeyword(rs.getString(9));
			temp.setDescription(rs.getString(10));
			temp.setFilename(rs.getString(11));
			temp.setLevel(rs.getInt(12));
		}
		logger.info("find papr by paperid successful --Dao");
		return temp;
	}

	public static int insertPaper(Paper paper) throws SQLException {
		Connection conn = getConn();
		String sql = "REPLACE INTO paper VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		pstmt.setString(1, paper.getPaperID());
		pstmt.setString(2, paper.getTitle());
		pstmt.setString(3, paper.getAuthor());
		pstmt.setString(4, paper.getSecondAuthor());
		pstmt.setString(5, paper.getDate());
		pstmt.setLong(6, paper.getSort());
		pstmt.setString(7, paper.getPublication());
		pstmt.setInt(8, paper.getStatus());
		pstmt.setString(9, paper.getKeyword());
		pstmt.setString(10, paper.getDescription());
		pstmt.setString(11, paper.getFilename());
		pstmt.setInt(12, paper.getLevel());
		int result = pstmt.executeUpdate();
		System.out.print("add paper successfully!");
		pstmt.close();
		conn.close();
		return result;
	}

	public static int removePaper(Paper paper) throws SQLException {
		Connection conn = getConn();
		String sql = "DELETE FROM paper WHERE PaperID = " + paper.getPaperID();
		PreparedStatement pstmt;
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		int result = pstmt.executeUpdate();
		logger.info("remove paper successfully！");
		pstmt.close();
		conn.close();
		return result;
	}

	public static int findSortID(String sortstr) throws SQLException {
		String sql = "select * from third where sortname='" + sortstr + "'";
		Connection conn = Dao.getConn();
		PreparedStatement pstmt;
		int result = -1;
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(sql);
		while (rs.next()) {
			result = rs.getInt(1);
		}
		pstmt.close();
		conn.close();
		return result;
	}
}

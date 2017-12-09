package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Paper;
import model.User;
import service.Dao;
import service.ExcelGenerate;
import support.PaperSupport;

public class Admin extends PaperSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 21L;
	public String welcome() throws SQLException {
		return "welcome";
	}

	private List<Paper> paperList;

	public List<Paper> getPaperList() {
		return paperList;
	}

	public void setPaperList(List<Paper> paperList) {
		this.paperList = paperList;
	}
	
	public String audit() throws SQLException {
		findPapersByStatus();
		return "audit";
	}
	
	private int findPapersByStatus() throws SQLException {
		Connection conn = Dao.getConn();
		paperList = new ArrayList<Paper>();
		PreparedStatement pstmt;
		String sql = "SELECT * FROM paper WHERE Status=0";
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		int count = 0;
		while (rs.next()) {
			Paper temp = new Paper();
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
			paperList.add((Paper)temp);
			count++;
		}
		return count;
	}

	public String pass() throws SQLException {
		passPaper(getPaperID());
		return audit();
	}
	
	public String refuse() throws SQLException {
		refusePaper(getPaperID());
		return audit();
	}

	private void passPaper(String paperID) throws SQLException {
		Dao.setStatus(paperID, 1);
	}
	
	private void refusePaper(String paperID) throws SQLException {
		Dao.setStatus(paperID, 2);
	}

	private List<User> userList;

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String user() throws SQLException {
		findUsers();
		return "user";
	}

	private void findUsers() throws SQLException {
		User user = null;
		Connection conn = Dao.getConn();
		String sql = "select username, password, email, realName, authority from user ";
		userList = new ArrayList<User>();
		PreparedStatement pstmt;
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			user = new User();
			user.setUsername(rs.getString(1));
			user.setPassword(rs.getString(2));
			user.setEmail(rs.getString(3));
			user.setRealName(rs.getString(4));
			user.setAuthority(rs.getInt(5));
			userList.add((User)user);
		}
	}
	public String deleteUser() throws SQLException {
		Connection conn = Dao.getConn();
		System.out.println(getUsername());
		String sql = "UPDATE user SET authority=-authority WHERE username = '" + getUsername() + "'";
		System.out.println(sql);
		PreparedStatement pstmt;
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return user();
	}
	public String seePass() throws SQLException {
		setTask("seePassword" + getUsername());
		return user();
	}
	public String hidePass() throws SQLException {
		setTask(null);
		return user();
	}
	public String addAdmin() throws SQLException {
		Connection conn = Dao.getConn();
		String sql = "UPDATE user SET authority=3 WHERE username = '" + getUsername() + "'";
		PreparedStatement pstmt;
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return user();
	}
}

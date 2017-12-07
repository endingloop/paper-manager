package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import service.Dao;

public class User {
	public User() {
		super();
	}
	
	public User(String username, String password, List<Paper> papers) {
		super();
		this.username = username;
		this.password = password;
		this.papers = papers;
	}
	
	public User(String username, String password, String email, String realName, int authority) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.realName = realName;
		this.authority = authority;
	}

	public void findPapers() throws SQLException {
		Connection conn = Dao.getConn();
		String sql = "select paperID from upload where username = '" + getUsername() + "'";
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		setPapers(new ArrayList<Paper>());
		while (rs.next()) {
			getPapers().add(Dao.findPaper(rs.getString(1)));
		}
	}
	
	@Deprecated
	public String getPaperIdList() {
		StringBuffer list = new StringBuffer();
		if (papers != null && !papers.isEmpty()) {
			for (Paper temp : papers) {
				list.append(temp.getPaperID());
				list.append(",");
			}
			list.setLength(list.length() - 1);
		}
		return list.toString();
	}
	
	private String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	private String password;

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	private List<Paper> papers;

	public List<Paper> getPapers() {
		return papers;
	}
	public void setPapers(List<Paper> papers) {
		this.papers = papers;
	}
	
	private String email;
	private String realName;
	private int authority;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}

	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}

}

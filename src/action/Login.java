package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import model.Paper;
import model.User;
import service.ConnectSQL;

public class Login extends ActionSupport{
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
	
	private User findUser(String username, String password) {
		User temp = null;
		String[] result = null;
		List<Paper> papers = new ArrayList<>();
		Connection conn = ConnectSQL.getConn();
		String sql = "select password, papers from user where username = '" + username + "'";
		PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        if(rs.next()) {
	        	if(password.equals(rs.getString(1))) {
	        		result = rs.getString(2).split(",");
	        	}
	        	else {
	        		return null;
	        	}
	        }
	        StringBuffer sql2 = new StringBuffer("SELECT * FROM paper WHERE PaperID IN (");
	        for(String s: result) {
	        	sql2.append("'" + s + "',");
	        }
	        sql2.setLength(sql2.length()-1);
	        sql2.append(")");
	        System.out.println(sql2);
	        PreparedStatement pstmt2 = (PreparedStatement) conn.prepareStatement(sql2.toString());
			rs = pstmt2.executeQuery();
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
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		temp = new User(username, password, papers);
	    return temp;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() {
		user = findUser(getUsername(), getPassword());
		for(Paper p: user.getPapers()) {
			System.out.println(p.toString());
		}
		if(user != null) {
			return SUCCESS;
		}
		else {
			return INPUT;
		}
	}
}

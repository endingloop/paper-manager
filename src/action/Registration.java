package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import service.ConnectSQL;

public class Registration extends ActionSupport {
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
	private String password2;

	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String save() {
		return execute();
	}
	public String execute() {
		if(!password.equals(password2))
			return INPUT;
		Connection conn = ConnectSQL.getConn();
		String sql = "insert into user(username,password) values(?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return INPUT;
		}
		return SUCCESS;
	}
}

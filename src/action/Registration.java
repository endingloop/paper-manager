package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import model.User;
import service.ConnectSQL;
import support.UserSupport;

public class Registration extends UserSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		User user = new User(getUsername(),getPassword(),new ArrayList<>());
		setUser(user);
		Connection conn = ConnectSQL.getConn();
		String sql = "insert into user values(?,?, \"\")";
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

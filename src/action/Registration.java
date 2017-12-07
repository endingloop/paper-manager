package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import model.User;
import service.Dao;
import support.UserSupport;

public class Registration extends UserSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1234L;
	
	public String save() throws SQLException {
		return execute();
	}
	
	public String execute() throws SQLException {
		if(Dao.findUser(getUsername()) != null) {
			addActionError("用户名已存在！");
			return INPUT;
		}
		if(!getPassword().equals(getPassword2())) {
			addActionError("密码不一致！");
			return INPUT;
		}
		setUser(new User(getUsername(), getPassword(), getEmail(), getRealName(), 0));
		saveUser();
		return SUCCESS;
	}
}

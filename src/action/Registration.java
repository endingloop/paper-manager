package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import model.User;
import service.Dao;
import support.UserSupport;

public class Registration extends UserSupport {

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
		setUser(new User(getUsername(), getPassword(), null));
		saveUser();
		return SUCCESS;
	}
}

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
	private static final long serialVersionUID = 1L;
	public String save() {
		return execute();
	}
	public String execute() {
		if(!getPassword().equals(getPassword2()))
			return INPUT;
		System.out.println(getPassword());
		System.out.println(getUsername());
		User user=new User();
		user.setUsername(getUsername());
		user.setPassword(getPassword());
		user.setPapers(null);
		try {
			Dao.inputUser(user);
			System.out.print("register successful");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return SUCCESS;
	}
}

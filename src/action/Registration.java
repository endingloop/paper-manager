package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import service.Dao;
import support.UserSupport;

public class Registration extends UserSupport {

	public String save() {
		return execute();
	}
	public String execute() {
		if(!getPassword().equals(getPassword2()))
			return INPUT;

		return SUCCESS;
	}
}

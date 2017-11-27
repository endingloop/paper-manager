package action;

import java.sql.SQLException;

import model.User;
import service.Dao;
import support.UserSupport;

public class Login extends UserSupport {

	public String execute() throws SQLException {
		
		if (getUser() != null) {
			setUser(Dao.findUser(getUser().getUsername())); //不加这一句，页面不刷新 :(
			return SUCCESS;
		}

		User user = findUser(getUsername(), getPassword());
		if (user != null) {
			setUser(user);
			return SUCCESS;
		} else {
			return INPUT;
		}
	}
}
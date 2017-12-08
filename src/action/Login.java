package action;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.validation.SkipValidation;

import model.User;
import service.Dao;
import support.UserSupport;

public class Login extends UserSupport {

	private static final long serialVersionUID = 1098L;

	static private Logger logger = Logger.getLogger(Dao.class);
	
	@SkipValidation
	public String mainMenu() throws SQLException {
		logger.info("at index");
		setUser(findUser(getUser().getUsername(), getUser().getPassword())); // 不加这一句，页面不刷新 :(
		return SUCCESS;
	}
	
	public String execute() throws SQLException {
		User user = findUser(getUsername(), getPassword());
		if (user == null) {
			addActionError("用户名或密码错误，请检查您的输入");// 添加actionerror 
			return INPUT;
		}
		logger.info("user: " + user.getAuthority() + " choice: " + getAuthority());
		if (user.getAuthority() < getAuthority()) {
			addActionError("请选择适当的用户组");// 添加actionerror 
			return INPUT;
		}
		setUser(user);
		switch (getAuthority()) {
		case 3:
			return "admin";
		default:
			return SUCCESS;
		}
	}
}
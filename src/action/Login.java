package action;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import model.User;
import service.Dao;
import support.UserSupport;

public class Login extends UserSupport {
	static private Logger logger = Logger.getLogger(Dao.class);
	
	@org.apache.struts2.interceptor.validation.SkipValidation //关闭输入校验，因为我们已经启用了客户端校验
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
			addActionError("用户名或密码错误，请检查您的输入");//添加actionerror 
			return INPUT;
		}
	}
}
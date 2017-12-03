package action;

import java.sql.SQLException;

import model.User;
import service.Dao;
import support.UserSupport;

public class Login extends UserSupport {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public String execute() throws SQLException {
		
		if (getUser() != null) {
			setUser(Dao.findUser(getUser().getUsername())); //不加这一句，页面不刷新 :(
			return SUCCESS;
		}
	
	      User user = findUser(getUsername(), getPassword());
		if (user != null) {
			setUser(user);
			System.out.print(user.getPaperIdList().length());
			return SUCCESS;
		} else {
			addActionError("用户不存在不存在，或者密码不正确!请重新输入");//添加actionerror 
			return INPUT;
		}
	}
}
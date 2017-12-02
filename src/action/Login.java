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
	/**	if(Isemptyuser(getUsername())==null) {
			addActionError("账号不能为空!请重新输入");//添加actionerror
			System.out.println("用户名为空");
    		return INPUT;
		}
		if(Isemptypwd(getPassword())==null) {
			addActionError("密码不能为空!请重新输入");//添加actionerror
			System.out.println("pwd为空");
    		return INPUT;
		}*/
		User user = findUser(getUsername(), getPassword());
		if (user != null) {
			setUser(user);
			return SUCCESS;
		} else {
			addActionError("用户不存在不存在，或者密码不正确!请重新输入");//添加actionerror 
			return INPUT;
		}
	}
}
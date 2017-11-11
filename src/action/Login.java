package action;

import model.User;
import support.UserSupport;

public class Login extends UserSupport{

	public String execute() {
		User user = findUser(getUsername(), getPassword());
		if(user != null) {
			setUser(user);
			return SUCCESS;
		}
		else {
			return INPUT;
		}
	}
}
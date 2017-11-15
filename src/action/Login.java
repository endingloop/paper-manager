package action;

import model.User;
import support.UserSupport;

public class Login extends UserSupport{

	public String execute() {
		
		User user = findUser(getUsername(), getPassword());
		
		if(user != null) {
			setUser(user);
			if(getUsername().equals("admin"))
				return "admin";
			return SUCCESS;
		}
		else {
			
			return INPUT;
		}
	}
}
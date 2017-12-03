package support;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

import model.Paper;
import model.User;
import service.Dao;
import service.Sequence;

public class UserSupport extends ActionSupport implements SessionAware {

    // ---- SessionAware ----

    private Map session;

    public void setSession(Map value) {
        session = value;
    }

    public Map getSession() {
        return session;
    }
    // 
    private String username = null;

    public String getUsername() {
        return username;
    }

    public void setUsername(String value) {
        username = value;
    }

    private String password = null;

    public String getPassword() {
        return password;
    }

    public void setPassword(String value) {
        password = value;
    }

    private String password2 = null;

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String value) {
        password2 = value;
    }

    public User getUser() {
        return (User) getSession().get(Constants.USER_KEY);
    }

    public void setUser(User user) {
        getSession().put(Constants.USER_KEY, user);
    }
    
    public void saveUser() throws SQLException {
    	Dao.inputUser(getUser());
    }
  
    public User findUser(String username, String password) throws SQLException {
    	
		User user = Dao.findUser(username);
		if(user != null && user.getPassword().equals(password)) {
			return user;
		} else {
			return null;
		}
	}
}
package support;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

import model.Paper;
import model.User;
import service.ConnectSQL;

public class UserSupport extends ActionSupport implements SessionAware {
	
    public String cancel() {
        return Constants.CANCEL;
    }
    // ---- SessionAware ----

    /**
     * <p>Field to store session context, or its proxy.</p>
     */
    private Map session;

    /**
     * <p>Store a new session context.</p>
     *
     * @param value A Map representing session state
     */
    public void setSession(Map value) {
        session = value;
    }

    /**
     * <p>Provide session context.</p>
     *
     * @return session context
     */
    public Map getSession() {
        return session;
    }
    
    // ---- Username property ----

    /**
     * <p>Field to store User username.</p>
     * <p/>
     * <p>The User DAO object password proerty is immutable, so we store it
     * locally until we are ready to create the object.</p>
     */
    private String username = null;


    /**
     * <p>Provide User username.</p>
     *
     * @return Returns the User username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * <p>Store new User username</p>
     *
     * @param value The username to set.
     */
    public void setUsername(String value) {
        username = value;
    }
    // ---- Password property ----

    /**
     * <p>Field to store User password property.</p>
     * <p/>
     * <p>The User DAO object password proerty is immutable, so we store it
     * locally until we are ready to create the object.</p>
     */
    private String password = null;


    /**
     * <p>Provide User password</p>
     *
     * @return Returns the password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * <p>Store new User Password</p>
     *
     * @param value The password to set.
     */
    public void setPassword(String value) {
        password = value;
    }

    // ---- Password2 property (confirmation) ----

    /**
     * <p>Field to store the User password confirmation.</p>
     * <p/>
     * <p>When a User object is created, we ask the client to enter the
     * password twice, to help ensure the password is being typed
     * correctly.</p>
     */
    private String password2 = null;


    /**
     * <p>Provide the User password confirmation.</p>
     *
     * @return Returns the confirmationpassword.
     */
    public String getPassword2() {
        return password2;
    }

    /**
     * <p>Store a new User password confirmation.</p>
     *
     * @param value The confirmation password to set.
     */
    public void setPassword2(String value) {
        password2 = value;
    }

    // ---- User property ----

    /**
     * <p>Provide reference to User object for authenticated user.</p>
     *
     * @return User object for authenticated user.
     */
    public User getUser() {
        return (User) getSession().get(Constants.USER_KEY);
    }

    /**
     * <p>Store new reference to User Object.</p>
     *
     * @param user User object for authenticated user
     */
    public void setUser(User user) {
        getSession().put(Constants.USER_KEY, user);
    }
    
    public User findUser(String username, String password) {
		User temp = null;
		String[] result = null;
		List<Paper> papers = new ArrayList<>();
		Connection conn = ConnectSQL.getConn();
		String sql = "select password, papers from user where username = '" + username + "'";
		PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        if(rs.next()) {
	        	if(password.equals(rs.getString(1))) {
	        		result = rs.getString(2).split(",");
	        	}
	        	else {
	        		return null;
	        	}
	        }
	        StringBuffer sql2 = new StringBuffer("SELECT * FROM paper WHERE PaperID IN (");
	        for(String s: result) {
	        	sql2.append("'" + s + "',");
	        }
	        sql2.setLength(sql2.length()-1);
	        sql2.append(")");
	        System.out.println(sql2);
	        PreparedStatement pstmt2 = (PreparedStatement) conn.prepareStatement(sql2.toString());
			rs = pstmt2.executeQuery();
			while (rs.next()) {
				Paper temp1 = new Paper();
				temp1.setPaperID(rs.getString(1));
				temp1.setTitle(rs.getString(2));
				temp1.setAuthor(rs.getString(3));
				temp1.setDate(rs.getString(5));
				temp1.setKeyword(rs.getString(9));
				temp1.setPublication(rs.getString(7));
				papers.add(temp1);
			}
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		temp = new User(username, password, papers);
	    return temp;
	}
    
    // ---- Task property (utilized by UI) ----

    /**
     * <p>Field to store workflow task.</p>
     * <p/>
     * <p>The Task is used to track the state of the CRUD workflows. It can be
     * set to Constant.CREATE, Constant.EDIT, or Constant.DELETE as
     * needed.</p>
     */
    private String task = null;


    /**
     * <p>Provide worklow task.</p>
     *
     * @return Returns the task.
     */
    public String getTask() {
        return task;
    }

    /**
     * <p>Store new workflow task.</p>
     *
     * @param value The task to set.
     */
    public void setTask(String value) {
        task =  value;
    }
    
	private String paperID = null;

    public String getPaperID() {
		return paperID;
	}

	public void setPaperID(String paperID) {
		this.paperID = paperID;
	}
	
    // ---- Paper property ----

    /**
     * <p>Obtain the cached Paper object, if any. </p>
     *
     * @return Cached Paper object or null
     */
    public Paper getPaper() {
        return (Paper) getSession().get(Constants.PAPER_KEY);
    }

    /**
     * <p>Store new User Paper.</p>
     *
     * @param subscription
     */
    public void setPaper(Paper subscription) {
        getSession().put(Constants.PAPER_KEY, subscription);
    }
    
	public Paper findPaper (String paperID){
		Connection conn = ConnectSQL.getConn();
		PreparedStatement pstmt;
        String sql = "SELECT * FROM paper WHERE PaperID= '" + paperID + "'";
  		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			Paper temp = new Paper();
			temp.setPaperID(rs.getString(1));
			temp.setTitle(rs.getString(2));
			temp.setAuthor(rs.getString(3));
			temp.setDate(rs.getString(5));
			temp.setPublication(rs.getString(7));
			return temp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		return null;
	}
	public Paper findPaper(){
		return findPaper(getPaperID());
	}
}
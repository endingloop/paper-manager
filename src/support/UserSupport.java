package support;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

import model.Paper;
import model.User;
import service.ConnectSQL;

public class UserSupport extends ActionSupport implements SessionAware {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 109L;

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
		String sql = "select password, papers from user where username = '" + username + "' and password='"+password+"';";
		PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        if(rs.next()) {
	        	
	        		result = rs.getString(2).split(",");
	        	
	        	
	        }else {
	        	
	        	return null;
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
	public static void dd(List<Paper> result ) throws Exception  
	{  
	    // 第一步，创建一个webbook，对应一个Excel文件  
	    HSSFWorkbook wb = new HSSFWorkbook();  
	    // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
	    HSSFSheet sheet = wb.createSheet("学生表一");  
	    // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
	    HSSFRow row = sheet.createRow((int) 0);  
	    // 第四步，创建单元格，并设置值表头 设置表头居中  
	    HSSFCellStyle style = wb.createCellStyle();  
	   

	    HSSFCell cell = row.createCell((short) 0);  
	    cell.setCellValue("论文ID");  
	    cell.setCellStyle(style);  
	    cell = row.createCell((short) 1);  
	    cell.setCellValue("题目");  
	    cell.setCellStyle(style);  
	    cell = row.createCell((short) 2);  
	    cell.setCellValue("作者");  
	    cell.setCellStyle(style);  
	    cell = row.createCell((short) 3);  
	    cell.setCellValue("日期");
	    cell = row.createCell((short) 4);  
	    cell.setCellValue("关键字"); 
	    cell = row.createCell((short) 5);  
	    cell.setCellValue("发布商"); 
	    cell.setCellStyle(style);  

	    // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
	    
	    List list = result; 

	    for (int i = 0; i < list.size(); i++)  
	    {  
	        row = sheet.createRow((int) i + 1);  
	        Paper stu = (Paper) list.get(i);  
	        // 第四步，创建单元格，并设置值  
	        row.createCell((short) 0).setCellValue(stu.getPaperID());
	        row.createCell((short) 1).setCellValue(stu.getTitle());  
	        row.createCell((short) 2).setCellValue(stu.getAuthor());  
	        row.createCell((short) 3).setCellValue(stu.getDate());
	        row.createCell((short) 4).setCellValue(stu.getKeyword());  
	        row.createCell((short) 5).setCellValue(stu.getPublication());  
	        cell = row.createCell((short) 6);  
	       
	    }  
	    // 第六步，将文件存到指定位置  
	    try  
	    {  
	        FileOutputStream fout = new FileOutputStream("D:\\eclipse-jee-oxygen-1a-win32-x86_64\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\paper-manager\\js\\students.xls");  
	        wb.write(fout);  
	        fout.close();  
	        
	    }  
	    catch (Exception e)  
	    {  
	        e.printStackTrace();  
	    }  

		return ;
	}
}
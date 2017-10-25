package action;

import java.io.*;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.Paper;
import service.Sequence;

public class AddPaper extends ActionSupport {

	/**
	 * 初始化版本
	 * 增加了文件上传功能
	 */
	private static final long serialVersionUID = 1322L;
	private String id;
	private String destPath;
	private Paper paperBean;
	private String username;
    
	//注意，file并不是指前端jsp上传过来的文件本身，而是文件上传过来存放在临时文件夹下面的文件
    private File file;
    
    //提交过来的file的名字
    private String fileFileName;
    
    //提交过来的file的MIME类型
    private String fileContentType;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public File getFile()
    {
        return file;
    }

    public void setFile(File file)
    {
        this.file = file;
    }

    public String getFileFileName()
    {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName)
    {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType()
    {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType)
    {
        this.fileContentType = fileContentType;
    }
	@Override
	public String execute() throws Exception{
	      /* Copy file to a safe location */
	      destPath = ServletActionContext.getServletContext().getRealPath("/upload");
		  setId(Sequence.nextId());

	      try{
	     	 System.out.println("Src File : " + file);
	     	 username = "Dst File : " + destPath + "/" + getId();
	     	 System.out.println("Dst File : " + destPath + "/" + getId());
	     	    	 
	     	 File destFile  = new File(destPath, getId());
	    	 FileUtils.copyFile(file, destFile);
	  
	      }catch(IOException e){
	         e.printStackTrace();
	         return ERROR;
	      }
		System.out.println(paperBean);
		insert(paperBean);
		return SUCCESS;
	}
	private static Connection getConn() {
	    String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://localhost:3306/paper_manager";
	    String username = "root";
	    String password = "";
	    Connection conn = null;
	    try {
	        Class.forName(driver); //classLoader,加载对应驱动
	        conn = (Connection) DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
	private int insert(Paper paper) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "insert into paper (PaperID,FirstAuthorID,Title,Keywords,Date,JournalID,SortID,File) values(?,?,?,?,?,?,?,?)";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setString(1, getId());
	        pstmt.setString(2, paper.getAuthor());
	        pstmt.setString(3, paper.getTitle());
	        pstmt.setString(4, paper.getKeyword());
	        pstmt.setString(5, paper.getDate());
	        pstmt.setString(6, paper.getPublication());
	        pstmt.setString(7, paper.getCategory());
	        pstmt.setString(8, destPath + "/" + getId());

	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	public Paper getPaperBean() {
		return paperBean;
	}

	public void setPaperBean(Paper paperBean) {
		this.paperBean = paperBean;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}

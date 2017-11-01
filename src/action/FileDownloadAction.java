package action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.struts2.ServletActionContext;

import java.sql.Connection;
import com.opensymphony.xwork2.ActionSupport;

import service.ConnectSQL;

public class FileDownloadAction extends ActionSupport
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 421L;
	private String fileName;
	private String paperID;

	public InputStream getDownloadFile()
    {
		fileName = queryFileName(paperID);
        try {
			fileName = new String(fileName.getBytes(), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return ServletActionContext.getServletContext().getResourceAsStream("upload/" + paperID);
    }
    
    private String queryFileName(String id) {
		Connection conn = ConnectSQL.getConn();
		String sql = "select paperID, FILE from paper where paperID = " + paperID;
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        if(rs.next()) {
	        	return rs.getString(2);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	@Override
    public String execute() throws Exception
    {
        return SUCCESS;
    }

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPaperID() {
		return paperID;
	}

	public void setPaperID(String paperID) {
		this.paperID = paperID;
	}
}
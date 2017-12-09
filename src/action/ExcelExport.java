package action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import service.Dao;
import support.UserSupport;

public class ExcelExport extends UserSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fileName;
	public int tip;


	public int getTip() {
		return tip;
	}

	public void setTip(int tip) {
		this.tip = tip;
	}

	@Override
    public String execute() throws Exception
    {
		System.out.println(tip);
        return SUCCESS;
    }

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
    
	
	public InputStream getDownloadFile()
    {
		switch(tip) {
		case 0:
			fileName = getUser().getEmail()+"WorkListQueryResult.xls";
			break;
		case 1:
			fileName=getUser().getEmail()+"PersonalworkloadQueryResult.xls";
			break;
		case 2:
			fileName="GenerateQueryResult.xls";
			break;
		}
		
		System.out.println(fileName);
        try {
			fileName = new String(fileName.getBytes(),"ISO8859-1");

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return ServletActionContext.getServletContext().getResourceAsStream("upload/" + fileName);
    }
    


}

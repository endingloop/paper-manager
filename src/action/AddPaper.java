package action;

import java.io.*;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import model.Paper;

public class AddPaper extends ActionSupport {

	/**
	 * 初始化版本
	 * 增加了文件上传功能
	 */
	private static final long serialVersionUID = 1322L;
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
	      String destPath = ServletActionContext.getServletContext().getRealPath("/upload");

	      try{
	     	 System.out.println("Src File : " + file);
	     	 System.out.println("Dst File : " + destPath + "/" + fileFileName);
	     	    	 
	     	 File destFile  = new File(destPath, fileFileName);
	    	 FileUtils.copyFile(file, destFile);
	  
	      }catch(IOException e){
	         e.printStackTrace();
	         return ERROR;
	      }
		System.out.println(paperBean);
		return SUCCESS;
	}

	public Paper getPaperBean() {
		return paperBean;
	}

	public void setPaperBean(Paper paperBean) {
		this.paperBean = paperBean;
	}
}

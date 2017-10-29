package action;

import java.io.*;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.SQLException;

import model.Paper;
import service.ConnectSQL;
import service.Sequence;

public class AddPaper extends ActionSupport {

	/**
	 * 初始化版本 增加了文件上传功能
	 * 优化代码结构
	 */
	private static final long serialVersionUID = 1322L;
	private String destPath;
	private Paper paperBean;

	// 注意，file并不是指前端jsp上传过来的文件本身，而是文件上传过来存放在临时文件夹下面的文件
	private File file;

	// 提交过来的file的名字
	private String fileFileName;

	// 提交过来的file的MIME类型
	private String fileContentType;

	@Override
	public String execute() throws Exception {
		/* Copy file to a safe location */
		destPath = ServletActionContext.getServletContext().getRealPath("/upload");
		paperBean.setPaperID(Sequence.nextId());

		try {
			System.out.println("Src File : " + file);
			System.out.println("Dst File : " + destPath + "/" + paperBean.getPaperID());

			File destFile = new File(destPath, paperBean.getPaperID());
			FileUtils.copyFile(file, destFile);

		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
		System.out.println(paperBean);
		insert(paperBean);
		return SUCCESS;
	}

	private int insert(Paper paper) {
		Connection conn = ConnectSQL.getConn();
		int i = 0;
		String sql = "insert into paper (PaperID,FirstAuthorID,Title,Keywords,Date,JournalID,SortID,FILE) values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, paper.getPaperID());
			pstmt.setString(2, paper.getAuthor());
			pstmt.setString(3, paper.getTitle());
			pstmt.setString(4, paper.getKeyword());
			pstmt.setString(5, paper.getDate());
			pstmt.setString(6, paper.getPublication());
			pstmt.setString(7, paper.getCategory());
			pstmt.setString(8, fileFileName);

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

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
}

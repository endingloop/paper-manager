package action;

import java.io.*;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Paper;
import service.ConnectSQL;
import service.Sequence;

public class AddPaper extends ActionSupport {
	public int first;
	public String second;
	public String third;
	public String dates;
	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}

	public String getThird() {
		return third;
	}

	public void setThird(String third) {
		this.third = third;
	}

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
	private int findSortID(String sortstr) {
		String sql ="select * from third where sortname='"+sortstr+"';";
		Connection conn=ConnectSQL.getConn();
		PreparedStatement pstmt;
		int result=-1;
		try {
			pstmt= (PreparedStatement)conn.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				result=rs.getInt(1);
				System.out.println(rs.getInt(1));
			}
			
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	private int insert(Paper paper) {
		Connection conn = ConnectSQL.getConn();
		int i = 0;
		System.out.println(getFirst());
		System.out.println(getSecond());
		System.out.println(getThird());
		System.out.println(getDates());
		int num=findSortID(getThird());
		
		String sql = "insert into paper (PaperID,FirstAuthorID,Title,Keywords,Date,JournalID,SortID,FILE) values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, paper.getPaperID());
			pstmt.setString(2, paper.getAuthor());
			pstmt.setString(3, paper.getTitle());
			pstmt.setString(4, paper.getKeyword());
			pstmt.setString(5, getDates());
			pstmt.setString(6, paper.getPublication());
			pstmt.setLong(7, num);
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

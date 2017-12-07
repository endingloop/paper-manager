package support;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import model.Paper;
import service.Dao;
import service.Sequence;

public class PaperSupport extends UserSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 121L;

	static private Logger logger = Logger.getLogger(PaperSupport.class);

	// -----------前端传过来的论文信息----------
	//分类信息
	public String third;
	public String getThird() {
		return third;
	}
	public void setThird(String third) {
		this.third = third;
	}
	//文件信息
	private File file;
	private String fileFileName;
	private String fileContentType;
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
	public String Hidden1;
	public String Hidden2;
	public String firststr;
	public String secondstr;
	public String thirdstr;
	public String levelname;

	public ResultSet findsort() {
		Paper paper = getPaper();
		PreparedStatement pstmt;
		Connection conn = Dao.getConn();
		String sql = "select first.sortname ,second.sortname,third.sortname from third, second ,first where thirdID="
				+ paper.getSort() + " and third.upper=second.secondID and second.upper=first.firstID;";
		System.out.println(sql);
		ResultSet rs = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("success show!");
				firststr = rs.getString(1);
				secondstr = rs.getString(2);
				thirdstr = rs.getString(3);
				System.out.println(firststr + " " + secondstr + " " + thirdstr);
			} else {
				firststr = "请重新选择一级分类";
				secondstr = "请重新选择二级分类";
				thirdstr = "请重新选择三级分类";
			}

			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}
	
	public String getLevelname() {
		return levelname;
	}
	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}
	public String getFirststr() {
		return firststr;
	}
	public void setFirststr(String firststr) {
		this.firststr = firststr;
	}
	public String getSecondstr() {
		return secondstr;
	}
	public void setSecondstr(String secondstr) {
		this.secondstr = secondstr;
	}
	public String getThirdstr() {
		return thirdstr;
	}
	public void setThirdstr(String thirdstr) {
		this.thirdstr = thirdstr;
	}
	public String getHidden2() {
		return Hidden2;
	}
	public void setHidden2(String hidden2) {
		Hidden2 = hidden2;
	}
	public String getHidden1() {
		return Hidden1;
	}
	public void setHidden1(String hidden1) {
		Hidden1 = hidden1;
	}
	//任务标志
	private String task = null;

	public String getTask() {
		return task;
	}

	public void setTask(String value) {
		task = value;
	}
	//论文ID
	private String paperID = null;

	public String getPaperID() {
		return paperID;
	}

	public void setPaperID(String paperID) {
		this.paperID = paperID;
	}
	//论文
	public Paper getPaper() {
		return (Paper) getSession().get(Constants.PAPER_KEY);
	}

	public void setPaper(Paper paper) {
		getSession().put(Constants.PAPER_KEY, paper);
	}

	public String[] authorANDkeywords(String str) {
		String tempSecondAuthor = "";
		String tempKeywords = "";
		char[] wordArray = str.toCharArray();
		int len = wordArray.length;
		int tip = 0;
		for (int i = 0; i < len; i++) {
	
			if (wordArray[i] == '@') {
				tip = i;
				break;
			}
			tempSecondAuthor += wordArray[i];
	
		}
		for (int j = tip + 1; j < len; j++) {
			tempKeywords += wordArray[j];
		}
		String[] temp = { tempSecondAuthor, tempKeywords };
		return temp;
	}
	public Paper findPaper() throws SQLException {
		return Dao.findPaper(getPaperID());
	}

	public void removePaper() throws SQLException {
		Paper paper = getPaper();
		//删除论文文件
		String destPath = ServletActionContext.getServletContext().getRealPath("/upload");
		File file = new File(destPath, paper.getPaperID());
		file.delete();
		//从用户信息中清除
		Dao.removeUpload(paper.getPaperID());
		//从数据库删除
		Dao.removePaper(getPaper());
	}
	
	public void setupPaper() throws SQLException {
		//合并 + 存储
		String[] b = authorANDkeywords(getHidden1());
		logger.info(getHidden1());
		getPaper().setSecondAuthor(b[0]);
		getPaper().setKeyword(b[1]);
		// 指定新ID
		setPaperID(Sequence.nextId());
		// 添加到upload
		Dao.addUpload(getUser().getUsername(), getPaperID()); 
		logger.info(getPaperID());
	}
	
	public void savePapers() throws IOException, SQLException {
		Paper paper = getPaper();
		paper.setSort(Dao.findSortID(getThird()));
		paper.setPaperID(getPaperID());
		if (file != null) {
			paper.setFilename(fileFileName);
			// 保存论文文件
			String destPath = ServletActionContext.getServletContext().getRealPath("/upload");
			logger.info(destPath + fileFileName);
			File destFile = new File(destPath, paper.getPaperID());
			FileUtils.copyFile(file, destFile);
		}
		// 保存到数据库
		Dao.insertPaper(paper);
	}

}

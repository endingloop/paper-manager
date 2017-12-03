package support;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import model.Paper;
import service.Dao;
import service.Sequence;

public class PaperSupport extends UserSupport {
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
		getUser().getPapers().remove(getPaper());
		//从数据库删除
		Dao.removePaper(getPaper());
	}

	public void CreatePaper() {
		setPaperID(Sequence.nextId()); // 指定新ID
		getUser().getPapers().add(getPaper()); // 添加到User
		System.out.println("tongbuuser1");
		System.out.println(getPaperID());
		
	}

	public void savePaper() throws IOException, SQLException {
		Paper paper = getPaper();
		paper.setSort(Dao.findSortID(getThird()));
		paper.setPaperID(getPaperID());
		if (file != null) {
			paper.setFilename(fileFileName);
			// 保存论文文件
			String destPath = ServletActionContext.getServletContext().getRealPath("/upload");
			System.out.println(destPath);
			File destFile = new File(destPath, paper.getPaperID());
			FileUtils.copyFile(file, destFile);
		}
		// 保存到数据库
		Dao.insertPaper(paper);
		
	}
	
}

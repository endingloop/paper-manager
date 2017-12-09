package action;

import java.io.*;
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
import support.Constants;
import support.PaperSupport;
import support.UserSupport;

public class PaperAction extends PaperSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 213L;
	static private Logger logger = Logger.getLogger(PaperAction.class);


	public String save() throws Exception {
		// 初始化重要数据
	
		if (Constants.DELETE.equals(getTask())) {
			removePaper();
		}
		if (Constants.CREATE.equals(getTask())) {
			setupPaper();
			savePapers();
		}
		if (Constants.EDIT.equals(getTask())) {
			savePapers();
		}
		return SUCCESS;
	}
	
	public String input() {
		setPaper(new Paper());
		setTask(Constants.CREATE);
		return INPUT;
	}
	
	public String find() throws SQLException {
		//用paperID到数据库去找我们的Paper
        Paper paper = findPaper();
        if (paper == null) {
            return ERROR;
        }
        setPaper(paper);
        findsort();
        levelname=Dao.matchlevel(paper.getLevel());
        return INPUT;
    }
	
	public String edit() throws SQLException {		
		setTask(Constants.EDIT);
		return find();
	}
	
	public String delete() throws SQLException {
		setTask(Constants.DELETE);
  		return find();
	}
	
}

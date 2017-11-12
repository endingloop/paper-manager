package action;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import model.Paper;
import service.Dao;
import service.Sequence;
import support.Constants;
import support.PaperSupport;
import support.UserSupport;

public class PaperAction extends PaperSupport {

	public String save() throws Exception {
		// 初始化重要数据
		if (Constants.DELETE.equals(getTask())) {
			removePaper();
		}
		if (Constants.CREATE.equals(getTask())) {
			CreatePaper();
			savePaper();
		}
		if (Constants.EDIT.equals(getTask())) {
			savePaper();
		}
		saveUser();
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

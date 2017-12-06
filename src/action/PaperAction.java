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
	private static final long serialVersionUID = 1L;
	static private Logger logger = Logger.getLogger(PaperAction.class);


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
			
			savePapers();
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
	public ResultSet findsort() {
		Paper paper = getPaper();
		 PreparedStatement pstmt;
			Connection conn = Dao.getConn();
			String sql = "select first.sortname ,second.sortname,third.sortname from third, second ,first where thirdID=" + paper.getSort() + " and third.upper=second.secondID and second.upper=first.firstID;";
			System.out.println(sql);
			ResultSet rs=null;
			try {
				pstmt = (PreparedStatement) conn.prepareStatement(sql);
				 rs = pstmt.executeQuery();
				 if(rs.next()) {
					 System.out.println("success show!");
					 firststr=rs.getString(1);
						secondstr=rs.getString(2);
						thirdstr=rs.getString(3);
						System.out.println(firststr+" "+secondstr+" "+thirdstr);
				 }else {
					 firststr="请重新选择一级分类";
						secondstr="请重新选择二级分类";
						thirdstr="请重新选择三级分类";
				 }
				
				 
				 pstmt.close();
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	return rs;
	}
	
}

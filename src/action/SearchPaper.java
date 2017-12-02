package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

import model.Paper;
import service.Dao;

public class SearchPaper extends ActionSupport {
	
	private static final long serialVersionUID = 2213L;
	static private Logger logger = Logger.getLogger(SearchPaper.class);
	private int selectchoice;
	private String keyword;
	private List<Paper> result;
	private int papernum;
	
	public String execute() {
		return SUCCESS;
	}

	private int querySql(String sql) throws SQLException {
		Connection conn = Dao.getConn();
		result = new ArrayList<>();
		PreparedStatement pstmt;
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		int count = 0;
		while (rs.next()) {
			Paper temp = new Paper();
			temp.setPaperID(rs.getString(1));
			temp.setTitle(rs.getString(2));
			temp.setAuthor(rs.getString(3));
			temp.setSecondAuthor(rs.getString(4));
			temp.setDate(rs.getString(5));
			temp.setSort(rs.getInt(6));
			temp.setPublication(rs.getString(7));
			temp.setStatus(rs.getInt(8));
			temp.setKeyword(rs.getString(9));
			temp.setDescription(rs.getString(10));
			temp.setFilename(rs.getString(11));
			temp.setLevel(rs.getInt(12));
			result.add(temp);
			count++;
		}
		return count;
	}


	public String chooseSearch() {
		String sql = null;
		switch (selectchoice) {
		case 1:
			sql = "SELECT * FROM paper WHERE KeyWords LIKE '%" + keyword + "%'";
			break;
		case 2:
			sql = "SELECT * FROM paper WHERE Title LIKE '%" + keyword + "%'";
			break;
		case 3:
			sql = "SELECT * FROM paper WHERE FirstAuthorID='" + keyword + "'";
			break;
		case 4:
			sql = "SELECT * FROM paper WHERE Date ='" + keyword + "'";
			break;
		case 5:
			sql = "SELECT * FROM paper WHERE JournalID='" + keyword + "'";
			break;
		}
		try {
			papernum = querySql(sql);
			logger.info(sql + " NUMBER: " + papernum);
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;

	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getSelectchoice() {
		return selectchoice;
	}

	public void setSelectchoice(int selectchoice) {
		this.selectchoice = selectchoice;
	}

	public List<Paper> getResult() {
		return result;
	}

	public void setResult(List<Paper> result) {
		this.result = result;
	}

	public int getPapernum() {
		return papernum;
	}

	public void setPapernum(int papernum) {
		this.papernum = papernum;
	}

}

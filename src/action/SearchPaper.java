package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import model.Paper;
import service.ConnectSQL;

public class SearchPaper extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String keyword;
	private List<Paper> result;

	public String execute() {
		return SUCCESS;
	}
	private int querySql(String sql) {
		Connection conn = ConnectSQL.getConn();
		result = new ArrayList<>();
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Paper temp = new Paper();
				temp.setPaperID(rs.getString(1));
				temp.setTitle(rs.getString(2));
				temp.setAuthor(rs.getString(3));
				temp.setDate(rs.getString(5));
				temp.setKeyword(rs.getString(9));
				temp.setPublication(rs.getString(7));
				result.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
	}
	public String searchTitle() {
		String sql = "SELECT * FROM paper WHERE Title LIKE '%" + keyword + "%'";
		querySql(sql);
		for(Paper t:result) {
			System.out.println(t);
		}
		return SUCCESS;
	}

	public String searchAuthor() {
		String sql = "SELECT * FROM paper WHERE FirstAuthorID='" + keyword + "'";
		querySql(sql);
		for(Paper t:result) {
			System.out.println(t);
		}
		return SUCCESS;
	}

	public String searchJournal() {
		String sql = "SELECT * FROM paper WHERE JournalID='" + keyword + "'";
		querySql(sql);
		return SUCCESS;
	}
	
	public String searchKeyword() {
		String sql = "SELECT * FROM paper WHERE KeyWords LIKE '%" + keyword + "%'";
		querySql(sql);
		return SUCCESS;
	}
	
	public String searchDate() {
		String sql = "SELECT * FROM paper WHERE Date ='" + keyword + "'";
		querySql(sql);
		return SUCCESS;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public List<Paper> getResult() {
		return result;
	}

	public void setResult(List<Paper> result) {
		this.result = result;
	}
}

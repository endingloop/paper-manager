package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Paper;
import service.Dao;
import service.ExcelGenerate;
import support.PaperSupport;

public class Admin extends PaperSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Paper> result;

	public List<Paper> getResult() {
		return result;
	}

	public void setResult(List<Paper> result) {
		this.result = result;
	}
	
	public String welcome() throws SQLException {
		return "welcome";
	}
	
	public String audit() throws SQLException {
		findPapersByStatus();
		return "audit";
	}
	
	public String pass() throws SQLException {
		passPaper(getPaperID());
		return audit();
	}
	
	public String refuse() throws SQLException {
		refusePaper(getPaperID());
		return audit();
	}

	private void passPaper(String paperID) throws SQLException {
		Dao.setStatus(paperID, 1);
	}
	
	private void refusePaper(String paperID) throws SQLException {
		Dao.setStatus(paperID, 2);
	}

	private int findPapersByStatus() throws SQLException {
		Connection conn = Dao.getConn();
		result = new ArrayList<>();
		PreparedStatement pstmt;
		String sql = "SELECT * FROM paper WHERE Status=0";
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
}

package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Paper;
import service.ConnectSQL;

public class update {
	public String paperID;
	public String dates;
	private Paper paper;


	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public String execute() {
		System.out.println(getPaperID());

		PreparedStatement pstmt;
		Connection conn = ConnectSQL.getConn();
		String sql = "select * from paper where paperID='" + getPaperID() + "';";
		System.out.println(sql);
		paper = new Paper();
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				paper.setAuthor(rs.getString(3));
				paper.setSecondauthor(rs.getString(4));
				paper.setKeyword(rs.getString(9));
				paper.setDate(rs.getString(5));
				paper.setTitle(rs.getString(2));
				paper.setPublication(rs.getString(7));
			}
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "success";
	}

	public String getPaperID() {
		return paperID;
	}

	public void setPaperID(String paperID) {
		this.paperID = paperID;
	}
}

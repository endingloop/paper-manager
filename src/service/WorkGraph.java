package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import action.SearchPaper;
import model.Paper;

public class WorkGraph{

	static private Logger logger = Logger.getLogger(WorkGraph.class);

	public static String[] findAuthors(String name) throws SQLException {
		Connection conn = Dao.getConn();
		List<String> result = new ArrayList<>();
		result.add(name);
		PreparedStatement pstmt;
		//1
		String sql = "SELECT SecondAuthorID FROM paper WHERE FirstAuthorID='" + name + "'";
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Paper temp = new Paper();
			temp.setSecondAuthor(rs.getString(1));

			for (String s : temp.getSecondAuthorList()) {
				if (!result.contains(s))
					result.add(s);
			}
		}
		//2
		sql = "SELECT FirstAuthorID FROM paper WHERE SecondAuthorID REGEXP '[[:<:]]" + name + "[[:>:]]'";
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			String s = rs.getString(1);
			if (!result.contains(s))
				result.add(s);
		}
		logger.info(result);
		return result.toArray(new String[0]); //数组不能强制类型转化，使用这种格式
	}
	
}

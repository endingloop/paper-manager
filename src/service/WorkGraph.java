package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import model.Paper;

public class WorkGraph{

	static private Logger logger = Logger.getLogger(WorkGraph.class);

	public static Map<String, Integer> findAuthors(String name) throws SQLException {
		Connection conn = Dao.getConn();
		Map<String, Integer> m1 = new LinkedHashMap<String, Integer>();
		m1.put(name, 0);
		PreparedStatement pstmt;
		String sql = "SELECT FirstAuthorID,SecondAuthorID FROM paper WHERE (FirstAuthorID='" + name 
				+ "' OR SecondAuthorID REGEXP '[[:<:]]" + name + "[[:>:]]') and Status =1";
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Paper temp = new Paper();
			temp.setSecondAuthor(rs.getString(2));
				for (String s : temp.getSecondAuthorList()) {	
					if (!m1.containsKey(s))	{
							m1.put(s, 1);
					}else {
					
						int t = m1.get(s);
							m1.put(s, t+1);
					}
			}
			
			
			String s = rs.getString(1);
			if (!m1.containsKey(s))
				m1.put(s, 1);
			else {
				int t = m1.get(s);
				m1.put(s, t+1);
			}
		}
		logger.info(m1);
		return m1;
	}
	
}

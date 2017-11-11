package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Paper;
import service.ConnectSQL;
import support.Constants;
import support.UserSupport;
public class PaperAction extends UserSupport {
    public String find() {

        Paper paper = findPaper();

        if (paper == null) {
            return ERROR;
        }
        setPaper(paper);
        return INPUT;

    }
	public String edit() {
		delete();
		return INPUT;
	}
	public String delete() {
		Connection conn = ConnectSQL.getConn();
		PreparedStatement pstmt;
        String sql = "DELETE FROM paper WHERE PaperID= '" + getPaperID() + "'";
  		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.executeUpdate();
			return SUCCESS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		return ERROR;
	}
}

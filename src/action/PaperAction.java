package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import model.Paper;
import service.ConnectSQL;
import support.UserSupport;
public class PaperAction extends UserSupport {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String find() {

        Paper paper = findPaper();

        if (paper == null) {
            return ERROR;
        }
        setPaper(paper);
        return INPUT;

    }
	
	public String delete() {
		Connection conn = ConnectSQL.getConn();
		PreparedStatement pstmt;
		PreparedStatement pstmt1;
        String sql = "DELETE FROM paper WHERE PaperID= '" + getPaperID() + "'";
  		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.executeUpdate();
			sql="DELETE FROM relationtable where paperID='"+getPaperID()+"'";
			pstmt1= (PreparedStatement) conn.prepareStatement(sql);
			pstmt1.executeUpdate();
			deluserinfo(getPaperID());
			getUser().setPapers(findUser(getUser().getUsername(),getUser().getPassword()).getPapers());
			return SUCCESS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		return ERROR;
	}
	public String endadd() {
		getUser().setPapers(findUser(getUser().getUsername(),getUser().getPassword()).getPapers());
		return SUCCESS;
	}
	public  String deluserinfo(String str) {
		System.out.println("进入字符串");
		Connection conn=ConnectSQL.getConn();
		String sql="select * from user where papers like '%"+str+"%';";
		PreparedStatement pstmt;
		PreparedStatement pstmt1;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(3));
				String[] b=rs.getString(3).trim().split(",");
				List<String> listA = Arrays.asList(b);
				int index=listA.indexOf(str);
				System.out.println(index);
				
				String temp="";
				for(int i=0;i<listA.size();i++) {
					if(index==i) {
						temp=temp;
					}else {
						temp=temp+listA.get(i)+",";
					}
					
				}
				System.out.println(temp);
				sql="update user set papers='"+temp+"' where  username='"+rs.getString(1)+"';";
				pstmt1= (PreparedStatement) conn.prepareStatement(sql);
				System.out.println(sql);
				pstmt1.executeUpdate(sql);
			}
		
			System.out.println("delete success！");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}

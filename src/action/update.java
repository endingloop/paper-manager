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

public class update  extends UserSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 61L;

	

	public String paperID;
	public String dates;
	private Paper paper;
	public String firststr;
	public String secondstr;
	public String thirdstr;
	public String third;
	public String datetime;
	public String author1;
	public String author2;
	public String author3;
	public String author4;
	public String author5;


	public String getThird() {
		return third;
	}

	public void setThird(String third) {
		this.third = third;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getFirststr() {
		return firststr;
	}

	public void setFirststr(String firststr) {
		this.firststr = firststr;
	}

	public String getSecondstr() {
		return secondstr;
	}

	public void setSecondstr(String secondstr) {
		this.secondstr = secondstr;
	}

	public String getThirdstr() {
		return thirdstr;
	}

	public void setThirdstr(String thirdstr) {
		this.thirdstr = thirdstr;
	}

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
				paper.setCategory(rs.getString(6));
				dates=rs.getString(5);
				int num=rs.getInt(6);
				System.out.println(num);
				findsort(num);
				
			}
			
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		authortabledelfirst(getPaperID());
		return "success";
	}
	
	public String authortabledelfirst(String paperID) {
		 
		  String sql ="select * from paper where paperID='"+paperID+"';";
			Connection conn=ConnectSQL.getConn();
			PreparedStatement pstmt;
			PreparedStatement pstmt1;
			
				try {
					pstmt= (PreparedStatement)conn.prepareStatement(sql);
					System.out.println(sql);
					ResultSet rs = pstmt.executeQuery(sql);
					while(rs.next()) {
						String[] b=rs.getString(4).trim().split(",");
						System.out.println(b.length);
						for(int i=0;i<b.length;i++) {
							delfirstauthor(b[i]);
						}
						
					}
					System.out.println("first删除authortable表成功！");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		  return "ok";
	  }
	public void delfirstauthor(String str) {
		System.out.println("add author "+str);
		
		int len=str.length();
		if(len!=0) {
			String sql="delete from authorlist where authorname='"+str+"'";
			Connection conn = ConnectSQL.getConn();
			PreparedStatement stm1=null;
			try {
				stm1=(PreparedStatement) conn.prepareStatement(sql);
				stm1.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return;
		
	}
 public ResultSet findsort(int str) {
	 PreparedStatement pstmt;
		Connection conn = ConnectSQL.getConn();
		String sql = "select first.sortname ,second.sortname,third.sortname from third, second ,first where thirdID=" + str + " and third.upper=second.secondID and second.upper=first.firstID;";
		System.out.println(sql);
		ResultSet rs=null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			 rs = pstmt.executeQuery();
			 while(rs.next()) {
				 System.out.println("success show!");
				 firststr=rs.getString(1);
					secondstr=rs.getString(2);
					thirdstr=rs.getString(3);
			 }
			 pstmt.close();
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 return rs;
 }
 public int findSortID(String sortstr) {
		
		String sql ="select * from third where sortname='"+sortstr+"';";
		Connection conn=ConnectSQL.getConn();
		PreparedStatement pstmt;
		int result=-1;
		try {
			pstmt= (PreparedStatement)conn.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				result=rs.getInt(1);
				System.out.println(rs.getInt(1));
			}
			
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
  public String updateSubmit() {
	 
	  Connection conn = ConnectSQL.getConn();
		System.out.println(getThird());
		int num=findSortID(getThird());
		String sql = "update paper set title='"+paper.getTitle()+
		"',FirstAuthorID='"+paper.getAuthor()+"',SecondAuthorID='"+
			paper.getSecondauthor()+"',KeyWords='"
		+paper.getKeyword()+"',JournalID='"+paper.getPublication()+"',SortID="+num+
		",Date='"+getDatetime()+"' where paperID='"+getPaperID()+"';";
		System.out.println(sql);
		PreparedStatement pstmt;
		
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			 pstmt.executeUpdate();
			 pstmt.close();
				conn.close();
			 System.out.println("update paper table success!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		getUser().setPapers(findUser(getUser().getUsername(),getUser().getPassword()).getPapers());
		relationtablefix(getPaperID());
		authortablefix(getPaperID());
	  return "success";
  }
  public String relationtablefix(String paperID) {
	  String[] authors = {"","","","",""};
	  String sql ="select * from  paper, relationtable where paper.paperID='"+paperID+"' and paper.paperID=relationtable.paperID;";
		Connection conn=ConnectSQL.getConn();
		PreparedStatement pstmt;
		PreparedStatement pstmt1;
		
			try {
				pstmt= (PreparedStatement)conn.prepareStatement(sql);
				System.out.println(sql);
				ResultSet rs = pstmt.executeQuery(sql);
				while(rs.next()) {
					String[] b=rs.getString(4).trim().split(",");
					System.out.println(b.length);
					for(int i=0;i<b.length;i++) {
						authors[i]=b[i];
					}
					
					
					sql="update relationtable set author='"+rs.getString(3)+"',author1='"+authors[0]+"',author2='"+authors[1]+"',author3='"+authors[2]+"',author4='"+authors[3]+"',author5='"+authors[4]+"' where paperID='"+getPaperID()+"';";
					pstmt1= (PreparedStatement)conn.prepareStatement(sql);
					System.out.println(sql);
					pstmt1.executeUpdate(sql);
					
					
					
				}
				System.out.println("修改relationtable表成功！");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	  return "ok";
  }
  public String authortablefix(String paperID) {
	 
	  String sql ="select * from paper where paperID='"+paperID+"';";
		Connection conn=ConnectSQL.getConn();
		PreparedStatement pstmt;
		PreparedStatement pstmt1;
		
			try {
				pstmt= (PreparedStatement)conn.prepareStatement(sql);
				System.out.println(sql);
				ResultSet rs = pstmt.executeQuery(sql);
				while(rs.next()) {
					String[] b=rs.getString(4).trim().split(",");
					System.out.println(b.length);
					for(int i=0;i<b.length;i++) {
						collectauthor(b[i]);
					}
					
				}
				System.out.println("修改authortable表成功！");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	  return "ok";
  }
  public void collectauthor(String str) {
		System.out.println("add author "+str);
		
		int len=str.length();
		if(len!=0) {
			String sql="select * from authorlist where authorname='"+str+"'";
			Connection conn = ConnectSQL.getConn();
			PreparedStatement stm1=null;
			PreparedStatement stm2=null;
			try {
				stm1=(PreparedStatement) conn.prepareStatement(sql);
				ResultSet rs= stm1.executeQuery();
				if(!rs.next()) {
					sql="insert into authorlist value('"+str+"');";
				    stm2=(PreparedStatement) conn.prepareStatement(sql);
				    stm2.executeUpdate(sql);
				    stm2.close();
				    stm1.close();
					conn.close();

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return;
		
	}

	public String getPaperID() {
		return paperID;
	}

	public void setPaperID(String paperID) {
		this.paperID = paperID;
	}
}

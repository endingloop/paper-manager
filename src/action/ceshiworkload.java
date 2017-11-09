package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.score;
import service.ConnectSQL;

import model.Paper;
import service.Sequence;
public class ceshiworkload {
	
	public static  List<score> scoreresult;
	public List<score> getScoreresult() {
		return scoreresult;
	}
	public void setScoreresult(List<score> scoreresult) {
		this.scoreresult = scoreresult;
	}
	
	public static String cleartablenew() {
		String sql="DROP table IF EXISTS new;";
		Connection conn=ConnectSQL.getConn();
		PreparedStatement pstmt;
		try {
			
			pstmt= (PreparedStatement)conn.prepareStatement(sql);
		    pstmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "yes";
	}
	public static String workload() {
		cleartablenew();
		
		String sql="create table new as select userID,Name,level,SecondAuthorID from paper,user where date>='2015-5-9' and date<='2019-12-31' and userID=FirstAuthorID;";
		Connection conn=ConnectSQL.getConn();
		PreparedStatement pstmt;
		try {
			
			pstmt= (PreparedStatement)conn.prepareStatement(sql);
		    pstmt.executeUpdate(sql);
			sumscore();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "workload";
	}
	public static List<score>  sumscore() {
		String sql="select userID,Name from user;";
		System.out.println(sql);
		Connection conn=ConnectSQL.getConn();
		PreparedStatement pstmt;
		scoreresult=new ArrayList<>();
		int grade=0;
		try {
			pstmt= (PreparedStatement)conn.prepareStatement(sql);
			ResultSet result = pstmt.executeQuery(sql);
			while(result.next()) {
				score tempbean=new score();
				tempbean.setUserID(result.getString(1));
				tempbean.setName(result.getString(2));
				//int FirstAuthorScore=findFirstAuthor(result.getString(1));
				int SecondAuthorScore=findSecondtAuthor(result.getString(2));
				grade=SecondAuthorScore;
				tempbean.setScore(grade);
				scoreresult.add(tempbean);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 for(score t:scoreresult)
	 {
		 System.out.println(t.userID+" "+t.name+" "+t.score);
	 }
		return scoreresult;
	}
	 public static int findFirstAuthor(String str) {
		 	int num=0;
		 	String sql="select * from new where userID='"+str+"'";
			System.out.println(sql);
			Connection conn=ConnectSQL.getConn();
			PreparedStatement pstmt;
			try {
				pstmt= (PreparedStatement)conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery(sql);
				while(rs.next()) {
					if(rs.getString(4)!=null) {
						num=(int) (num+rs.getInt(3)*0.5);
						
					}else {
						num=num+rs.getInt(3);
					}
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 return num;
	 }
	 
	 public static int findSecondtAuthor(String str) {
		 int num=0;
		 String sql="select * from new where SecondAuthorID like '%"+str+"%';";
			System.out.println(sql);
			Connection conn=ConnectSQL.getConn();
			PreparedStatement pstmt;
			try {
				pstmt= (PreparedStatement)conn.prepareStatement(sql);
				ResultSet rs= pstmt.executeQuery(sql);
				while(rs.next()) {
				String[] b=rs.getString(4).trim().split(",");
				List<String> listA = Arrays.asList(b);
				if(listA.contains(str)) {
					int amount=b.length;
					num=num+(int) (rs.getInt(3)*0.5)/amount;
				}else {
					num=num+0;
				}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		System.out.println(str+"的成绩是："+num);
		 return num;
	 }
	 public static void main(String[] args) {
		 workload();
	 }
}


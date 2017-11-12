package action;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Paper;
import model.score;
import service.Dao;
import service.Sequence;




public class workloadshow {


public String startdate;
public String enddate;


public  List<score> scoreresult;
public List<score> getScoreresult() {
	return scoreresult;
}
public void setScoreresult(List<score> scoreresult) {
	this.scoreresult = scoreresult;
}
public String getStartdate() {
	return startdate;
}
public void setStartdate(String startdate) {
	this.startdate = startdate;
}
public String getEnddate() {
	return enddate;
}
public void setEnddate(String enddate) {
	this.enddate = enddate;
}
public String cleartablenew() {
	String sql="DROP table IF EXISTS new;";
	Connection conn=Dao.getConn();
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
public String workload() {
	cleartablenew();
	System.out.println(getStartdate());
	System.out.println(getEnddate());
	String sql="create table new as select userID,Name,level,SecondAuthorID from paper,user where date>='"+getStartdate()+"' and date<='"+getEnddate()+"' and userID=FirstAuthorID;";
	Connection conn=Dao.getConn();
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
public List<score>  sumscore() {
	String sql="select userID,Name from user;";
	System.out.println(sql);
	Connection conn=Dao.getConn();
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
			int FirstAuthorScore=findFirstAuthor(result.getString(1));
			int SecondAuthorScore=findSecondtAuthor(result.getString(2));
			grade=FirstAuthorScore+SecondAuthorScore;
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
 public int findFirstAuthor(String str) {
	 	int num=0;
	 	String sql="select * from new where userID='"+str+"'";
		System.out.println(sql);
		Connection conn=Dao.getConn();
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
					System.out.println(num);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 return num;
 }
 
 public int findSecondtAuthor(String str) {
	 int num=0;
	 String sql="select * from new where SecondAuthorID like '%"+str+"%';";
		System.out.println(sql);
		Connection conn=Dao.getConn();
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
	
	 return num;
 }
}

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
import model.gradeinfo;
import model.score;
import service.Dao;
import service.Sequence;




public class workloadshow {

public String author;

public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}

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
public List<gradeinfo> list;
public List<gradeinfo> list1;
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
	String sql="create table new as select PaperID, authorname,level,SecondAuthorID from paper,authorlist  where date>='"+getStartdate()+"' and date<='"+getEnddate()+"' and authorname =FirstAuthorID;";
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
public String authorname;
public float scoretemp;
public float getScoretemp() {
	return scoretemp;
}
public void setScoretemp(float scoretemp) {
	this.scoretemp = scoretemp;
}
public String getAuthorname() {
	return authorname;
}
public void setAuthorname(String authorname) {
	this.authorname = authorname;
}
public String showdetail() {
	System.out.println(getAuthorname());
	String str=getAuthorname();
	 list= new ArrayList<>();
	 list=Dao.findFirstAuthor(str);
	 list1 =new ArrayList<>();
	 list1=Dao.findSecondtAuthor(str);
	 list1.addAll(list);
	 for(gradeinfo items:list1) {
		 System.out.println(items.getLevelname()+" "+items.getAuthor()+items.getGotscore()+items.getSecondAuthor());
	 }
	 sumscore();
	return "yes";
}
public List<score>  sumscore() {
	String sql=null;
	if(getAuthor().isEmpty()) {
		 sql="select authorname from authorlist;";
	}else {
		sql="select authorname from authorlist where authorname='"+getAuthor()+"';";
	}
	System.out.println(sql);
	Connection conn=Dao.getConn();
	PreparedStatement pstmt;
	scoreresult=new ArrayList<>();
	float grade=0;
	try {
		pstmt= (PreparedStatement)conn.prepareStatement(sql);
		ResultSet result = pstmt.executeQuery(sql);
		while(result.next()) {
			score tempbean=new score();
			tempbean.setName(result.getString(1));
			float FirstAuthorScore=findFirstAuthor(result.getString(1));
			float SecondAuthorScore=findSecondtAuthor(result.getString(1));
			int Fnumber=findFAuthor(result.getString(1));
			int Snumber=findSAuthor(result.getString(1));
			tempbean.setFauthornum(Fnumber);
			tempbean.setSauthornum(Snumber);
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
	 System.out.println(t.name+" "+t.score);
 }
 	
	return scoreresult;
}
public String workloaddetail(String str) {
	String sql="SELECT * FROM  paper  WHERE FirstAuthorID='" + str + "' " + "OR SecondAuthorID REGEXP '[[:<:]]" + str + "[[:>:]]'"; 
	Connection conn=Dao.getConn();
	PreparedStatement pstmt;
	try {
		pstmt= (PreparedStatement)conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return "emmm";
}

public int findFAuthor(String str) {
 	int num=0;
 	String sql="select count(*) from new where authorname='"+str+"'";
	System.out.println(sql);
	Connection conn=Dao.getConn();
	PreparedStatement pstmt;
	try {
		pstmt= (PreparedStatement)conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(sql);
		while(rs.next()) {
			num=rs.getInt(1);
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(num+"---------firstauthornum");
 return num;
}

public int findSAuthor(String str) {
int num=0;
 String sql="select count(*) from new where SecondAuthorID REGEXP '[[:<:]]" + str + "[[:>:]]'";
 System.out.println(sql);
	Connection conn=Dao.getConn();
	PreparedStatement pstmt;
	try {
		pstmt= (PreparedStatement)conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(sql);
		while(rs.next()) {
			num=rs.getInt(1);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(num+"---------secondauthornum");
return num;
}
public float findFirstAuthor(String str) {
 	float num=0;
 	String sql="select * from new where authorname='"+str+"'";
	System.out.println(sql);
	Connection conn=Dao.getConn();
	PreparedStatement pstmt;
	try {
		pstmt= (PreparedStatement)conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(sql);
		while(rs.next()) {
			String[] b=rs.getString(4).trim().split(",");
			List<String> listA = Arrays.asList(b);
			String tempstrr=listA.toString();
			
			if(tempstrr.length()<=2) {
				
				num=num+rs.getFloat(3);
			}else {
				
				num=num+(int)(rs.getFloat(3)*0.5);
				System.out.println("--------有第二合作者"+tempstrr);
			}
				System.out.println(num);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
 return num;
}

public float findSecondtAuthor(String str) {
 float num=0;
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
			num=num+(float) (rs.getFloat(3)*0.5)/amount;
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

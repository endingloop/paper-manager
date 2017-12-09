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
import service.ExcelGenerate;
import service.Sequence;
import support.PaperSupport;
import support.UserSupport;




public class workloadshow extends UserSupport {

/**
	 * 
	 */
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
	 * 
	 */

public String author;

public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}

public String startdate;
public String enddate;
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
//清空new数据存储表
public String cleartablenew() {
	String sql="DROP table IF EXISTS new;";
	Connection conn=Dao.getConn();
	PreparedStatement pstmt;
	try {
		
		pstmt= (PreparedStatement)conn.prepareStatement(sql);
	    pstmt.executeUpdate(sql);
	    pstmt.close();
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "yes";
}
public String workload() {
	if(getStartdate()!=null&&getEnddate()!=null) {
		cleartablenew();
		String sql="create table new as select PaperID, FirstAuthorID,level,SecondAuthorID from paper where date>='"+getStartdate()+"' and date<='"+getEnddate()+"' and Status=1;";
		List<score> temp=null;
		Connection conn=Dao.getConn();
		PreparedStatement pstmt;
		try {
			pstmt= (PreparedStatement)conn.prepareStatement(sql);
			System.out.println(sql);
		    pstmt.executeUpdate(sql);
		    temp=sumscore();//计算分数
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		showdetail(getAuthor());
	}
	
	return "workload";
}
//查询个人工作量明细
public String showdetail(String str) {
	
	 list= new ArrayList<>();
	 list=Dao.findFirstAuthor(str);
	 list1 =new ArrayList<>();
	 list1=Dao.findSecondtAuthor(str);
	 list1.addAll(list);
	 System.out.println(list1.size());
	 sumscore();
     ExcelGenerate.PersonalWorkloadQuery(list1,getAuthorname(),getStartdate(),getEnddate(),getUser().getEmail());

	return "yes";
}
//计算总分得出总表
public  List<score>  sumscore() {
	String sql=null;
	
	
		
		scoreresult=new ArrayList<>();
		
		float grade=0;
		
				score tempbean=new score();
				tempbean.setName(getAuthor());
				float FirstAuthorScore=findFirstAuthor(getAuthor());
				float SecondAuthorScore=findSecondtAuthor(getAuthor());
				int Fnumber=findFAuthor(getAuthor());
				int Snumber=findSAuthor(getAuthor());
				tempbean.setFauthornum(Fnumber);
				tempbean.setSauthornum(Snumber);
				grade=FirstAuthorScore+SecondAuthorScore;//第一作者应该加的分数+第二作者应该加的分数
				setScoretemp(grade);
				tempbean.setScore(grade);
				scoreresult.add(tempbean);
				ExcelGenerate.TaskQueryExcel(scoreresult,getStartdate(),getEnddate(),getUser().getEmail());
					
	
			 return scoreresult;
}


//以第一作者身份发布论文个数
public int findFAuthor(String str) {
 	int num=0;
 	String sql="select count(*) from new where FirstAuthorID='"+str+"'";
	Connection conn=Dao.getConn();
	PreparedStatement pstmt;
	try {
		pstmt= (PreparedStatement)conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(sql);
		while(rs.next()) {
			num=rs.getInt(1);
		}
		pstmt.close();
		conn.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
 return num;
}
//以第二作者身份发布论文个数
public int findSAuthor(String str) {
int num=0;
 String sql="select count(*) from new where SecondAuthorID REGEXP '[[:<:]]" + str + "[[:>:]]'";
	Connection conn=Dao.getConn();
	System.out.println(sql);
	PreparedStatement pstmt;
	try {
		pstmt= (PreparedStatement)conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(sql);
		while(rs.next()) {
			num=rs.getInt(1);
		}
		pstmt.close();
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
return num;
}
//以第一作者身份发布论文获得的分数1
public float findFirstAuthor(String str) {
 	float num=0;
 	String sql="select * from new where FirstAuthorID='"+str+"'";
	Connection conn=Dao.getConn();
	PreparedStatement pstmt;
	try {
		pstmt= (PreparedStatement)conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(sql);
		String[] b=null;
		while(rs.next()) {
			if(rs.getString(4)!=null)
			b=rs.getString(4).trim().split(",");
			
			List<String> listA = Arrays.asList(b);
			String tempstrr=listA.toString();
			
			if(tempstrr.length()<=2) {
				
				num=num+rs.getFloat(3);
			}else {
				
				num=num+(int)(rs.getFloat(3)*0.5);
				
			}	
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
 return num;
}
//以第二作者身份发布论文所得分数2
public float findSecondtAuthor(String str) {
 float num=0;
 String sql="select * from new where SecondAuthorID like '%"+str+"%';";
	Connection conn=Dao.getConn();
	PreparedStatement pstmt;
	try {
		pstmt= (PreparedStatement)conn.prepareStatement(sql);
		ResultSet rs= pstmt.executeQuery(sql);
		while(rs.next()) {
			String[] b=null;
			if(rs.getString(4)!=null)
				b=rs.getString(4).trim().split(",");
		List<String> listA = Arrays.asList(b);
		if(listA.contains(str)) {
			int amount=b.length;
			num=num+(float) (rs.getFloat(3)*0.5)/amount;
		}else {
			num=num+0;
		}
		}
		pstmt.close();
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

 return num;
}
}

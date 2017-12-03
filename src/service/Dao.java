package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import action.SearchPaper;
import model.Paper;
import model.User;
import model.gradeinfo;
import support.UserSupport;

public class Dao {

public static List<gradeinfo> inforesult;
	public List<gradeinfo> getInforesult() {
	return inforesult;
}

public void setInforesult(List<gradeinfo> inforesult) {
	this.inforesult = inforesult;
}


	
	static private Logger logger = Logger.getLogger(Dao.class);

	public static Connection getConn() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/paper-manager";
		String username = "root";
		String password = "womende666"; // 不要改动此处！！修改你自己的密码
		Connection conn = null;
		try {
			Class.forName(driver); // classLoader,加载对应驱动
			conn = (Connection) DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static User findUser(String username) throws SQLException {
		User user = null;
		String password = null;
		String result = null;
		List<Paper> papers = new ArrayList<>();
		Connection conn = Dao.getConn();
		String sql = "select password, papers from user where username = '" + username + "'";
		PreparedStatement pstmt;
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			password = rs.getString(1);
			result = rs.getString(2);
			logger.info("find user "+username);
			if (result != null  && !result.isEmpty()) {
				for (String s : result.split(",")) {
					papers.add(findPaper(s));
				}
			}
			user = new User(username, password, papers);
		}
		return user;
	}
	
	public static void inputUser(User user) throws SQLException {
		Connection conn = Dao.getConn();
		String sql = "replace into user values(?,?,?)";
		PreparedStatement pstmt;
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getPaperIdList());
		pstmt.executeUpdate();

		logger.info("register successful");

		pstmt.close();
		conn.close();
	}

	public static Paper findPaper(String paperID) throws SQLException {
		Connection conn = Dao.getConn();
		PreparedStatement pstmt;
		String sql = "SELECT * FROM paper WHERE PaperID= '" + paperID + "'";
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		Paper temp = null;
		if (rs.next()) {
			temp = new Paper();
			temp.setPaperID(rs.getString(1));
			temp.setTitle(rs.getString(2));
			temp.setAuthor(rs.getString(3));
			temp.setSecondAuthor(rs.getString(4));
			temp.setDate(rs.getString(5));
			temp.setSort(rs.getInt(6));
			temp.setPublication(rs.getString(7));
			temp.setStatus(rs.getInt(8));
			temp.setKeyword(rs.getString(9));
			temp.setDescription(rs.getString(10));
			temp.setFilename(rs.getString(11));
			temp.setLevel(rs.getInt(12));
		}

		logger.info("find papr by paperid successful --Dao");

		return temp;
	}

	public static int insertPaper(Paper paper) throws SQLException {
		Connection conn = getConn();
		String sql = "REPLACE INTO paper VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		pstmt.setString(1, paper.getPaperID());
		pstmt.setString(2, paper.getTitle());
		pstmt.setString(3, paper.getAuthor());
		pstmt.setString(4, paper.getSecondAuthor());
		pstmt.setString(5, paper.getDate());
		pstmt.setLong(6, paper.getSort());
		pstmt.setString(7, paper.getPublication());
		pstmt.setInt(8, paper.getStatus());
		pstmt.setString(9, paper.getKeyword());
		pstmt.setString(10, paper.getDescription());
		pstmt.setString(11, paper.getFilename());
		pstmt.setInt(12, paper.getLevel());
		int result = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		collectauthor(paper.getAuthor());
		String[] b=paper.getSecondAuthor().trim().split(",");
		List<String> listA = Arrays.asList(b);
		for(String item:listA) {
			collectauthor(item);
		}
		return result;
	}
	
	public static int removePaper(Paper paper) throws SQLException {
		Connection conn = getConn();
		String sql = "DELETE FROM paper WHERE PaperID = " + paper.getPaperID();
		PreparedStatement pstmt;
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		int result = pstmt.executeUpdate();

		logger.info("remove paper successfully！");

		pstmt.close();
		conn.close();
		return result;
	}

	public static int findSortID(String sortstr) throws SQLException {
		String sql = "select * from third where sortname='" + sortstr + "'";
		Connection conn = Dao.getConn();
		PreparedStatement pstmt;
		int result = -1;
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(sql);
		while (rs.next()) {
			result = rs.getInt(1);
		}
		pstmt.close();
		conn.close();
		return result;
	}
	//获取作者表
	public static void collectauthor(String str) {
		System.out.println("add author "+str);
		
		int len=str.length();
		if(len!=0) {
			String sql="replace into authorlist values('"+str+"');";
			Connection conn = Dao.getConn();
			PreparedStatement stm=null;
			
			try {
				stm=(PreparedStatement) conn.prepareStatement(sql);
				ResultSet rs= stm.executeQuery();
				stm.close();
				conn.close();
				System.out.println("add second author"+str);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return;
		
	}
	//获取类型
	public static String findsortname(int num) throws SQLException {
		String sql = "select sortname from third where thirdID=" + num+";";
		String str=null;
		Connection conn = Dao.getConn();
		PreparedStatement pstmt;
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(sql);
		while(rs.next()) {
			 str=rs.getString(1);
		}
		
		pstmt.close();
		conn.close();
		return str;
	}
	//获取论文等级名字
	public static String matchlevel(int num) {
		String str=null;
		switch(num) {
		case 60: 
			str="SCI";
			break;
		case 45:
			str="EI，CSSCI,SSCI,一级刊物";
			break;
		case 30:
			str="核心期刊(国际会议)";
			break;
		case 15:
			str="公开发表";
			break;
		case 10:
			str="普通论文";
			break;
		}
		
		return str;
	}
	//计算第一作者应得的分数
	public static List<gradeinfo> findFirstAuthor(String str) {
	 	
	 	String sql="select * from paper,new where paper.FirstAuthorID='"+str+"' and new.PaperID=paper.PaperID";
		System.out.println(sql);
		Connection conn=Dao.getConn();
		PreparedStatement pstmt;
		inforesult = new ArrayList<>();
		try {
			pstmt= (PreparedStatement)conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				float num=0;
				String[] b=rs.getString(4).trim().split(",");
				List<String> listA = Arrays.asList(b);
				String tempstrr=listA.toString();
				
				if(tempstrr.length()<=2) {
					
					num=num+rs.getFloat(12);//只有一个作者
				}else {
					
					num=num+(int)(rs.getFloat(12)*0.5);//有合作者
				}
				gradeinfo  grainfobean=new gradeinfo();
				grainfobean.setAuthor(rs.getString(3));
				grainfobean.setTitle(rs.getString(2));
				grainfobean.setPaperID(rs.getString(1));
				grainfobean.setLevel(rs.getInt(12));
				grainfobean.setDate(rs.getString(5));
				grainfobean.setSecondAuthor(rs.getString(4));
				grainfobean.setSort(rs.getInt(6));
				grainfobean.setLevelname(matchlevel(rs.getInt(12)));
				grainfobean.setSortname(findsortname(rs.getInt(6)));
				grainfobean.setGotscore(num);
				inforesult.add(grainfobean);
			}
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 return inforesult;
	}
//计算作为第二作者获得的分数;
	public static List<gradeinfo> findSecondtAuthor(String str) {
		inforesult = new ArrayList<>();
	 String sql="select * from paper,new where paper.SecondAuthorID like '%"+str+"%' AND new.PaperID=paper.PaperID;";
		System.out.println(sql);
		Connection conn=Dao.getConn();
		PreparedStatement pstmt;
		try {
			pstmt= (PreparedStatement)conn.prepareStatement(sql);
			ResultSet rs= pstmt.executeQuery(sql);
			while(rs.next()) {
			String[] b=rs.getString(4).trim().split(",");
			List<String> listA = Arrays.asList(b);
			float num=0;
			if(listA.contains(str)) {
				int amount=b.length;
				num=num+(float) (rs.getFloat(12)*0.5)/amount;
				gradeinfo  grainfobean=new gradeinfo();
				grainfobean.setAuthor(rs.getString(3));
				grainfobean.setTitle(rs.getString(2));
				grainfobean.setPaperID(rs.getString(1));
				grainfobean.setLevel(rs.getInt(12));
				grainfobean.setDate(rs.getString(5));
				grainfobean.setSecondAuthor(rs.getString(4));
				grainfobean.setSort(rs.getInt(6));
				grainfobean.setLevelname(matchlevel(rs.getInt(12)));
				grainfobean.setSortname(findsortname(rs.getInt(6)));
				grainfobean.setGotscore(num);
				inforesult.add(grainfobean);
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

	 return  inforesult;
	}
}

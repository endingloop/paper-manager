package action;

import java.io.*;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Paper;
import service.ConnectSQL;
import service.Sequence;
import support.UserSupport;

public class changshidongtai extends UserSupport {
	public int first;
	public String second;
	public String third;
	public String dates;
	boolean isOriginAuthor;
	public String Hidden1;


	public String keyword1;
	public  String keyword2;
	public  String keyword3;
	

	public String level;
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}


	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}

	public String getThird() {
		return third;
	}


	    public void setThird(String third) {
	        this.third = third;
	    }


	/**
         * @return the keyword1
         */
        public String getKeyword1() {
            return keyword1;
        }

        /**
         * @param keyword1 the keyword1 to set
         */
        public void setKeyword1(String keyword1) {
            this.keyword1 = keyword1;
        }

        /**
         * @return the keyword2
         */
        public String getKeyword2() {
            return keyword2;
        }

        /**
         * @param keyword2 the keyword2 to set
         */
        public void setKeyword2(String keyword2) {
            this.keyword2 = keyword2;
        }

        /**
         * @return the keyword3
         */
        public String getKeyword3() {
            return keyword3;
        }

        /**
         * @param keyword3 the keyword3 to set
         */
        public void setKeyword3(String keyword3) {
            this.keyword3 = keyword3;
        }

        
    /**
	 * 初始化版本 增加了文件上传功能
	 * 优化代码结构
	 */
	private static final long serialVersionUID = 122L;
	private String destPath;
	private Paper paperBean;

	// 注意，file并不是指前端jsp上传过来的文件本身，而是文件上传过来存放在临时文件夹下面的文件
	private File file;

	// 提交过来的file的名字
	private String fileFileName;

	// 提交过来的file的MIME类型
	private String fileContentType;

	@Override
	public String execute() throws Exception {
		
		/* Copy file to a safe location */
	    System.out.println("Here!!---------------" + getHidden1());
	  
		destPath = ServletActionContext.getServletContext().getRealPath("/upload");
		paperBean.setPaperID(Sequence.nextId());
		StringBuffer sb1 = new StringBuffer();
		sb1.append(keyword1);
		sb1.append(",");
		sb1.append(keyword2);
		sb1.append(",");
		sb1.append(keyword3);
		paperBean.setKeyword(sb1.toString());
		paperBean.setSecondauthor(getHidden1());
		try {
			System.out.println("Src File : " + file);
			System.out.println("Dst File : " + destPath + "/" + paperBean.getPaperID());

			File destFile = new File(destPath, paperBean.getPaperID());
			FileUtils.copyFile(file, destFile);

		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
		System.out.println(paperBean);
		insert(paperBean);
		String[] author= {"","","","",""};
		String[] str=getHidden1().trim().split(",");
		for(int i=0;i<str.length;i++) {
			author[i]=str[i];
			collectauthor(str[i]);
		}
		PreparedStatement pstmt1;
		Connection conn=ConnectSQL.getConn();
		String sql="insert into relationtable value('"+paperBean.getPaperID()+"','"+paperBean.getAuthor()+"','"+author[0]+"','"+author[1]+"','"+author[2]+"','"+author[3]+"','"+author[4]+"');";
		System.out.println(sql);
		try {
			pstmt1 = (PreparedStatement) conn.prepareStatement(sql);
			pstmt1.executeUpdate();
			pstmt1.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		adduser(getUser().getUsername(),getUser().getPassword(),paperBean.getPaperID());
		return SUCCESS;
	}
	public String getHidden1() {
		return Hidden1;
	}

	public void setHidden1(String Hidden1) {
		this.Hidden1 = Hidden1;
	}

	public String adduser(String username,String password,String paperID) {
		String sql ="select * from user where username='"+username+"' and password='"+password+"';";
		Connection conn=ConnectSQL.getConn();
		PreparedStatement pstmt;
		PreparedStatement pstmt2;
		try {
			pstmt= (PreparedStatement)conn.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			String temp="";
			while(rs.next()) {
				temp=rs.getString(3);
				temp=temp+paperID+",";
			}
			sql="update user set papers='"+temp+"' where username='"+username+"' and password='"+password+"';";
			System.out.println(sql);
			pstmt2= (PreparedStatement)conn.prepareStatement(sql);
			pstmt2.executeUpdate(sql);
			System.out.println("success link to user!");
			pstmt2.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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
	private int insert(Paper paper) {
		Connection conn = ConnectSQL.getConn();
		int i = 0;
		int num=findSortID(getThird());
		

		String sql = isOriginAuthor() ? "insert into paper (PaperID,FirstAuthorID,SecondAuthorID,Title,Keywords,Date,JournalID,SortID,FILE,level,Status) values(?,?,?,?,?,?,?,?,?,?,1)"
				:"insert into paper (PaperID,FirstAuthorID,SecondAuthorID,Title,Keywords,Date,JournalID,SortID,FILE,level) values(?,?,?,?,?,?,?,?,?,?)";
		collectauthor(paper.getAuthor());
		PreparedStatement pstmt;
		
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, paper.getPaperID());
			pstmt.setString(2, paper.getAuthor());
			pstmt.setString(3, paper.getSecondauthor());
			pstmt.setString(4, paper.getTitle());
			pstmt.setString(5, paper.getKeyword());
			pstmt.setString(6, getDates());
			pstmt.setString(7, paper.getPublication());
			pstmt.setLong(8,num);
			pstmt.setString(9, fileFileName);
			pstmt.setString(10, getLevel());
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
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

	public Paper getPaperBean() {
		return paperBean;
	}

	public void setPaperBean(Paper paperBean) {
		this.paperBean = paperBean;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public boolean isOriginAuthor() {
		return isOriginAuthor;
	}

	public void setOriginAuthor(boolean isOriginAuthor) {
		this.isOriginAuthor = isOriginAuthor;
	}
}

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

public class AddPaper extends ActionSupport {
	public int first;
	public String second;
	public String third;
	public String dates;
	public String keyword1;
	public  String keyword2;
	public  String keyword3;
	public String author1;
	public String author2;
	public String author3;
	public String author4;
	public String author5;
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
	    public void keyword1(String keyword1) {
	        this.keyword1 = keyword1;
	    }
	       public String keyword1() {
	            return keyword1;
	        }
	       public void keyword2(String keyword2) {
	           this.keyword2 = keyword2;
	       }
	          public String keyword2() {
	               return keyword2;
	           }
	          public void keyword3(String keyword3) {
	              this.keyword3 = keyword3;
	          }
	             public String keyword3() {
	                  return keyword3;
	              }
	             public void author1(String author1) {
	                  this.author1 = author1;
	              }
	                 public String author1() {
	                      return author1;
	                  }
	                 public void author2(String author2) {
	                      this.author2 = author2;
	                  }
	                     public String author2() {
	                          return author2;
	                      }
	                     public void author3(String author3) {
	                         this.author3 = author3;
	                     }
	                        public String author3() {
	                             return author3;
	                         }
	                        public void author4(String author4) {
	                            this.author4 = author4;
	                        }
	                           public String author4() {
	                                return author4;
	                            }
	                           public void author5(String author5) {
	                               this.author5 = author5;
	                           }
	                              public String author5() {
	                                   return author5;
	                               }
	/**
	 * 初始化版本 增加了文件上传功能
	 * 优化代码结构
	 */
	private static final long serialVersionUID = 1322L;
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
	    System.out.println("Here!!");
		destPath = ServletActionContext.getServletContext().getRealPath("/upload");
		paperBean.setPaperID(Sequence.nextId());
		StringBuffer sb1 = new StringBuffer();
		sb1.append(keyword1);
		sb1.append(",");
		sb1.append(keyword2);
		sb1.append(",");
		sb1.append(keyword3);
		paperBean.setKeyword(sb1.toString());
	      StringBuffer sb2 = new StringBuffer();
	      System.out.println(author1);
	      System.out.println(author2);
	      System.out.println(author3);
	      System.out.println(author4);
	      System.out.println(author5);
	        sb2.append(author1);
	        sb2.append(",");
	        sb2.append(author2);
	        sb2.append(",");
	        sb2.append(author3);
	        sb2.append(",");
	        sb2.append(author4);
	        sb2.append(",");
	        sb2.append(author5);
	        System.out.println(sb2.toString());
		paperBean.setSecondauthor(sb2.toString());
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
		return SUCCESS;
	}
	private int findSortID(String sortstr) {
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
		System.out.println(getFirst());
		System.out.println(getSecond());
		System.out.println(getThird());
		System.out.println(getDates());
		int num=findSortID(getThird());
		
		String sql = "insert into paper (PaperID,FirstAuthorID,SecondAuthorID,Title,Keywords,Date,JournalID,SortID,FILE) values(?,?,?,?,?,?,?,?,?)";
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
			
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
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
}

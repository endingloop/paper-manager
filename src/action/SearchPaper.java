package action;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import model.Paper;
import service.Dao;
import service.ExcelGenerate;
import support.Constants;
import support.UserSupport;


public class SearchPaper extends UserSupport {
	
	private static final long serialVersionUID = 2323L;
	static private Logger logger = Logger.getLogger(SearchPaper.class);
	private int selectchoice;
	private String keyword;
	private List<Paper> result;
	private int papernum;
	
	HttpSession session = ServletActionContext.getRequest ().getSession();
    

    public String execute() {
        return SUCCESS;
    }


    private int querySql(String sql) throws SQLException {
        Connection conn = Dao.getConn();
        result = new ArrayList<>();
        PreparedStatement pstmt;
        pstmt = (PreparedStatement) conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        int count = 0;

		while (rs.next()) {
			Paper temp = new Paper();
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
			result.add(temp);
			count++;
		}
			
			try {
				ExcelGenerate.GeneralQueryExcel(result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		return count;
	}
	public  static int querySqlS(String sql) throws SQLException {
		Connection conn = Dao.getConn();
		
		PreparedStatement pstmt;
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		int count = 0;
		while (rs.next()) {
			count++;
		}
	
		return count;
	}
	public List<Paper> querySqlsbychangfan(int page) throws SQLException {
		Connection conn = Dao.getConn();
		 String sql="select * from paper  order by paperID desc limit ?,?";
		ArrayList results = new ArrayList<>();
		PreparedStatement pstmt;
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		pstmt.setInt(1, (page-1)*3);
		pstmt.setInt(2, 3);
		ResultSet rs = pstmt.executeQuery();
		int count = 0;
		while (rs.next()) {
			Paper temp = new Paper();
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
			results.add(temp);
			count++;
		}	
		return results;
	}
    
    public String showDetail()
    {
        String sql = null;
        sql = "SELECT * FROM paper WHERE Title='" + keyword + "'";
        try {
            papernum = querySql(sql);
            logger.info(sql + " NUMBER: " + papernum);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }
    
    public String findsortIDbysortname(int level) throws SQLException
    {   
        Connection conn = Dao.getConn();
        PreparedStatement pstmt;
        String sql=null;
        String sortID=null;
        if(level==1)
        {
            sql="SELECT * FROM first WHERE sortname='" + keyword + "'";
        }
        else if(level==2)
        {
            sql="SELECT * FROM second WHERE sortname='" + keyword + "'";
        }
        pstmt = (PreparedStatement) conn.prepareStatement(sql);
        ResultSet rs ;
        try {
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return ERROR;
        }
        while (rs.next()) {
            sortID=rs.getString(1);
        }
        return sortID;
    }
    
    //由第一层分类名称查第二分类由第二层分类名称查第三类分类
	public String querySort() throws SQLException
	{
            if(selectchoice==2)
            {
                selectchoice=6;
                chooseSearch();
                return SUCCESS;
            }
            List<String> list1;
            list1=new ArrayList<>();
            Connection conn = Dao.getConn();
            PreparedStatement pstmt;
            String sql=null;
            String sortid;
            logger.info(selectchoice);
            logger.info(keyword);
            if(selectchoice==0)//由一级分类进行查询
            {
                 sortid=findsortIDbysortname(1);
                 sql="SELECT * FROM second WHERE upper='" + sortid + "'";
                 session.setAttribute("searchLevel",1);
            }
            if(selectchoice==1)
            {
                sortid=findsortIDbysortname(2);
                sql="SELECT * FROM third WHERE upper='" + sortid + "'";
                session.setAttribute("searchLevel",2);
            }
            
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs ;
            try {
                rs = pstmt.executeQuery();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return ERROR;
            }
            while (rs.next()) {
                list1.add(rs.getString(2));
            }
            session.setAttribute("sortlist",list1);
            
            selectchoice=6;
            chooseSearch();
            return SUCCESS;           
	}

    

	
	public String chooseSearch() {
		String sql = null;
		switch (selectchoice) {
		case 1:
			sql = "SELECT * FROM paper WHERE KeyWords LIKE '%" + keyword + "%'";
			break;
		case 2:
			sql = "SELECT * FROM paper WHERE Title LIKE '%" + keyword + "%'";
			break;
		case 3:
			sql = "SELECT * FROM paper WHERE FirstAuthorID='" + keyword + "'";
			break;
		case 4:
			sql = "SELECT * FROM paper WHERE Date ='" + keyword + "'";
			break;
		case 5:
			sql = "SELECT * FROM paper WHERE JournalID='" + keyword + "'";
			break;
		case 6:
			try {
				int id = Dao.findSortID(keyword);
				switch(Dao.findSortLevel(keyword)) {
				case 1:
					sql = "select * from paper,third,second where second.upper="+ id +" and paper.sortID=third.thirdID and third.upper=second.secondID;";
					break;
				case 2:
					sql = "select * from paper,third where third.upper="+ id +" and paper.sortID=third.thirdID";
					break;
				case 3:
					sql = "select * from paper where sortID="+ id ;
					break;
				default:
					logger.error("No this sort: " + keyword);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		}
		try {
			if (sql == null) {
				result = new ArrayList<>();
			} else {
				papernum = querySql(sql);
			}
			logger.info(sql + " NUMBER: " + papernum);
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;

	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getSelectchoice() {
		return selectchoice;
	}

	public void setSelectchoice(int selectchoice) {
		this.selectchoice = selectchoice;
	}

	public List<Paper> getResult() {
		return result;
	}

	public void setResult(List<Paper> result) {
		this.result = result;
	}

	public int getPapernum() {
		return papernum;
	}

	public void setPapernum(int papernum) {
		this.papernum = papernum;
	}

}

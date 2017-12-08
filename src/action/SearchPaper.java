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

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.Paper;
import service.Dao;
import service.ExcelGenerate;
import support.Constants;
import support.UserSupport;


public class SearchPaper extends UserSupport {
	
	private static final long serialVersionUID = 223L;
	static private Logger logger = Logger.getLogger(SearchPaper.class);
	private int selectchoice;
	private String keyword;
	private List<Paper> result;
	private int papernum;
	private int page=1;  
	  
    public int getPage() {  
        return page;  
    }  
  
    public void setPage(int page) {  
        this.page = page;  
    }  
  
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
			if (temp.getStatus() == 1) {
				result.add(temp);
				count++;
			}
		}
			
			try {
				ExcelGenerate.GeneralQueryExcel(result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		return count;
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
            logger.info(page);
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
            if(sql!=null)
            {
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
            }
            
            session.setAttribute("sortlist",list1);
            
            selectchoice=6;
            chooseSearch();
            return SUCCESS;           
	}

    

	

	
	public String chooseSearch() {
		String sql = null;
		int index=0;
		logger.info(selectchoice);
        logger.info(keyword);
        logger.info(page);
		switch (selectchoice) {
		case 1:
			sql = "SELECT * FROM paper,upload  WHERE KeyWords LIKE '%" + keyword + "%' and upload.paperID=paper.PaperID";
			break;
		case 2:
			sql = "SELECT * FROM paper ,upload WHERE Title LIKE '%" + keyword + "%' and upload.paperID=paper.PaperID";
			break;
		case 3:
			sql = "SELECT * FROM paper,upload WHERE FirstAuthorID='" + keyword + "' and upload.paperID=paper.PaperID";
			break;
		case 4:
			sql = "SELECT * FROM paper,upload WHERE Date ='" + keyword + "' and upload.paperID=paper.PaperID";
			break;
		case 5:
			sql = "SELECT * FROM paper,upload WHERE JournalID='" + keyword + "' and upload.paperID=paper.PaperID";
			break;
		case 6:
			try {
				index=1;
				System.out.println(keyword);
				int id = Dao.findSortID(keyword);
				switch(Dao.findSortLevel(keyword)) {
				case 1:
					sql = "select * from paper,third,second ,upload where second.upper="+ id +" and paper.sortID=third.thirdID and third.upper=second.secondID  and upload.paperID=paper.PaperID";
					break;
				case 2:
					sql = "select * from paper,third ,upload where third.upper="+ id +" and paper.sortID=third.thirdID  and upload.paperID=paper.PaperID";
					break;
				case 3:
					sql = "select * from paper ,upload where sortID="+ id +"  and upload.paperID=paper.PaperID";
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
			logger.info(sql + " NUMBER: " + papernum+"sql fenlong-----------------");
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
		logger.info(sql);
		Padding(sql,getPage(),index);
		return SUCCESS;

	}
	
	
	public String Padding(String sql,int page,int index) {
		int current_page=getPage();
		int pages=0;
		try {
			pages = querySql(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
        HttpSession session = ServletActionContext.getRequest ().getSession();
        ActionContext context=ActionContext.getContext();  
        sql=sql+" and paper.Status=1 order by upload.uploadDate desc limit "+(page-1)*10+",10"; 
		System.out.println(sql);
		List<Paper> list=new ArrayList<>();
		try {
			list= Dao.PadingResult(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
         StringBuffer s=new StringBuffer();  
        for(int i=1;i<=Math.ceil((double)pages/10);i++){  
            if(i==current_page){  
                s.append("["+i+"]");  
            }  
            else{ 
            	if(index==0) {
            		 s.append("<a href='chooseSearch.action?page="+i+"&&keyword="+keyword+"&&selectchoice="+selectchoice+"'>"+i+"</a>");  
            	}else {
            		  s.append("<a href='querySort.action?page="+i+"&&keyword="+keyword+"&&selectchoice="+selectchoice+"'>"+i+"</a>");  
            	}
                
     
                		 
            }  
        }  		
        System.out.println(s);
        session.setAttribute("list",list); 
        session.setAttribute("s",s); 
        context.put("list", list);  
        context.put("s",s);  
  
		return null;
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

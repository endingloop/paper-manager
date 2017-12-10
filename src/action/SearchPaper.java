package action;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import model.Paper;
import service.Dao;
import service.ExcelGenerate;
import service.WorkGraph;
import support.UserSupport;


public class SearchPaper extends UserSupport {
	
	private static final long serialVersionUID = 123L;
	static private Logger logger = Logger.getLogger(SearchPaper.class);
	
	private int selectchoice;
	private int seqencechoice ;
	private String keyword;
	public int sorttype;
	private List<Paper> result;
	private int papernum;
	private int page=1;  
	  
    HttpSession session = ServletActionContext.getRequest ().getSession();
    

    public String execute() {
        return SUCCESS;
    }

    public String showDetail()
    {
        String sql = null;
        if(selectchoice==0)
        {
         sql = "SELECT * FROM paper WHERE PaperID='" + keyword + "'";   
        }
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
    
    public String searchAuthor() throws SQLException {
	    setSelectchoice(3);
	    String result = chooseSearch();
	    Map<String, Integer> m1 = WorkGraph.findAuthors(keyword);
		Iterator<Entry<String, Integer>> iter = m1.entrySet().iterator();
		String [] author = new String[(m1.size())];
		int [] count = new int[m1.size()];
		int i = 0;
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			author[i] = (String) entry.getKey();
			count[i] = (int) entry.getValue();
			i++;
		}
	    session.setAttribute("author", author);
	    session.setAttribute("count", count);
	    session.setAttribute("authorname", keyword);
	    session.setAttribute("papernum", getPapernum());
		return result;
	}
    
    //由第一层分类名称查第二分类由第二层分类名称查第三类分类
	public String querySort() throws SQLException {
		// selectchoice 为分类级别减1
		if (selectchoice == 2) {
			session.setAttribute("level3", "/" + keyword);
			session.setAttribute("searchLevel", 3);
		}
		List<String> list1;
		list1 = new ArrayList<>();
		Connection conn = Dao.getConn();
		PreparedStatement pstmt;
		String sql = null;
		int sortid = Dao.findSortID(keyword);
		if (selectchoice == 0)// 由一级分类进行查询
		{
			session.setAttribute("level2", null);
			session.setAttribute("level3", null);
			sql = "SELECT * FROM second WHERE upper=" + sortid;
			session.setAttribute("searchLevel", 1);
			session.setAttribute("level1", keyword);
		}
		if (selectchoice == 1) {
			session.setAttribute("level3", null);
			sql = "SELECT * FROM third WHERE upper=" + sortid;
			session.setAttribute("searchLevel", 2);
			session.setAttribute("level2", "/" + keyword);
		}
		if (sql != null) {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs;
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list1.add(rs.getString(2));
			}
		}

		session.setAttribute("sortlist", list1);

		return chooseSearchsort(selectchoice, sortid);
	}

	public String chooseSearch() throws SQLException {
		String sql = null;
		int index=0;
		switch (selectchoice) {
		case 1:
			sql = "SELECT * FROM paper,upload  WHERE KeyWords LIKE '%" + keyword + "%' and upload.paperID=paper.PaperID";
			break;
		case 2:
			sql = "SELECT * FROM paper ,upload WHERE Title LIKE '%" + keyword + "%' and upload.paperID=paper.PaperID";
			break;
		case 3:
		    sql = "SELECT * FROM paper,upload WHERE (FirstAuthorID='" + keyword + "' " + "OR SecondAuthorID REGEXP '[[:<:]]" + keyword + "[[:>:]]') and upload.paperID=paper.PaperID";
		    logger.info(sql);
			break;
		case 4:
			sql = "SELECT * FROM paper,upload WHERE Date ='" + keyword + "' and upload.paperID=paper.PaperID";
			break;
		case 5:
			sql = "SELECT * FROM paper,upload WHERE JournalID='" + keyword + "' and upload.paperID=paper.PaperID";
			break;
		case 6:
			index=1;
			int level = Dao.findSortLevel(keyword);
			int sortid = Dao.findSortID(keyword);
			return chooseSearchsort(level, sortid);
		}
		
		if (sql == null) {
			result = new ArrayList<>();
		} else {
			papernum = querySql(sql);
		}
		logger.info(sql + " NUMBER: " + papernum);
		Padding(sql,getPage(),index);
		return SUCCESS;
	}

	public String chooseSearchsort(int level, int sortid) throws SQLException {
		// querySort();
		String sql = null;
		switch(level) {
		//这个数比分类级别少1
		case 0:
			sql = "select * from paper,upload ,third,second where second.upper="+ sortid +"  and upload.paperID=paper.PaperID  and paper.sortID=third.thirdID and third.upper=second.secondID ";
			break;
		case 1:
			sql = "select * from paper ,upload  ,third where third.upper="+ sortid +"  and upload.paperID=paper.PaperID and paper.sortID=third.thirdID ";
			break;
		case 2:
			sql = "select * from paper ,upload where sortID="+ sortid +"  and upload.paperID=paper.PaperID";
			break;
		default:
			logger.error("No this sort: " + keyword);
		}
		
		logger.info(sql);
		if (sql == null) {
			result = new ArrayList<>();
		} else {
			papernum = querySql(sql);
		}
		
		logger.info(sql + " NUMBER: " + papernum);
		PaddingSort(sql, page);
		return SUCCESS;
	}
	
//实现分页
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
        switch(getSorttype()) {
        case 1:
        	sql=sql+" and paper.Status=1 order by upload.uploadDate desc limit "+(page-1)*10+",10";
        	break;
        case 2:
        	sql=sql+" and paper.Status=1 order by upload.clickTime desc limit "+(page-1)*10+",10";
        	break;
        case 3:
        	sql=sql+" and paper.Status=1 order by paper.Date desc limit "+(page-1)*10+",10";
        	break;
        default:
        	sql=sql+" and paper.Status=1  limit "+(page-1)*10+",10";
        	break;
        	
        }
        System.out.println(sql);

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
            session.setAttribute("selectchoice",selectchoice); 
            session.setAttribute("keyword",keyword);
            session.setAttribute("pagenum",current_page);

            if(i==current_page){  
                s.append("<li class='active' >"+i+"</li>");
            }  
            else{ 
            	if(index==0) {
            		 s.append("<a href='chooseSearch.action?page="+i+"&&keyword="+keyword+"&&selectchoice="+selectchoice+"'><li>"+i+"</li></a>");  
            	}else {
            		  s.append("<a href='querySort.action?page="+i+"&&keyword="+keyword+"&&selectchoice="+selectchoice+"'><li>"+i+"</li></a>");  
            	}	 
            }  
        }  
        StringBuffer TypeSortadd=new StringBuffer();
	        TypeSortadd.append("<li role='presentation'><a href='chooseSearch.action?page=1&&keyword="+keyword+"&&selectchoice="+selectchoice+"&&sorttype=2'>按照下载数量排序</a></li>");
	        TypeSortadd.append("<li role='presentation'><a href='chooseSearch.action?page=1&&keyword="+keyword+"&&selectchoice="+selectchoice+"&&sorttype=1'>按照上传时间排序</a></li>");
	        TypeSortadd.append("<li role='presentation'><a href='chooseSearch.action?page=1&&keyword="+keyword+"&&selectchoice="+selectchoice+"&&sorttype=3'>按照发表时间排序</a></li>");
	        
		//querySort();
	        session.setAttribute("TypeSortadd",TypeSortadd); 
	        context.put("TypeSortadd",TypeSortadd);  
        System.out.println(s);
        session.setAttribute("list",list); 
        session.setAttribute("s",s); 
        context.put("list", list);  
        context.put("s",s);  
  
		return null;
	}
	public String PaddingSort(String sql,int page) {
		
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
	    switch(getSorttype()) {
	    case 1:
	    	sql=sql+" and paper.Status=1 order by upload.uploadDate desc limit "+(page-1)*10+",10";
	    	break;
	    case 2:
	    	sql=sql+" and paper.Status=1 order by upload.clickTime desc limit "+(page-1)*10+",10";
	    	break;
	    case 3:
	    	sql=sql+" and paper.Status=1 order by paper.Date desc limit "+(page-1)*10+",10";
	    	break;
	    default:
	    	sql=sql+" and paper.Status=1  limit "+(page-1)*10+",10";
	    	break;
	    	
	    }
	    
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
	        session.setAttribute("selectchoice",selectchoice); 
	        session.setAttribute("keyword",keyword);
	        session.setAttribute("pagenum",current_page);
	
	        if(i==current_page){  
	            s.append("<li class='active' >"+i+"</li>");
	        }  
	        else{ 
	        	
	        		 s.append("<li><a href='querySort.action?page="+i+"&&keyword="+keyword+"&&selectchoice="+selectchoice+"'>"+i+"</a></li>");  
	        	
	        }  
	    }  		
	    StringBuffer TypeSortadd=new StringBuffer();
	    TypeSortadd.append("<li role='presentation'><a href='querySort.action?page=1&&keyword="+keyword+"&&selectchoice="+selectchoice+"&&sorttype=2'>按照下载数量排序</a></li>");
	    TypeSortadd.append("<li role='presentation'><a href='querySort.action?page=1&&keyword="+keyword+"&&selectchoice="+selectchoice+"&&sorttype=1'>按照上传时间排序</a></li>");
	    TypeSortadd.append("<li role='presentation'><a href='querySort.action?page=1&&keyword="+keyword+"&&selectchoice="+selectchoice+"&&sorttype=3'>按照发表时间排序</a></li>");
	    
	//querySort();
	    session.setAttribute("TypeSortadd",TypeSortadd); 
	    context.put("TypeSortadd",TypeSortadd); 
	    session.setAttribute("list",list); 
	    session.setAttribute("s",s); 
	    context.put("list", list);  
	    context.put("s",s);  
	
		return null;
	}

	public int querySql(String sql) throws SQLException {
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
			e.printStackTrace();
		}
		return count;
	}

	public int getSorttype() {
		return sorttype;
	}

	public void setSorttype(int sorttype) {
		this.sorttype = sorttype;
	}

	public int getPage() {
	    return page;
	}

	public void setPage(int page) {
	    this.page = page;
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

    /**
     * @return the seqencechoice
     */
    public int getSeqencechoice() {
        return seqencechoice;
    }

    /**
     * @param seqencechoice the seqencechoice to set
     */
    public void setSeqencechoice(int seqencechoice) {
        this.seqencechoice = seqencechoice;
    }

}

package action;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import model.Paper;
import service.ConnectSQL;
import support.UserSupport;

@SuppressWarnings("unused")
public class SearchPaper extends UserSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1234L;
	private String keyword;
	private List<Paper> result;
	private int selectchoice;
	private int papernum;

	public String execute() {
		return SUCCESS;
	}
	private int querySql(String sql) {
	    int papernum=0;
		Connection conn = ConnectSQL.getConn();
		ActionContext context = ActionContext.getContext();
		result = new ArrayList<>();
		PreparedStatement pstmt;
		ServletRequest request = ServletActionContext.getRequest();
	    HttpServletRequest req = (HttpServletRequest) request;
	    HttpSession session = req.getSession();
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				Paper temp = new Paper();

				temp.setPaperID(rs.getString(1));
				temp.setTitle(rs.getString(2));
				temp.setAuthor(rs.getString(3));
				temp.setDate(rs.getString(5));
				temp.setPublication(rs.getString(7));
				papernum++;
                if(rs.getString(4)!=null)
                {
                	temp.setSecondauthor2(Arrays.asList(rs.getString(4).trim().split(",")));
                }
                
                else
                {
                    context.put("secondauthorid", "");
                }
                //second author end
                if(rs.getString(9)!=null)
                {
                	temp.setKeyword2(Arrays.asList(rs.getString(9).trim().split(",")));
                }
          

				result.add(temp);
			}
			context.put("papernum", papernum);
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
	}
	
	/**
     * @param string
     * @return
     */
    private PrintStream println(String string) {
        // TODO Auto-generated method stub
        return null;
    }
    public String[] Translate(String a)
    {
        String[]b=a.trim().split(",");
        return b;
    }
    public String chooseSearch()
	{
	    String sql ="SELECT * FROM paper WHERE KeyWords LIKE '%" + keyword + "%'" ;
       switch(selectchoice)
       {

         case 1:
                   sql = "SELECT * FROM paper WHERE KeyWords LIKE '%" + keyword + "%'";
                   break;
         case 2: 
                   sql = "SELECT * FROM paper WHERE Title LIKE '%" + keyword + "%'";
                   break;
         case 3:
                   sql = "SELECT * FROM paper WHERE FirstAuthorID='" + keyword + "' "
                   		+ "OR SecondAuthorID REGEXP '[[:<:]]" + keyword + "[[:>:]]'";
                   break;
         case 4:
                   sql = "SELECT * FROM paper WHERE Date ='" + keyword + "'";
                   break;
         case 5:
                   sql = "SELECT * FROM paper WHERE JournalID='" + keyword + "'";
                   break;
       }
       querySql(sql);		
       try {
			dd(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       return SUCCESS;
	    
	}
   public String showDetail() {
            System.out.println("Searching PaperID!!");
	        String sql = "SELECT * FROM paper WHERE PaperID= '" + keyword + "'";
	        querySql(sql);
	        for(Paper t:result) {
	            System.out.println(t);
	        }
	        return SUCCESS;
	        }
	public String searcTitle() {
		String sql = "SELECT * FROM paper WHERE Title LIKE '%" + keyword + "%'";
		querySql(sql);
		for(Paper t:result) {
			System.out.println(t);
		}

		return SUCCESS;
	}

	public String searchAuthor() {
	    System.out.print(keyword);
		String sql = "SELECT * FROM paper WHERE FirstAuthorID='" + keyword + "'";
		querySql(sql);
		for(Paper t:result) {
			System.out.println(t);
		}
		try {
			dd(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String searchJournal() {
		String sql = "SELECT * FROM paper WHERE JournalID='" + keyword + "'";
		querySql(sql);
		try {
			dd(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String searchKeyword() {
		String sql = "SELECT * FROM paper WHERE KeyWords LIKE '%" + keyword + "%'";
		querySql(sql);
		try {
			dd(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String searchDate() {
		String sql = "SELECT * FROM paper WHERE Date ='" + keyword + "'";
		querySql(sql);
		try {
			dd(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	   public int getPapernumber() {
	        return papernum;
	    }
    public void setPapernumber(int papernum) {
        this.papernum = papernum;
    }
	public List<Paper> getResult() {
		return result;
	}
	public void setResult(List<Paper> result) {
		this.result = result;
	}

   

}

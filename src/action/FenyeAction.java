package action;




import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.Paper;
import model.gradeinfo;

public class FenyeAction extends ActionSupport {
	  private int page;  
	  
	    public int getPage() {  
	        return page;  
	    }  
	  
	    public void setPage(int page) {  
	        this.page = page;  
	    }  
	  

		public String execute() throws Exception{  
	        int current_page=getPage();
	        HttpSession session = ServletActionContext.getRequest ().getSession();
	        ActionContext context=ActionContext.getContext();  
	        Paper grade=new Paper(); 
	        List list= (List) SearchPaper.querySqlsbychangfan(current_page);
	        String sql="select * from paper  order by paperID desc;";
	        int pages=SearchPaper.querySqlS(sql);  
	         StringBuffer s=new StringBuffer();  
	        for(int i=1;i<(pages/3+2);i++){  
	            if(i==current_page){  
	                s.append("["+i+"]");  
	            }  
	            else{  
	                s.append("<a href='myaction?page="+i+"'>"+i+"</a>");  
	            }  
	        }  
	        System.out.println(s);
	        session.setAttribute("list",list); 
	        session.setAttribute("s",s); 
	        context.put("list", list);  
	        context.put("s",s);  
	        return "success";         
	    }  
}

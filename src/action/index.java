/**
 * 
 */
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

import service.Dao;
import support.PaperSupport;


/**
 * @author 31644
 *
 */
public class index extends PaperSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 4L;
    static private Logger logger = Logger.getLogger(index.class);
    
//Query function：just keep the title or sortname in a list 
    private List<String> query(String sql) throws SQLException{
            List<String> list1;
            list1=new ArrayList<>();
            Connection conn = Dao.getConn();
            PreparedStatement pstmt;
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int count = 0;
            while (rs.next()&&count<8) {
                list1.add(rs.getString(2));
                count++;
            }
            return list1;
        }
    
//function to find some papers and sortnames shown by index.jsp
    public String execute()
    {
        
        HttpSession session = ServletActionContext.getRequest ().getSession();
        try {
            String sql="select * from paper order by Date desc";//挑选出来最新的论文
            List<String> list1 = query(sql);
            logger.info(sql);
            session.setAttribute("lastestpaper",list1);
            sql="select * from paper";//没有实现根据浏览次数选择论文 
            List<String> list2 = query(sql);
            logger.info(sql);
            session.setAttribute("hotpaper",list2);
            sql="select * from third";//没有实现根据浏览次数选择分类 
            List<String> list3 = query(sql);
            logger.info(sql);
            session.setAttribute("hotsort",list3);
            sql="select * from first";
            List<String> list4 = query(sql);
            session.setAttribute("Level1",list4);
            logger.info(sql);
            return SUCCESS;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return ERROR;
        }
    }
    
 }//end of class index


 


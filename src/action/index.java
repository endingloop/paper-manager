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

import model.Paper;
import service.Dao;
import service.ExcelGenerate;
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
    private List<Paper> result;
    
    public List<Paper> querySql(String sql) throws SQLException {
        Connection conn = Dao.getConn();
        result = new ArrayList<>();
        PreparedStatement pstmt;
        pstmt = (PreparedStatement) conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        int count=0;
        while (rs.next()&&count<8) {
            Paper temp = new Paper();
            temp.setPaperID(rs.getString(1));
            temp.setTitle(rs.getString(2));
            result.add(temp);
            count++;
        }
            return result;
    }

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
            String sql="SELECT * FROM paper,upload where paper.Status=1 and paper.PaperID=upload.paperID  order by upload.uploadDate desc";
        
            session.setAttribute("lastestpaper",querySql(sql));
            logger.info(sql);
            sql="SELECT * FROM paper,upload where paper.Status=1 and paper.PaperID=upload.paperID  order by upload.clickTime desc"; 
            session.setAttribute("hotpaper",querySql(sql));
            logger.info(sql);
            sql="select * from third";
            session.setAttribute("hotsort",query(sql));
            sql="select * from first";
            logger.info(sql);
            session.setAttribute("Level1",query(sql));
            logger.info(sql);
            return SUCCESS;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return ERROR;
        }
    }
    
 }//end of class index


 


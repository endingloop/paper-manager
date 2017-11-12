package action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import model.Paper;
import service.Dao;
import service.Sequence;

public class sort3th {
	public  int thirdID;
	public  int secondID;
	public  int firstID;
	public  Paper paper;
public int getSecondID() {
		return secondID;
	}
	public void setSecondID(int secondID) {
		this.secondID = secondID;
	}
	public int getFirstID() {
		return firstID;
	}
	public void setFirstID(int firstID) {
		this.firstID = firstID;
	}
public Paper getPaper() {
		return paper;
	}
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
public int getThirdID() {
		return thirdID;
	}
	public void setThirdID(int thirdID) {
		this.thirdID = thirdID;
	}
public  List<Paper> result;
public   List<Paper> getResult() {
	return result;
}
public void setResult(List<Paper> result) {
	this.result = result;
}

public String findsort3th() {
	System.out.println(getThirdID());
	Connection conn=Dao.getConn();
	String sql="select * from paper where sortID="+getThirdID();
	PreparedStatement pst = null;
	result = new ArrayList<>();
	try {
		pst= (PreparedStatement)conn.prepareStatement(sql);
		ResultSet rs=pst.executeQuery(sql);
		while(rs.next()) {
			Paper temp = new Paper();
			temp.setPaperID(rs.getString(1));
			temp.setTitle(rs.getString(2));
			temp.setAuthor(rs.getString(3));
			temp.setDate(rs.getString(5));
			temp.setKeyword(rs.getString(9));
			temp.setPublication(rs.getString(7));
			result.add(temp);		
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		dd(result);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "success";
}
//������ѯ
public String findsort2th() {
	System.out.println(getSecondID());
	Connection conn=Dao.getConn();
	String sql="select * from paper,third where third.upper="+getSecondID()+" and paper.sortID=third.thirdID";
	result = new ArrayList<>();
	System.out.println(sql);
	PreparedStatement pst = null;
	try {
		pst= (PreparedStatement)conn.prepareStatement(sql);
		ResultSet rs=pst.executeQuery(sql);
		while(rs.next()) {
			Paper temp = new Paper();
			temp.setPaperID(rs.getString(1));
			temp.setTitle(rs.getString(2));
			temp.setAuthor(rs.getString(3));
			temp.setDate(rs.getString(5));
			temp.setKeyword(rs.getString(9));
			temp.setPublication(rs.getString(7));
			result.add(temp);		
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	for(Paper t:result) {
		System.out.println(t.getDate());
	}
	try {
		dd(result);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//System.out.println(getSecondID());
	return "success";
}
//һ����ѯ
public String findsort1th() {
	System.out.println(getFirstID());
	Connection conn=Dao.getConn();
	String sql="select * from paper,third,second where second.upper="+getFirstID()+" and paper.sortID=third.thirdID and third.upper=second.secondID;";
	System.out.println(sql);
	result = new ArrayList<>();
	PreparedStatement pst = null;
	try {
		pst= (PreparedStatement)conn.prepareStatement(sql);
		ResultSet rs=pst.executeQuery(sql);
		while(rs.next()) {
			Paper temp = new Paper();
			temp.setPaperID(rs.getString(1));
			temp.setTitle(rs.getString(2));
			temp.setAuthor(rs.getString(3));
			temp.setDate(rs.getString(5));
			temp.setKeyword(rs.getString(9));
			temp.setPublication(rs.getString(7));
			result.add(temp);		
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	for(Paper t:result) {
		System.out.println(t.getDate());
	}
	//System.out.println(getFirstID());
	try {
		dd(result);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "success";
}

public static void dd(List<Paper> result ) throws Exception  
{  
    // 第一步，创建一个webbook，对应一个Excel文件  
    HSSFWorkbook wb = new HSSFWorkbook();  
    // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
    HSSFSheet sheet = wb.createSheet("学生表一");  
    // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
    HSSFRow row = sheet.createRow((int) 0);  
    // 第四步，创建单元格，并设置值表头 设置表头居中  
    HSSFCellStyle style = wb.createCellStyle();  
   

    HSSFCell cell = row.createCell((short) 0);  
    cell.setCellValue("论文ID");  
    cell.setCellStyle(style);  
    cell = row.createCell((short) 1);  
    cell.setCellValue("题目");  
    cell.setCellStyle(style);  
    cell = row.createCell((short) 2);  
    cell.setCellValue("作者");  
    cell.setCellStyle(style);  
    cell = row.createCell((short) 3);  
    cell.setCellValue("日期");
    cell = row.createCell((short) 4);  
    cell.setCellValue("关键字"); 
    cell = row.createCell((short) 5);  
    cell.setCellValue("发布商"); 
    cell.setCellStyle(style);  

    // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
    
    List list = result; 

    for (int i = 0; i < list.size(); i++)  
    {  
        row = sheet.createRow((int) i + 1);  
        Paper stu = (Paper) list.get(i);  
        // 第四步，创建单元格，并设置值  
        row.createCell((short) 0).setCellValue(stu.getPaperID());
        row.createCell((short) 1).setCellValue(stu.getTitle());  
        row.createCell((short) 2).setCellValue(stu.getAuthor());  
        row.createCell((short) 3).setCellValue(stu.getDate());
        row.createCell((short) 4).setCellValue(stu.getKeyword());  
        row.createCell((short) 5).setCellValue(stu.getPublication());  
        cell = row.createCell((short) 6);  
       
    }  
    // 第六步，将文件存到指定位置  
    try  
    {  
        FileOutputStream fout = new FileOutputStream("D:\\eclipse-jee-oxygen-1a-win32-x86_64\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\paper-manager\\js\\students.xls");  
        wb.write(fout);  
        fout.close();  
        
    }  
    catch (Exception e)  
    {  
        e.printStackTrace();  
    }  

	return ;
}


}

package service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import model.Paper;
import model.gradeinfo;
import model.score;
import support.UserSupport;

public class ExcelGenerate {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	

	public static  void GeneralQueryExcel(List<Paper> result  ) throws Exception  
	{  
		
		
	    // 第一步，创建一个webbook，对应一个Excel文件  
	    HSSFWorkbook wb = new HSSFWorkbook();  
	    // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
	    HSSFSheet sheet = wb.createSheet("查询结果");  
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
	    cell.setCellValue("第二作者");
	    cell = row.createCell((short) 4);  
	    cell.setCellValue("日期"); 
	    cell = row.createCell((short) 5);  
	    cell.setCellValue("论文等级"); 
	    cell = row.createCell((short) 6);  
	    cell.setCellValue("所属类别");
	    cell = row.createCell((short) 7);  
	    cell.setCellValue("关键字");
	    cell.setCellStyle(style);  

	    // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
	    
	    List list = result; 
	   

	    for (int i = 0; i < list.size(); i++)  
	    {  
	        row = sheet.createRow((int) i + 1);  
	        Paper paperbean = (Paper) list.get(i);  
	        // 第四步，创建单元格，并设置值  
	        row.createCell((short) 0).setCellValue(paperbean.getPaperID());
	        row.createCell((short) 1).setCellValue(paperbean.getTitle());  
	        row.createCell((short) 2).setCellValue(paperbean.getAuthor());  
	        row.createCell((short) 3).setCellValue(paperbean.getSecondAuthor());
	        row.createCell((short) 4).setCellValue(paperbean.getDate());  
	        row.createCell((short) 5).setCellValue(Dao.matchlevel(paperbean.getLevel()));
	        row.createCell((short) 6).setCellValue(Dao.findsortname(paperbean.getSort()));  
	        row.createCell((short) 7).setCellValue(paperbean.getKeyword());  
	        cell = row.createCell((short) 8);  
	       
	    }  
	  
		String destPath = "/app/webapps/ROOT/upload";
		try {  
		       
			   FileOutputStream fout = new FileOutputStream(destPath+"/GenerateQueryResult.xls");
		       wb.write(fout);  
		        fout.close();  
	        
	    }  
	    catch (Exception e)  
	    {  
	        e.printStackTrace();  
	    }  

		return ;
	}
	
	public static void TaskQueryExcel(List<score> result,String startdate,String enddate,String username ) {
	    HSSFWorkbook wb = new HSSFWorkbook();  
	    HSSFSheet sheet = wb.createSheet(startdate+"-"+enddate+"工作量查询总表");  
	    HSSFRow row = sheet.createRow((int) 0); 
	    HSSFCellStyle style = wb.createCellStyle();  
	    HSSFCell cell = row.createCell((short) 0);  
	    cell.setCellValue("作者");  
	    cell.setCellStyle(style);  
	    cell = row.createCell((short) 1);  
	    cell.setCellValue("得分");  
	    cell.setCellStyle(style);  
	    cell = row.createCell((short) 2);  
	    cell.setCellValue("以第一作者身份发布论文总数");  
	    cell.setCellStyle(style);  
	    cell = row.createCell((short) 3);  
	    cell.setCellValue("以第二作者身份发布论文总数");  
	    cell.setCellStyle(style);  
	    List list = result; 
	    for (int i = 0; i < list.size(); i++)  
	    {  
	        row = sheet.createRow((int) i + 1);  
	        score scorebean = (score) list.get(i);  
	        row.createCell((short) 0).setCellValue(scorebean.getName());
	        row.createCell((short) 1).setCellValue(scorebean.getScore());  
	        row.createCell((short) 2).setCellValue(scorebean.getFauthornum());  
	        row.createCell((short) 3).setCellValue(scorebean.getSauthornum());
	        cell = row.createCell((short) 4);  
	       
	    }  
	    	String destPath = "/app/webapps/ROOT/upload";
		try {    
			   FileOutputStream fout = new FileOutputStream(destPath+"/"+username+"WorkListQueryResult.xls");
		       wb.write(fout);  
		        fout.close();       
	    }  
	    catch (Exception e)  
	    {  
	        e.printStackTrace();  
	    }  

		return ;
	}
	public static void PersonalWorkloadQuery(List<gradeinfo> result,String str,String startdate,String enddate,String username) {
	    HSSFWorkbook wb = new HSSFWorkbook(); 
	    HSSFSheet sheet = wb.createSheet(str+"在"+startdate+"-"+enddate+"工作量细化");    
	    HSSFRow row = sheet.createRow((int) 0);    
	    HSSFCellStyle style = wb.createCellStyle();  
	    HSSFCell cell = row.createCell((short) 0);  
	    cell.setCellValue("论文编号");  
	    cell.setCellStyle(style);  
	    cell = row.createCell((short) 1);  
	    cell.setCellValue("题目");  
	    cell.setCellStyle(style);  
	    cell = row.createCell((short) 2);  
	    cell.setCellValue("作者");  
	    cell.setCellStyle(style);  
	    cell = row.createCell((short) 3);  
	    cell.setCellValue("合作者");
	    cell.setCellStyle(style);
	    cell = row.createCell((short) 4);  
	    cell.setCellValue("日期");
	    cell.setCellStyle(style);
	    cell = row.createCell((short) 5); 
	    cell.setCellValue("论文类型");  
	    cell.setCellStyle(style);
	    cell = row.createCell((short) 6); 
	    cell.setCellValue("关键字");  
	    cell.setCellStyle(style);
	    cell = row.createCell((short) 7);  
	    cell.setCellValue("论文等级");  
	    cell.setCellStyle(style);  
	    cell = row.createCell((short) 8);  
	    cell.setCellValue("总分");  
	    cell.setCellStyle(style);  
	    cell = row.createCell((short) 9);  
	    cell.setCellValue("实际得分");  
	    cell.setCellStyle(style);
	    List list = result; 
	    for (int i = 0; i < list.size(); i++)  
	    {  
	        row = sheet.createRow((int) i + 1);  
	        gradeinfo gradeinfobean = (gradeinfo) list.get(i);  
	        row.createCell((short) 0).setCellValue(gradeinfobean.getPaperID());
	        row.createCell((short) 1).setCellValue(gradeinfobean.getTitle());  
	        row.createCell((short) 2).setCellValue(gradeinfobean.getAuthor());  
	        row.createCell((short) 3).setCellValue(gradeinfobean.getSecondAuthor());
	        row.createCell((short) 4).setCellValue(gradeinfobean.getDate());
	        row.createCell((short) 5).setCellValue(gradeinfobean.getSortname()); 
	        row.createCell((short) 6).setCellValue(gradeinfobean.getKeywords());
	        row.createCell((short) 7).setCellValue(gradeinfobean.getLevelname());  
	        row.createCell((short) 8).setCellValue(gradeinfobean.getLevel());
	        row.createCell((short) 9).setCellValue(gradeinfobean.getGotscore());
	        cell = row.createCell((short) 10);   
	    } 
	String destPath = "/app/webapps/ROOT/upload";
	    try  
	    {  
	    	FileOutputStream fout = new FileOutputStream(destPath+"/"+username+"PersonalworkloadQueryResult.xls");
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

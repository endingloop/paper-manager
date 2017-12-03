package action;


import java.util.ArrayList;
import java.util.List;

import model.gradeinfo;
import service.Dao;

public class ceshi {
public List<gradeinfo> list;
public List<gradeinfo> list1;

public void main(String[] args)
{
	String str=null;
	str="changfan1";
	 list= new ArrayList<>();
	 list=Dao.findFirstAuthor(str);
	 list1 =new ArrayList<>();
	 list1=Dao.findSecondtAuthor(str);
	 for(gradeinfo item:list) {
		 System.out.println(item.getLevelname()+" "+item.getAuthor()+"firstauthor");
	 }
	 for(gradeinfo items:list1) {
		 System.out.println(items.getLevelname()+" "+items.getAuthor()+"secondauthor");
	 }
}
}

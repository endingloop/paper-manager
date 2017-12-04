package model;

public class gradeinfo {
	private String paperID;
	private String title;
	private String author;
	private String secondAuthor;
	private String date;
	private int sort;
	private int level;
	private String sortname;
	private String levelname;
	private  float gotscore;
	private String keywords;
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public gradeinfo() {
		
	}
	public gradeinfo(String paperID,String title,String author,String keywords,String secondAuthor,String date,int sort,int level,String sortname,String levelname,float gotscore)
	{
		this.paperID = paperID;
		this.title = title;
		this.author = author;
		this.secondAuthor = secondAuthor;
		this.date = date;
		this.sort = sort;
		this.level=level;
		this.sortname=sortname;
		this.levelname=levelname;
		this.gotscore=gotscore;
		this.keywords=keywords;
	}
	public String getPaperID() {
		return paperID;
	}
	public void setPaperID(String paperID) {
		this.paperID = paperID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSecondAuthor() {
		return secondAuthor;
	}
	public void setSecondAuthor(String secondAuthor) {
		this.secondAuthor = secondAuthor;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getSortname() {
		return sortname;
	}
	public void setSortname(String sortname) {
		this.sortname = sortname;
	}
	public String getLevelname() {
		return levelname;
	}
	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}
	public float getGotscore() {
		return gotscore;
	}
	public void setGotscore(float gotscore) {
		this.gotscore = gotscore;
	}
}

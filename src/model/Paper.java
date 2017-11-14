package model;

import java.util.List;

public class Paper {
	private String paperID;
	private String author;
	private String secondauthor;
	private String title;
	private String keyword;
	private String date;
	private String publication;
	private String category;
	
	public String getPaperID() {
		return paperID;
	}
	public void setPaperID(String paperID) {
		this.paperID = paperID;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
    public String getSecondauthor() {
        return secondauthor;
    }
    public void setSecondauthor(String secondauthor) {
        this.secondauthor = secondauthor;
    }
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String catagory) {
		this.category = catagory;
	}
	@Override
	public String toString() {
		return author + "的论文" + title;
	}
	public List<String> getSecondauthor2() {
		return secondauthor2;
	}
	public void setSecondauthor2(List<String> secondauthor2) {
		this.secondauthor2 = secondauthor2;
	}
	public List<String> getKeyword2() {
		return keyword2;
	}
	public void setKeyword2(List<String> keyword2) {
		this.keyword2 = keyword2;
	}
	private List<String> secondauthor2;
	private List<String> keyword2;
}

package model;

public class Paper {
	private String paperID;
	private String title;
	private String author;
	private String secondAuthor;
	private String date;
	private int sort;
	private String publication;
	private int status;
	private String keyword;
	private String description;
	private String filename;
	private int level;
	private int clickTime;

	public int getClickTime() {
		return clickTime;
	}
	public void setClickTime(int clickTime) {
		this.clickTime = clickTime;
	}
	@Override
	public String toString() {
		return paperID + ": " + title;
	}
	//重写相等函数，用于删除使用
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Paper) {
			Paper paper = (Paper) obj;
			return paperID.equals(paper.paperID);
		}
        return super.equals(obj);
	}
	//同时应该重写此函数
	@Override
    public int hashCode() {
        Paper paper = (Paper) this;
        //System.out.println("Hash" + paper.paperID);
        return paperID.hashCode();
    }
	
	public String[] getSecondAuthorList() {
		return getSecondAuthor().split(",");
	}
	
	public String[] getKeywordList() {
		return getKeyword().split(",");
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

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		if(publication == null || publication.isEmpty()) {
			this.publication = "未知";
		}
		else this.publication = publication;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}

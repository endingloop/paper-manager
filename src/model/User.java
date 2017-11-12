package model;

import java.util.List;

public class User {
	public User() {
	}
	public User(String username, String password, List<Paper> papers) {
		this.username = username;
		this.password = password;
		this.papers = papers;
	}
	
	public String getPaperIdList() {
		StringBuffer list = new StringBuffer();
		if (papers != null && !papers.isEmpty()) {
			for (Paper temp : papers) {
				list.append(temp.getPaperID());
				list.append(",");
			}
			list.setLength(list.length() - 1);
		}
		return list.toString();
	}
	
	private String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	private String password;

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	private List<Paper> papers;

	public List<Paper> getPapers() {
		return papers;
	}
	public void setPapers(List<Paper> papers) {
		this.papers = papers;
	}
}

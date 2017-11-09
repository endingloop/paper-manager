package model;

public class score {
public String userID;
public String name;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int score;
public String getUserID() {
	return userID;
}
public void setUserID(String userID) {
	this.userID = userID;
}

public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}
public score() {
}
public score(String name,String userID,int score) {
	this.userID = userID;
	this.score = score;
	this.name = name;
}
}
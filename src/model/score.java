package model;

public class score {

public String name;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int score;



public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}
public score() {
}
public score(String name,int score) {

	this.score = score;
	this.name = name;
}
}
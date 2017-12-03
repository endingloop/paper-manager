package model;

public class score {
public int fauthornum;
public int sauthornum;


public int getSauthornum() {
	return sauthornum;
}
public void setSauthornum(int sauthornum) {
	this.sauthornum = sauthornum;
}
public int getFauthornum() {
	return fauthornum;
}
public void setFauthornum(int fauthornum) {
	this.fauthornum = fauthornum;
}

public String name;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float score;
public float getScore() {
	return score;
}
public void setScore(float score) {
	this.score = score;
}
public score() {
}
public score(String name,float score,int fauthornum,int sauthornum ) {
	
	this.score = score;
	this.name = name;
	this.sauthornum=sauthornum;
	this.fauthornum=fauthornum;
}
}
package cn.edu.chenggong.postings.model;

import java.util.Date;

import cn.edu.chenggong.po.Users;

public class Reply {
	 private int id;
	 private int TopicID;
	 private int replyID;
	 private Date date;
	 private String content;
	 private int flowers;
	 private int eggs;
	 private int state;
	 private String EXT1;
	 private String EXT2;
	 private String EXT3;
	 private String EXT4;
	 private String EXT5;
	 private Users replyUser;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTopicID() {
		return TopicID;
	}
	public void setTopicID(int topicID) {
		TopicID = topicID;
	}
	public int getReplyID() {
		return replyID;
	}
	public void setReplyID(int replyID) {
		this.replyID = replyID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getFlowers() {
		return flowers;
	}
	public void setFlowers(int flowers) {
		this.flowers = flowers;
	}
	public int getEggs() {
		return eggs;
	}
	public void setEggs(int eggs) {
		this.eggs = eggs;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getEXT1() {
		return EXT1;
	}
	public void setEXT1(String eXT1) {
		EXT1 = eXT1;
	}
	public String getEXT2() {
		return EXT2;
	}
	public void setEXT2(String eXT2) {
		EXT2 = eXT2;
	}
	public String getEXT3() {
		return EXT3;
	}
	public void setEXT3(String eXT3) {
		EXT3 = eXT3;
	}
	public String getEXT4() {
		return EXT4;
	}
	public void setEXT4(String eXT4) {
		EXT4 = eXT4;
	}
	public String getEXT5() {
		return EXT5;
	}
	public void setEXT5(String eXT5) {
		EXT5 = eXT5;
	}
	public Users getReplyUser() {
		return replyUser;
	}
	public void setReplyUser(Users replyUser) {
		this.replyUser = replyUser;
	}
}

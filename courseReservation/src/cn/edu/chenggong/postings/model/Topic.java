package cn.edu.chenggong.postings.model;

import java.util.Date;

public class Topic {
	 private int id;
	 private String title;
	 private String content;
	 private int TopicStarter;
	 private Date date;
	 private String classify;
	 private int browseNum;
	 private int replyNum;
	 private String state;
	 private Date endDate;
	 private int endUser;
	 private int upvote;
	 private String EXT1;
	 private String EXT2;
	 private String EXT3;
	 private String EXT4;
	 private String EXT5;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getTopicStarter() {
		return TopicStarter;
	}
	public void setTopicStarter(int topicStarter) {
		TopicStarter = topicStarter;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public int getBrowseNum() {
		return browseNum;
	}
	public void setBrowseNum(int browseNum) {
		this.browseNum = browseNum;
	}
	public int getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getEndUser() {
		return endUser;
	}
	public void setEndUser(int endUser) {
		this.endUser = endUser;
	}
	public int getUpvote() {
		return upvote;
	}
	public void setUpvote(int upvote) {
		this.upvote = upvote;
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
	 
}

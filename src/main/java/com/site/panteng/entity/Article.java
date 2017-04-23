package com.site.panteng.entity;

public class Article {
	int id;
	String fileName;
	String title;
	String summary;
	String nickName;
	String pubTime;
	String tags;
	
	
	public Article() {
		super();
	}
	
	
	public Article(int id, String fileName, String title, String summary,
			String nickName, String pubTime, String tags) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.title = title;
		this.summary = summary;
		this.nickName = nickName;
		this.pubTime = pubTime;
		this.tags = tags;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPubTime() {
		return pubTime;
	}
	public void setPubTime(String pubTime) {
		this.pubTime = pubTime;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}

}

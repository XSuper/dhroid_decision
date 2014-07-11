package com.isuper.decision.bean;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobDate;
import cn.bmob.v3.datatype.BmobFile;

public class Theme extends BmobObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4249783345832489204L;
	/**
	 * 
	 */
	private User author;
	private BmobDate date;
	private String content;
	private BmobFile background;
	private String color;
	
	private Integer repliesCount;
	private Integer loveCount;
	private Integer newRECount;
	private Integer newLoCount;
	
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public BmobDate getDate() {
		return date;
	}
	public void setDate(BmobDate date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public BmobFile getBackground() {
		return background;
	}
	public void setBackground(BmobFile background) {
		this.background = background;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getRepliesCount() {
		return repliesCount;
	}
	public void setRepliesCount(Integer repliesCount) {
		this.repliesCount = repliesCount;
	}
	public Integer getLoveCount() {
		return loveCount;
	}
	public void setLoveCount(Integer loveCount) {
		this.loveCount = loveCount;
	}
	public Integer getNewRECount() {
		return newRECount;
	}
	public void setNewRECount(Integer newRECount) {
		this.newRECount = newRECount;
	}
	public Integer getNewLoCount() {
		return newLoCount;
	}
	public void setNewLoCount(Integer newLoCount) {
		this.newLoCount = newLoCount;
	}
	
	

}

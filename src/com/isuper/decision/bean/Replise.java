package com.isuper.decision.bean;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobDate;

public class Replise extends BmobObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2922672757851770880L;

	
	private Theme theme;
	private BmobDate date;
	private User publisher;
	private String content;
	private Integer loveCount;
	private Integer floor;
	private Replise targetReplise;
	public Theme getTheme() {
		return theme;
	}
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	
	public BmobDate getDate() {
		return date;
	}
	public void setDate(BmobDate date) {
		this.date = date;
	}
	public User getPublisher() {
		return publisher;
	}
	public void setPublisher(User publisher) {
		this.publisher = publisher;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getLoveCount() {
		return loveCount;
	}
	public void setLoveCount(Integer loveCount) {
		this.loveCount = loveCount;
	}
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	public Replise getTargetReplise() {
		return targetReplise;
	}
	public void setTargetReplise(Replise targetReplise) {
		this.targetReplise = targetReplise;
	}
	
	


}

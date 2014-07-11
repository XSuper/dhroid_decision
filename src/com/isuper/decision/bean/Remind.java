package com.isuper.decision.bean;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobDate;

public class Remind extends BmobObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3820484928760203705L;
	private Theme theme;
	private BmobDate date;
	private Integer type;
	private Integer count;//用于被赞和投票 计数
	private String content;
	private User fromUser;
	private User toUser;
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getFromUser() {
		return fromUser;
	}
	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}
	public User getToUser() {
		return toUser;
	}
	public void setToUser(User toUser) {
		this.toUser = toUser;
	}
	
	

}

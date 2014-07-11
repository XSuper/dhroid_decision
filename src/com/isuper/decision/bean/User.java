package com.isuper.decision.bean;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

public class User extends BmobUser{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4267586240819348085L;
	private BmobFile face;

	public BmobFile getFace() {
		return face;
	}

	public void setFace(BmobFile face) {
		this.face = face;
	}
	

}

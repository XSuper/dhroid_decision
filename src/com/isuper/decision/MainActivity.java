package com.isuper.decision;

import cn.bmob.v3.Bmob;
import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		Bmob.initialize(this, "ff8c3dbc926628cacf54f9c9bbf8dbab");
	}
}

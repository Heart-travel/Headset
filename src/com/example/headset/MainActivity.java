package com.example.headset;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	private HeadsetPlugReceiver headsetPlugReceiver; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/* register receiver */  
	    registerHeadsetPlugReceiver(); 
	}
	
	private void registerHeadsetPlugReceiver() {  
	    headsetPlugReceiver = new HeadsetPlugReceiver();
	    IntentFilter intentFilter = new IntentFilter();  
	    intentFilter.addAction("android.intent.action.HEADSET_PLUG");  
	    registerReceiver(headsetPlugReceiver, intentFilter);  
	  }
	
	 @Override  
	  public void onDestroy() {  
	    unregisterReceiver(headsetPlugReceiver);  
	    super.onDestroy();  
	  }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

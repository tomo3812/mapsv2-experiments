package com.example.mapsv2experiments;

import com.example.mapsv2experiments.maps.MapActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

	private Intent mStartMapActivityIntent;
	
	private Button mMenuHomeButton;
	private Button mShowMapButton;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mStartMapActivityIntent= new Intent(MainActivity.this, MapActivity.class);
        
        mMenuHomeButton= (Button) findViewById(R.id.mainMenuButton);
        mShowMapButton= (Button) findViewById(R.id.mainContentButton);
        mShowMapButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(mStartMapActivityIntent);
			}
		});
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	CharSequence optionTitle = item.getTitle();
    	if (optionTitle.equals(getString(R.string.setting_map))) {
    		startActivity(mStartMapActivityIntent);
    	}
    	
    	return super.onOptionsItemSelected(item);
    }
}

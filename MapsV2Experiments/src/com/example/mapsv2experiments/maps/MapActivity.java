package com.example.mapsv2experiments.maps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mapsv2experiments.MainActivity;
import com.example.mapsv2experiments.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity {

	private Intent mStartMainActivityIntent;
	
	private static final LatLng HAMBURG1 = new LatLng(53.558, 9.927);
	private static final LatLng KIEL1 = new LatLng(53.551, 9.993);
	private static final LatLng HAMBURG2 = new LatLng(53.563, 9.927);
	private static final LatLng KIEL2 = new LatLng(53.555, 9.993);
	private static final LatLng HAMBURG3 = new LatLng(53.565, 9.927);
	private static final LatLng KIEL3 = new LatLng(53.558, 9.993);
	private static final LatLng HAMBURG4 = new LatLng(53.570, 9.927);
	private static final LatLng KIEL4 = new LatLng(53.561, 9.993);
	private static final LatLng HAMBURG5 = new LatLng(53.573, 9.927);
	private static final LatLng KIEL5 = new LatLng(53.565, 9.993);
	private static final LatLng HAMBURG6 = new LatLng(53.575, 9.927);
	private static final LatLng KIEL6 = new LatLng(53.568, 9.993);	
	private static final LatLng HAMBURG7 = new LatLng(53.578, 9.927);
	private static final LatLng KIEL7 = new LatLng(53.571, 9.993);	

	private static GoogleMap mMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_map);
	    
	    if (mMap == null) {
	        mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFragment)).getMap();
	        if (mMap != null) {
	        	setupMap();
	        }
	    }

	    mStartMainActivityIntent= new Intent(MapActivity.this, MainActivity.class);
	}
	  
	@Override
	protected void onResume() {
		super.onResume();
		
		if (mMap == null) {
	        mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFragment)).getMap();
	        if (mMap != null) {
	        	setupMap();
	        }
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    getMenuInflater().inflate(R.menu.activity_map, menu);
	    return true;
	}
	  
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    CharSequence optionTitle = item.getTitle();
	    if (optionTitle.equals(getString(R.string.setting_home))) {
	    	startActivity(mStartMainActivityIntent);
	    }
	    	
	    return super.onOptionsItemSelected(item);
	}
	
	private void setupMap() {
		setupMapControls();
		addSampleMarkers();
		mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
	}
	    
	private void addSampleMarkers() {
      	mMap.addMarker(new MarkerOptions().position(HAMBURG1).title("Hamburg"));
      	mMap.addMarker(new MarkerOptions().position(KIEL1).title("Kiel").snippet("Kiel is cool").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
      	mMap.addMarker(new MarkerOptions().position(HAMBURG2).title("Hamburg"));
      	mMap.addMarker(new MarkerOptions().position(KIEL2).title("Kiel").snippet("Kiel is cool").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
      	mMap.addMarker(new MarkerOptions().position(HAMBURG3).title("Hamburg"));
      	mMap.addMarker(new MarkerOptions().position(KIEL3).title("Kiel").snippet("Kiel is cool").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
      	mMap.addMarker(new MarkerOptions().position(HAMBURG4).title("Hamburg"));
      	mMap.addMarker(new MarkerOptions().position(KIEL4).title("Kiel").snippet("Kiel is cool").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
      	mMap.addMarker(new MarkerOptions().position(HAMBURG5).title("Hamburg"));
      	mMap.addMarker(new MarkerOptions().position(KIEL5).title("Kiel").snippet("Kiel is cool").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
      	mMap.addMarker(new MarkerOptions().position(HAMBURG6).title("Hamburg"));
      	mMap.addMarker(new MarkerOptions().position(KIEL6).title("Kiel").snippet("Kiel is cool").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
      	mMap.addMarker(new MarkerOptions().position(HAMBURG7).title("Hamburg"));
      	mMap.addMarker(new MarkerOptions().position(KIEL7).title("Kiel").snippet("Kiel is cool").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
      	
      	mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(HAMBURG1, 15));
      	mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
	  }
	
	private void setupMapControls() {
		mMap.getUiSettings().setAllGesturesEnabled(true);
	}
}

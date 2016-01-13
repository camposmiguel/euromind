package com.miguelcr.listview.test;

import com.miguelcr.listview.MainActivity;
import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


public class TestHomeActivity extends ActivityInstrumentationTestCase2<MainActivity> {
  	private Solo solo;
  	
  	public TestHomeActivity() {
		super(MainActivity.class);
  	}

  	public void setUp() throws Exception {
        super.setUp();
		solo = new Solo(getInstrumentation());
		getActivity();
  	}
  
   	@Override
   	public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
  	}
  
	public void testRun() {
        //Wait for activity: 'com.miguelcr.listview.MainActivity'
		solo.waitForActivity(com.miguelcr.listview.MainActivity.class, 2000);
        //Set default small timeout to 104219 milliseconds
		Timeout.setSmallTimeout(104219);
        //Click on Lech Poznan
		solo.clickOnView(solo.getView(android.R.id.text1));
        //Click on Real Madrid
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
        //Click on Barcelona FC
		solo.clickOnView(solo.getView(android.R.id.text1, 2));
        //Click on Sevilla FC
		solo.clickOnView(solo.getView(android.R.id.text1, 3));
        //Click on Betis Balompie
		solo.clickOnView(solo.getView(android.R.id.text1, 4));
        //Click on ImageView
		solo.clickOnView(solo.getView(com.miguelcr.listview.R.id.fab));
        //Click on ImageView
		solo.clickOnView(solo.getView(android.widget.ImageView.class, 0));
        //Click on Settings
		solo.clickInList(1, 0);
	}
}

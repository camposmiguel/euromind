package com.miguelcr.listviewcustom.test;

import com.miguelcr.listviewcustom.MainActivity;
import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


public class TestList extends ActivityInstrumentationTestCase2<MainActivity> {
  	private Solo solo;
  	
  	public TestList() {
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
        //Wait for activity: 'com.miguelcr.listviewcustom.MainActivity'
		solo.waitForActivity(com.miguelcr.listviewcustom.MainActivity.class, 2000);
        //Set default small timeout to 47072 milliseconds
		Timeout.setSmallTimeout(47072);
        //Click on Banana
		solo.clickInList(1, 0);
        //Click on ImageView
		solo.clickOnView(solo.getView(com.miguelcr.listviewcustom.R.id.fab));
        //Click on ImageView
		solo.clickOnView(solo.getView(android.widget.ImageView.class, 0));
        //Click on Settings
		solo.clickInList(1, 0);
	}
}

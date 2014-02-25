package com.example.pic_2_text;


import com.example.pic_2_text.R;

import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Preview_Layout extends Activity {


	private ImageView photoDisplay;
	private Bitmap tempPhotoBitmap;

	private Camera mCamera;
	public final int cameraId = 0;
	private Bitmap photoBitmap;
	private Button cameraButton;
	private Button galleryButton;
	private int PhotoResult = 1;
	

	public static final int PHOTORESULT = 1;
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview__layout);
        
       
           	
    }
    
    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
	    if (requestCode == PHOTORESULT) {	
	    	photoBitmap = (Bitmap) data.getExtras().get("data");
	    	photoDisplay.setImageBitmap(photoBitmap);
	    		    		    	
	   }
	}
	
	
	/*  @Override
	  protected void onSaveInstanceState(Bundle outState) {
	      super.onSaveInstanceState(outState);
	      outState.putInt("theme", mThemeId);
	  }
	}*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.preview__layout, menu);
        return true;
    }
    
}

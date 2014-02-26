package com.example.pic_2_text;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.hardware.Camera;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class CameraActivity extends Activity {


	private Camera mCamera;
	private CameraSurfaceView mCameraView;
	private SurfaceHolder mHolder;
	private ImageView photoResult;
	private FrameLayout newFrame;
	private Button snapPhoto;
	boolean takePicture = false;
	private Bitmap photoBitmap;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        
        newFrame = (FrameLayout) findViewById(R.id.new_frame);
    	snapPhoto = (Button) findViewById(R.id.snap_shot);
       // mCanvas = (CanvasDrawing) this.findViewById(R.id.cd);
        
        setUpCamera();
    }

    public void setUpCamera(){
    	mCameraView = new CameraSurfaceView(getApplicationContext());
    	photoResult = new ImageView(getApplicationContext());
    	
    	//photoResult.setBackgroundColor(Color.white);
    	
    	
    	
    	newFrame.addView(photoResult);
    	newFrame.addView(mCameraView);
    	
    	newFrame.bringChildToFront(photoResult);
    	snapPhoto.bringToFront();
   
    
    	snapPhoto.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			mCameraView.capturePicture(jpegHandler);			
	    	//startActivity(new Intent(CameraActivity.this, Application_Layout.class));
	    	
  			// TODO Auto-generated method stub
			
		}
    	
    });
}
    public void captureHandler(View view){
    	if(takePicture){
    		mCameraView.capturePicture(jpegHandler);
    	}
    	else{
    		takePicture = true;
    		newFrame.bringChildToFront(mCameraView);
    		photoResult = null;
    	}
    }

    public Camera.PictureCallback jpegHandler = new Camera.PictureCallback(){
    	public void onPictureTaken(byte[] data, Camera camera){
    		photoBitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
    		photoResult.setImageBitmap(photoBitmap);
    		newFrame.bringChildToFront(photoResult);
    		takePicture = false;
    		mCamera.release();
    	}
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.camera, menu);
        return true;
    }
    
}
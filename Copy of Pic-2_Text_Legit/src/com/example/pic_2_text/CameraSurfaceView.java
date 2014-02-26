package com.example.pic_2_text;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback{

	private SurfaceHolder mHolder;
	public Camera mCamera = null;
	
	public CameraSurfaceView(Context context) {
		super(context);
		mHolder = getHolder();
		mHolder.addCallback(this);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void surfaceChanged(SurfaceHolder mHolder, int format, int width, int height) {
		Camera.Parameters camParams = mCamera.getParameters();
		camParams.setPreviewSize(width, height);
		mCamera.setParameters(camParams);
		mCamera.startPreview();
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder mHolder) {
		mCamera = Camera.open();
		
		try{
			mCamera.setPreviewDisplay(mHolder);
		} catch(Exception e){
			
		}
		// TODO Auto-generated method stub
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder mHolder) {
		mCamera.stopPreview();
		mCamera = null;
		
		// TODO Auto-generated method stub
		
	}
	
	public void capturePicture(Camera.PictureCallback jpegHandler){
		mCamera.takePicture(null, null, jpegHandler);
		
	}

    
}




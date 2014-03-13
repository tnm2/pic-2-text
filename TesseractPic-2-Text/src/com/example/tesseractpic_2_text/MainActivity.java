package com.example.tesseractpic_2_text;



import android.os.Environment;

import com.googlecode.tesseract.android.TessBaseAPI;

import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.Media;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private Button cameraButton;
	private Button galleryButton;
	private String filePath;
	private ImageView photoDisplay;
	private Button postButton;
	private Bitmap photoBitmap;
	private Uri outputFileUri;
	private int REQUEST_GALLERY = 2;
	private int REQUEST_CAMERA = 1;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final View contentView = findViewById(R.id.fullscreen_content);		

		//Sets the camera button and to the id of camera button on activity_main
		cameraButton = (Button) findViewById(R.id.camera_button);
		//Sets the gallery button to the id of gallery button on activity_main
		galleryButton = (Button) findViewById(R.id.gallery_button);
		
		postButton = (Button) findViewById(R.id.post_button);


		//Makes the button start to "listen" to read if the Gallery button is pressed
		galleryButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View x) {

				Intent galleryIntent = new Intent(Intent.ACTION_PICK, Media.EXTERNAL_CONTENT_URI);
				outputFileUri = galleryIntent.getData();				
				galleryIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);				
				startActivityForResult(galleryIntent, REQUEST_GALLERY);				
			}
		});
		
		postButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {    
				Intent postIntent = new Intent(MainActivity.this, ProcessedTextPreview.class);
				startActivity(postIntent);
			}
		});

		//Makes the button start to "listen" to read if the Gallery button is pressed
		cameraButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {            	
				Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(cameraIntent, REQUEST_CAMERA);	
			}
		}); 

		//Converting to bitmap
/*
		//_path = path to the image to be OCRed
		ExifInterface exif = new ExifInterface(filePath);
		int exifOrientation = exif.getAttributeInt(
        ExifInterface.TAG_ORIENTATION,
        ExifInterface.ORIENTATION_NORMAL);

		int rotate = 0;

		switch (exifOrientation) {
		case ExifInterface.ORIENTATION_ROTATE_90:
			rotate = 90;
			break;
		case ExifInterface.ORIENTATION_ROTATE_180:
			rotate = 180;
			break;
		case ExifInterface.ORIENTATION_ROTATE_270:
			rotate = 270;
			break;
		}

		if (rotate != 0) {
			int w = photoBitmap.getWidth();
			int h = photoBitmap.getHeight();

			// Setting pre rotate
			Matrix mtx = new Matrix();
			mtx.preRotate(rotate);

			// Rotating Bitmap & convert to ARGB_8888, required by tess
			photoBitmap = Bitmap.createBitmap(photoBitmap, 0, 0, w, h, mtx, false);
		}
		photoBitmap = photoBitmap.copy(Bitmap.Config.ARGB_8888, true);
		

		//Sending the image to Tesseract
		TessBaseAPI baseApi = new TessBaseAPI();
		String DATA_PATH = Environment.getExternalStorageDirectory().toString() + "/TesseractPic-2-Text/";
		String lang = "eng";
		baseApi.init(DATA_PATH, lang);
				// Eg. baseApi.init("/mnt/sdcard/tesseract/tessdata/eng.traineddata", "eng");
		baseApi.setImage(photoBitmap);
		String recognizedText = baseApi.getUTF8Text();
		baseApi.end();*/
	}

	/*Whenever the result Uri is determined, will direct the program to next 
	step(More code to be added)*/
	public void onActivityResult(int requestCode, int resultCode, Intent data){
		if(requestCode == REQUEST_CAMERA){

		}
		else if(requestCode == REQUEST_GALLERY){
		}
		else{

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

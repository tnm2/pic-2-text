package com.example.pic_2_text;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class GalleryPreview extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_preview);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.gallery_preview, menu);
        return true;
    }
    
}

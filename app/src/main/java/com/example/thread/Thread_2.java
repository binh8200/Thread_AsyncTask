package com.example.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Thread_2 extends AppCompatActivity implements View.OnClickListener, Listener {

    private TextView tvMessage;
    private Button btnLoad;
    private ImageView imgLoad;

    public static final String IMAGE_URL = "https://freeiconshop.com/wp-content/uploads/edd/android-flat.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_2);
        tvMessage = (TextView) findViewById(R.id.tvMessage);
        btnLoad = findViewById(R.id.btnLoad);
        imgLoad = findViewById(R.id.imgLoad);
        btnLoad.setOnClickListener(this);
    }

    public void onClick(View arg0){
        switch (arg0.getId()) {
            case R.id.btnLoad:
                new LoadImageTask(this,this).execute(IMAGE_URL);
                break;
        }
    }

    @Override
    public void onImageLoad(Bitmap bitmap) {
        imgLoad.setImageBitmap(bitmap);
        tvMessage.setText("Đã tải xong");
    }

    @Override
    public void onError() {
        tvMessage.setText("Lỗi");
    }
}
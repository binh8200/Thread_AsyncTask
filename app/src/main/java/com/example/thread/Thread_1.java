package com.example.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

public class Thread_1 extends AppCompatActivity implements View.OnClickListener {

    ImageView imgAndroid;
    TextView tvMess;
    Button btnLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_1);
        init();
        btnLoad.setOnClickListener(this);

    }

    public void init(){
        imgAndroid = findViewById(R.id.imgAnroid);
        tvMess = findViewById(R.id.tvMess);
        btnLoad = findViewById(R.id.btnLoad);
    }

    private Bitmap loadImageFromNetWork(String link) {
        URL url;
        Bitmap bmp = null;
        try {
            url = new URL(link);
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e){
            e.printStackTrace();
        }
        return bmp;
    }

    public void onClick(View v) {
        final Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap = loadImageFromNetWork("https://freeiconshop.com/wp-content/uploads/edd/android-flat.png");
                imgAndroid.post(new Runnable() {
                    @Override
                    public void run() {
                        tvMess.setText("Đã load xong");
                        imgAndroid.setImageBitmap(bitmap);
                    }
                });
            }

        });
        myThread.start();
    }
}
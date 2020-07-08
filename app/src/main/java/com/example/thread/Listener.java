package com.example.thread;

import android.graphics.Bitmap;

public interface Listener {
    void onImageLoad(Bitmap bitmap);
    void onError();
}

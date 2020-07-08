package com.example.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Thread_3 extends AppCompatActivity implements View.OnClickListener {

    EditText edTime;
    Button btnRun;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_3);
        edTime = findViewById(R.id.edtAsync);
        btnRun = findViewById(R.id.btnAsync);
        tvResult = findViewById(R.id.tvAsync);
        btnRun.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.btnAsync:
                AsyncTaskRunner asyncTaskRunner = new AsyncTaskRunner(this, tvResult, edTime);
                String sleeptime = edTime.getText().toString();
                asyncTaskRunner.execute(sleeptime);
                break;
        }
    }

}
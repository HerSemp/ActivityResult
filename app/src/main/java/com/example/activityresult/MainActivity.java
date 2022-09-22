package com.example.activityresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public TextView textview;
    public Button bt_send;

    int Code = 2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_send = findViewById(R.id.bt_send);
        textview = findViewById(R.id.textview);

    }

    @Override
    protected void onResume() {

        super.onResume();
        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);

                startActivityForResult(intent,Code);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "requestCode "+requestCode, Toast.LENGTH_SHORT).show();

        if (resultCode == RESULT_OK){
            if (requestCode == 2){
                String result = data.getStringExtra("message");

                textview.setText(result);
            }
        }
    }
}
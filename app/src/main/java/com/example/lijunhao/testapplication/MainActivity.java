package com.example.lijunhao.testapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread thread=new Thread(){
            @Override
            public void run(){
                try{
                    sleep(3000);
                    Intent intent=new Intent(getApplicationContext(),IndexActivity.class);
                    startActivity(intent);
                    finish();
            }catch (InterruptedException e){
                    e.printStackTrace();
            }
            }
        };
        thread.start();

//        Button b1=(Button) findViewById(R.id.btnLogin);
//        Button b2=(Button) findViewById(R.id.btnRegister);

//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                startActivity(intent);
//
//            }
//
//        });
//        b2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
//                startActivity(intent);
//
//            }
//
//        });
    }
}

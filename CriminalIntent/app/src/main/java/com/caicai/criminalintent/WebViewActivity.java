package com.caicai.criminalintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;



public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        final TextView threadTv = (TextView) findViewById(R.id.thread_tv);
        threadTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WebViewActivity.this,TestLaunchActivity.class);
                intent.putExtra("data","data");
                startActivityForResult(intent,924);
            }
        });


/*        new Thread(new Runnable() {
            @Override
            public void run() {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                }
                threadTv.setText("子线程更新ui");
            }
        }).start();*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 924 && resultCode == 817){
            String idol = data.getStringExtra("chenweiting");
            Log.e("caicai","success");
        }else if (resultCode == Activity.RESULT_CANCELED){
            String action = "系统取消传递";
            Log.e("caicai","cancel");
        }else {
            String idol = "";
            Log.e("caicai","failed");
        }
    }
}

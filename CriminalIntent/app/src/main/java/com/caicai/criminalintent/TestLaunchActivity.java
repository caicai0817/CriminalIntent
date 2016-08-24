package com.caicai.criminalintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class TestLaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_launch);
        Intent in = getIntent();
        String data = in.getStringExtra("data");
        Log.e("caicai","接收data");
        TextView launchMode = (TextView) findViewById(R.id.test_launch_tv);
        launchMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("chenweiting","idol");
                setResult(817, intent);
                Log.e("caicai", "back");
                finish();
            }
        });
    }

}

package com.caicai.criminalintent.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.caicai.criminalintent.R;

public class XmlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml);

        TextView xmlTv = (TextView) findViewById(R.id.xml_tv);
        xmlTv.append("xml");
        xmlTv.append("css");
        xmlTv.append("\njs");
    }

}

package com.caicai.criminalintent.fresco;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.caicai.criminalintent.R;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;

public class FrescoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco);
//        final Uri uri = Uri.parse("http://img1.126.net/channel12/024419/310220_0805.jpg");
        Uri uri = new Uri.Builder().scheme("res").path(String.valueOf(R.drawable.icon_home)).build();
        final SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        GenericDraweeHierarchy hierarchy = draweeView.getHierarchy();//获取hierachy
//        new PipelineDraweeController(this).
        draweeView.setImageURI(uri);
    }

}

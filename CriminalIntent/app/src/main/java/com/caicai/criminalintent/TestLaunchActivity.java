package com.caicai.criminalintent;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;
import android.widget.ListView;

import com.caicai.criminalintent.autolayout.ZhiboAdapter;
import com.caicai.criminalintent.autolayout.ZhiboListItemBean;
import com.caicai.criminalintent.sourcedesign.optimize.ImageCache;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class TestLaunchActivity extends AppCompatActivity {

    private String[] titles = new String[]{
            "辣条神似避孕套引离婚,无节操套套辣条竟引发夫妻离婚大战!", "今日头条创始人回应低俗质疑：从不主动push低俗内容", "网易我们就要见面了", "霾色幽默，北京将霾归入气象灾害就能根治雾霾吗？", "19岁大学生试图持刀闯入特朗普大楼被起诉", "普京：中俄政治互信水平非常高 两国有战略关系", "文化部：网络直播平台需许可证 主播实名注册", "怎么在excel2003中快速填充货币符号", "中国最早看到日出的城市，东方第一城", "外媒:中国正成为单身大国 超过36%女性不结婚", "媒体:一些官员躲着商人 好像离得越远自己越干净", "4名志愿者＂太空生存＂180天后出舱 将接受医学检查4名志愿者＂太空生存＂180天后出舱 将接受医学检查4名志愿者＂太空生存＂180天后出舱 将接受医学检查4名志愿者＂太空生存＂180天后出舱 将接受医学检查"
    };

    private List<ZhiboListItemBean> items = new ArrayList<>();

    private String[] datas = new String[]{/**, "百度再见", "阿里巴巴", "腾讯起航", "你好,三亚", "五八", "网易云音乐", "百度大厦食堂", "阿里巴巴", "腾讯游戏"*/
            "你好,少年", "五八", "网易我们就要见面了"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_launch);

        ImageView iv = (ImageView) findViewById(R.id.iv);
//        BitmapDrawable drawable = (BitmapDrawable) iv.getDrawable();
//
//        Bitmap bitmap = drawable.getBitmap();
//        int rowBytes = bitmap.getRowBytes();
//        int height = bitmap.getHeight();
//        long size = rowBytes * height;

        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;

        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(),R.mipmap.testimg1,options);
        iv.setImageBitmap(bitmap1);

        Log.e("caicai",bitmap1.getWidth() + "---" + bitmap1.getHeight());


//        Log.e("caicai","width" + bitmap.getWidth());
//        Log.e("caicai","heitht" + bitmap.getHeight());
//        Log.e("caicai",size/(1024*1024) + "");




//        ActivityManager systemService = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
//        int memoryClass = systemService.getMemoryClass();
//        int largeMemoryClass = systemService.getLargeMemoryClass();
//
//        Log.e("caicai",memoryClass + "---" + largeMemoryClass);

//        Runtime rt=Runtime.getRuntime();
//        long maxMemory=rt.maxMemory();
//        Log.e("caicai:",Long.toString(maxMemory/(1024*1024)));


//        initData();
//        initView();
        //initView0();
    }

    private void demo(){
        Set<SoftReference<Bitmap>> mReusableBitmaps;
        LruCache<String,BitmapDrawable> mMemoryCache;
    }

    /**
     * 初始化数据
     */
    private void initData() {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 50; i++) {
            ZhiboListItemBean bean = new ZhiboListItemBean();
            bean.title = titles[i % 12];
            bean.tag = datas;
            bean.seeCount = "100" + i;
            bean.zanCount = "50" + i;
            bean.picNum = i % 4;
            items.add(bean);
        }
    }

    private void initView() {
//        ListView lv = (ListView) findViewById(R.id.test_lv);
//        lv.setAdapter(new ZhiboAdapter(this, items));
        /*FlowLayout layout = (FlowLayout) findViewById(R.id.add_flowlayout);
        for (int i = 0; i < datas.length; i++) {
            TextView tv = new TextView(this);
            ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            tv.setLayoutParams(layoutParams);
            tv.setText(datas[i]);
            layout.addView(tv);
        }*/
    }

   /* private void initView0() {
        Intent in = getIntent();
        String data = in.getStringExtra("data");
        Log.e("caicai", "接收data");
        TextView launchMode = (TextView) findViewById(R.id.test_launch_tv);
        launchMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("chenweiting", "idol");
                setResult(817, intent);
                Log.e("caicai", "back");
                finish();
            }
        });
    }*/
}

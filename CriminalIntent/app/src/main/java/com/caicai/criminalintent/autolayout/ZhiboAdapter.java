package com.caicai.criminalintent.autolayout;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.caicai.criminalintent.R;

import java.util.List;

/**
 * @Author : caicai
 * @Time : 2016/10/24 13:00
 * @Description: 请用一句话描述
 */
public class ZhiboAdapter extends BaseAdapter {

    private static final int LIST_ITEM1 = 0;//没有图片
    private static final int LIST_ITEM2 = 1;//一张图片
    private static final int LIST_ITEM3 = 2;//三张图片
    private Context mContext;
    private List<ZhiboListItemBean> zhiboListItemBean;


    public ZhiboAdapter(Context context, List<ZhiboListItemBean> bean) {
        this.mContext = context;
        this.zhiboListItemBean = bean;
    }

    @Override
    public int getCount() {
        return zhiboListItemBean.size();
    }

    @Override
    public Object getItem(int position) {
        return zhiboListItemBean.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        int picNum = zhiboListItemBean.get(position).picNum;
        if (picNum > 2) {
            return LIST_ITEM3;
        } else if (picNum > 0 && picNum < 3) {
            return LIST_ITEM2;
        } else {
            return LIST_ITEM1;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = null;
        int itemViewType = getItemViewType(position);
        if (convertView == null) {
            switch (itemViewType) {
                case LIST_ITEM1:
                    v = newNoPicView();
                    break;
                case LIST_ITEM2:
                    v = newOnePicView();
                    break;
                case LIST_ITEM3:
                    v = newMultiPicView();
                    break;

            }
        } else {
            v = convertView;
        }

        switch (itemViewType) {
            case LIST_ITEM1:
                NoPicViewHolder noPicViewHolder = (NoPicViewHolder) v.getTag(R.integer.adapter_nopic_viewholder_key);
                setNoPicData(position, noPicViewHolder);
                break;
            case LIST_ITEM2:
                OnePicViewHolder onePicViewHolder = (OnePicViewHolder) v.getTag(R.integer.adapter_onepic_viewholder_key);
                setOnePicData(position, onePicViewHolder);
                break;
            case LIST_ITEM3:
                MultiPicViewHolder multiPicViewHolder = (MultiPicViewHolder) v.getTag(R.integer.adapter_multipic_viewholder_key);
                setMultiPicData(position, multiPicViewHolder);
                break;
        }

        return v;
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setMultiPicData(int position, final MultiPicViewHolder multiPicViewHolder) {
        ZhiboListItemBean zhiboListItemBean = this.zhiboListItemBean.get(position);
        setText(multiPicViewHolder.title, zhiboListItemBean.title);
        setText(multiPicViewHolder.thumb, zhiboListItemBean.zanCount);
        setText(multiPicViewHolder.browse, zhiboListItemBean.seeCount);
        multiPicViewHolder.tags.removeAllViews();
        for (String mTag : zhiboListItemBean.tag) {
            if (TextUtils.isEmpty(mTag)) {
                return;
            }

//            View containView = View.inflate(mContext, R.layout.zhibo_tg_tv, null);
//            TextView tv = (TextView) containView.findViewById(R.id.tv_tag);
            TextView tv = new TextView(mContext);
//            tv.setSingleLine();
//            tv.setEllipsize(TextUtils.TruncateAt.END);
            tv.setText(mTag);
            multiPicViewHolder.tags.addView(tv);
        }

    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setOnePicData(int position, final OnePicViewHolder onePicViewHolder) {
        ZhiboListItemBean zhiboListItemBean = this.zhiboListItemBean.get(position);
        setText(onePicViewHolder.title, zhiboListItemBean.title);

        setText(onePicViewHolder.thumb, zhiboListItemBean.zanCount);
        setText(onePicViewHolder.browse, zhiboListItemBean.seeCount);

        onePicViewHolder.tags.removeAllViews();
        for (String mTag : zhiboListItemBean.tag) {
            if (TextUtils.isEmpty(mTag)) {
                return;
            }

//            View containView = View.inflate(mContext, R.layout.zhibo_tg_tv, null);
//            TextView tv = (TextView) containView.findViewById(R.id.tv_tag);
            TextView tv = new TextView(mContext);
//            tv.setSingleLine();
//            tv.setEllipsize(TextUtils.TruncateAt.END);
            tv.setText(mTag);
            onePicViewHolder.tags.addView(tv);
        }
        /*onePicViewHolder.tags.getViewTreeObserver().addOnDrawListener(new ViewTreeObserver.OnDrawListener() {
            @Override
            public void onDraw() {
                onePicViewHolder.tags.getViewTreeObserver().removeOnDrawListener(this);
                setTags(onePicViewHolder.tags);
            }
        });*/
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setNoPicData(int position, final NoPicViewHolder noPicViewHolder) {
        ZhiboListItemBean zhiboListItemBean = this.zhiboListItemBean.get(position);
        setText(noPicViewHolder.title, zhiboListItemBean.title);

        setText(noPicViewHolder.thumb, zhiboListItemBean.zanCount);
        setText(noPicViewHolder.browse, zhiboListItemBean.seeCount);

        noPicViewHolder.tags.removeAllViews();
        for (String mTag : zhiboListItemBean.tag) {
            if (TextUtils.isEmpty(mTag)) {
                return;
            }

//            View containView = View.inflate(mContext, R.layout.zhibo_tg_tv, null);
//            TextView tv = (TextView) containView.findViewById(R.id.tv_tag);
            TextView tv = new TextView(mContext);
//            tv.setSingleLine();
//            tv.setEllipsize(TextUtils.TruncateAt.END);
            tv.setText(mTag);
            noPicViewHolder.tags.addView(tv);
        }

        /*noPicViewHolder.tags.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {

                noPicViewHolder.tags.getViewTreeObserver().removeOnScrollChangedListener(this);
                setTags(noPicViewHolder.tags);
            }
        });*/

    }

    private void setTags(LinearLayout container) {
        int measuredWidth = container.getMeasuredWidth();

        int childCount = container.getChildCount();
        int lineWidth = 0;
        boolean flag = true;
        for (int i = 0; i < childCount; i++) {
            View child = container.getChildAt(i);
            if (flag) {
                int childMeasureWidth = child.getMeasuredWidth();
                lineWidth += childMeasureWidth;
                if (lineWidth == measuredWidth) {
                    flag = false;
                    View lastChild = container.getChildAt(i - 1);
                    ((TextView) lastChild).setText("...");
                    child.setVisibility(View.GONE);
                }
            } else {
                child.setVisibility(View.GONE);
            }


        }
    }

    private void setText(TextView textView, String str) {
        if (!TextUtils.isEmpty(str)) {
            textView.setVisibility(View.VISIBLE);
            textView.setText(str);
        } else {
            textView.setVisibility(View.GONE);
        }
    }

    private View newNoPicView() {
        View v = View.inflate(mContext, R.layout.zhibo_item_nopic, null);
        NoPicViewHolder viewHolder = new NoPicViewHolder();
        viewHolder.noPicBg = (LinearLayout) v.findViewById(R.id.zhibo_no_pic_bg);
        viewHolder.title = (TextView) v.findViewById(R.id.tv_title);
        viewHolder.tags = (LinearLayout) v.findViewById(R.id.auto_tags);
        viewHolder.thumb = (TextView) v.findViewById(R.id.tv_zan);
        viewHolder.browse = (TextView) v.findViewById(R.id.tv_see);
        v.setTag(R.integer.adapter_nopic_viewholder_key, viewHolder);
        return v;
    }

    private View newOnePicView() {
        View v = View.inflate(mContext, R.layout.zhibo_item_pic, null);
        OnePicViewHolder viewHolder = new OnePicViewHolder();
        viewHolder.onePicBg = (LinearLayout) v.findViewById(R.id.zhibo_pic_bg);
        viewHolder.title = (TextView) v.findViewById(R.id.tv_title);
        viewHolder.tags = (LinearLayout) v.findViewById(R.id.auto_tags);
        viewHolder.thumb = (TextView) v.findViewById(R.id.tv_zan);
        viewHolder.browse = (TextView) v.findViewById(R.id.tv_see);
        v.setTag(R.integer.adapter_onepic_viewholder_key, viewHolder);
        return v;
    }

    private View newMultiPicView() {
        View v = View.inflate(mContext, R.layout.zhibo_item_pics, null);
        MultiPicViewHolder viewHolder = new MultiPicViewHolder();
        viewHolder.morePicBg = (LinearLayout) v.findViewById(R.id.zhibo_pics_bg);
        viewHolder.title = (TextView) v.findViewById(R.id.tv_title);
        viewHolder.tags = (LinearLayout) v.findViewById(R.id.auto_tags);
        viewHolder.thumb = (TextView) v.findViewById(R.id.tv_zan);
        viewHolder.browse = (TextView) v.findViewById(R.id.tv_see);
        v.setTag(R.integer.adapter_multipic_viewholder_key, viewHolder);
        return v;
    }

    class NoPicViewHolder { //无图
        LinearLayout noPicBg;
        TextView title;
        LinearLayout tags;
        TextView thumb;
        TextView browse;

    }

    class OnePicViewHolder { //一张
        LinearLayout onePicBg;
        TextView title;
        LinearLayout tags;
        TextView thumb;
        TextView browse;
    }

    class MultiPicViewHolder { //三张
        LinearLayout morePicBg;
        TextView title;
        LinearLayout tags;
        TextView thumb;
        TextView browse;
    }

}

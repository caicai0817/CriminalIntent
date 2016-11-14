package com.caicai.criminalintent.art;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Author : caicai
 * @Time : 2016/11/8 16:15
 * @Description: 请用一句话描述
 */
public class ParcelBean implements Parcelable{

    private int mData;

    /** 从序列化后的对象中创建原始对象 */
    protected ParcelBean(Parcel in) {
        mData = in.readInt();
    }

    public static final Creator<ParcelBean> CREATOR = new Creator<ParcelBean>() {
        /** 从序列化后的对象中创建原始对象 */
        @Override
        public ParcelBean createFromParcel(Parcel in) {
            return new ParcelBean(in);
        }
        /** 创建指定长度的原始对象数组 */
        @Override
        public ParcelBean[] newArray(int size) {
            return new ParcelBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }
    /** 将当前对象写入序列化结构中 */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mData);
    }
}

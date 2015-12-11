package com.caicai.criminalintent;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Created by caicai on 2015/12/8 12:09.
 * 模型层代码
 */
public class Criminal implements Serializable{
    private UUID mId;
    private String mTitle;
    private Date mData;
    private boolean isSolved;

    public String getmData() {
        return utils.getFormatDate(mData);
    }

    public void setIsSolved(boolean isSolved) {
        this.isSolved = isSolved;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public Criminal() {
        //生成唯一标识
        mId = UUID.randomUUID();
        mData = new Date();
    }

    public UUID getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    @Override
    public String toString() {
        return mTitle;
    }
}

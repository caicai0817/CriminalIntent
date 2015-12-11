package com.caicai.criminalintent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Author : caicai
 * Time : 2015/12/9 17:57
 * Description:工具类
 */
public class utils {

    public static final String CAICAI = "caicai";
    public static String getFormatDate(Date date) {

        String formatString = "EEEE, MMM dd, yyyy";

        String formatDate = new SimpleDateFormat(formatString, Locale.ENGLISH).format(date);
        return formatDate;
    }
}

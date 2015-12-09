package com.caicai.criminalintent;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author : caicai
 * Time : 2015/12/9 17:57
 * Description:工具类
 */
public class utils {
    public static String getFormatDate(Date date){

        String formatDate = new SimpleDateFormat("").format(date);
        return formatDate;
    }
}

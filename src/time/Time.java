package time;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.*;

public class Time {
    private static Time ins;
    private static String[] weekday = {"天","一","二","三","四","五","六"};


    private Time(){}
    public static Time getIns(){
        if(ins==null) ins = new Time();
        return ins;
    }
    public String getTime(){
        Date now = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("YYYY年MM月dd日 HH时mm分ss秒");
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY年MM月dd日 星期");
        int wd = now.getDay();
        return sdf.format(now)+weekday[wd];

    }
}

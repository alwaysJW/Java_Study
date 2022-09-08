package com.pas.domain;

import lombok.Data;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Data
public class Car {
    private int id;
    private String name;
    private String carimge;
    private Timestamp intime;
    private Timestamp outtime;
    private String car;
    private String tele;

    public String getInTimes(){
        //1.格式化日期对象
        if (intime!=null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(intime);
        }return null;
    }
    public String getOutTimes(){
        //1.格式化日期对象
        if (outtime!=null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(outtime);
        }return null;
    }
}

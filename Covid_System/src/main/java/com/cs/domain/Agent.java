package com.cs.domain;

import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Data
public class Agent {
    private int id;
    private String name;
    private String things;
    private String neighbor;
    private Timestamp time;
    private String tele;

    public String getTimes(){
        //1.格式化日期对象
        if (time!=null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(time);
        }return null;
    }
}

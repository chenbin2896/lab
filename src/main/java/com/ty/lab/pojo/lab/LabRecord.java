package com.ty.lab.pojo.lab;

/**
 * @Classname LabRecord
 * @Description TODO
 * @Date 2019/8/10 0010
 * @Created by Administrator
 * @Version 1.0
 */
public class LabRecord {

    /**
     * 姓名
     */
    private String name;

    /**
     * 日期
     */
    private String date;

    /**
     * 时间段
     */
    private String time;

    /**
     * 实验室
     */
    private String labName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }
}

package model;

import java.io.Serializable;

public class Course implements Serializable {

    private int cid;		// 课程标记id
    private String coursename; //课程名
    private String teacher;		// 教师
    protected int weekfrom;	// 起始周
    protected int weekto;		// 结束周
    protected int weektype;	// 周类型：1普通；2单周；3双周
    protected int day;			// 星期几上课
    protected int lessonfrom;	// 开始节次
    protected int lessonto;	// 结束节次
    protected String place;	//地点
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getWeekfrom() {
        return weekfrom;
    }

    public void setWeekfrom(int weekfrom) {
        this.weekfrom = weekfrom;
    }

    public int getWeekto() {
        return weekto;
    }

    public void setWeekto(int weekto) {
        this.weekto = weekto;
    }

    public int getWeektype() {
        return weektype;
    }

    public void setWeektype(int weektype) {
        this.weektype = weektype;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getLessonfrom() {
        return lessonfrom;
    }

    public void setLessonfrom(int lessonfrom) {
        this.lessonfrom = lessonfrom;
    }

    public int getLessonto() {
        return lessonto;
    }

    public void setLessonto(int lessonto) {
        this.lessonto = lessonto;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }


}

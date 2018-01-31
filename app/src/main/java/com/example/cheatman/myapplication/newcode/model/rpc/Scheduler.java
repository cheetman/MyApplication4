package com.example.cheatman.myapplication.newcode.model.rpc;

/**
 * Created by Cheatman on 2018/1/29.
 */

public class Scheduler {

    public Scheduler() {

    }


    //	private String no;
    private int schTaskId;
    private String schTaskName;
    private int schStatus;//0: disable; 1: enable; 3: modified; 4: deleted
    //	private String type;
//	private String label;
    private boolean mon;
    private boolean tue;
    private boolean wed;
    private boolean thu;
    private boolean fri;
    private boolean sat;
    private boolean sun;
    private int hour;
    private int min;
    //	private String option;
    private int schTaskStatus;
    private AppScene scene;

    private boolean isExpand; //添加 true:展开，false：为关闭

    public boolean isMon() {
        return mon;
    }

    public void setMon(boolean mon) {
        this.mon = mon;
    }

    public boolean isTue() {
        return tue;
    }

    public void setTue(boolean tue) {
        this.tue = tue;
    }

    public boolean isWed() {
        return wed;
    }

    public void setWed(boolean wed) {
        this.wed = wed;
    }

    public boolean isThu() {
        return thu;
    }

    public void setThu(boolean thu) {
        this.thu = thu;
    }

    public boolean isFri() {
        return fri;
    }

    public void setFri(boolean fri) {
        this.fri = fri;
    }

    public boolean isSat() {
        return sat;
    }

    public void setSat(boolean sat) {
        this.sat = sat;
    }

    public boolean isSun() {
        return sun;
    }

    public void setSun(boolean sun) {
        this.sun = sun;
    }


//	public String getNo() {
//		return no;
//	}
//
//	public void setNo(String no) {
//		this.no = no;
//	}

//	public String getType() {
//		return type;
//	}
//
//	public void setType(String type) {
//		this.type = type;
//	}

//	public String getLabel() {
//		return label;
//	}
//
//	public void setLabel(String label) {
//		this.label = label;
//	}

//
//	public String getOption() {
//		return option;
//	}
//
//	public void setOption(String option) {
//		this.option = option;
//	}


    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean isExpand) {
        this.isExpand = isExpand;
    }

    public int getSchTaskId() {
        return schTaskId;
    }

    public void setSchTaskId(int schTaskId) {
        this.schTaskId = schTaskId;
    }

    public int getSchStatus() {
        return schStatus;
    }

    public void setSchStatus(int schStatus) {
        this.schStatus = schStatus;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public AppScene getScene() {
        return scene;
    }

    public void setScene(AppScene scene) {
        this.scene = scene;
    }

    public String getSchTaskName() {
        return schTaskName;
    }

    public void setSchTaskName(String schTaskName) {
        this.schTaskName = schTaskName;
    }

    public int getSchTaskStatus() {
        return schTaskStatus;
    }

    public void setSchTaskStatus(int schTaskStatus) {
        this.schTaskStatus = schTaskStatus;
    }
}

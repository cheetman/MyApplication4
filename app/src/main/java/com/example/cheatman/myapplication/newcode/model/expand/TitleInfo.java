package com.example.cheatman.myapplication.newcode.model.expand;

/**
 * Created by Cheatman on 2017/12/11.
 */

/**
 * 折叠List用
 */
public class TitleInfo {
    private String id;
    private String name;

    private boolean expanded;


    public TitleInfo(String id, String name,boolean expanded) {
        this.id = id;
        this.name = name;
        this.expanded = expanded;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

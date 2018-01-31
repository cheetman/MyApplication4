package com.example.cheatman.myapplication.newcode.model.rpc;

import java.util.jar.Attributes;

/**
 * Created by Cheatman on 2018/1/29.
 */

public class CustFunc {
    public CustFunc(){

    }

    public CustFunc(Attributes atts){
        this.setFuncId(atts.getValue("FuncId"));
        this.setName(atts.getValue("name"));
    }

    private String funcId;
    private String name;

    public String getFuncId() {
        return funcId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

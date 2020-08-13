package com.example.test.bean;

public class CommonResult {
    Integer status;
    String msg;
    Object data;

    public CommonResult(Integer i, String s, Object o) {
        this.status=i;
        this.msg=s;
        this.data=0;
    }
}

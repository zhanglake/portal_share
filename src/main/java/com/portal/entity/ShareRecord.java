package com.portal.entity;

/**
 * Created by zhenghua.zhang on 2017/9/21.
 */
public class ShareRecord {
    // id
    private Long id;
    // 日期
    private String resultDate;
    // 当前价
    private String resultNow;
    // 开盘价
    private String resultOpen;
    // 涨停
    private String resultUp;
    // 跌停
    private String resultDown;

    public void setId(Long id) {
        this.id = id;
    }

    public void setResultDate(String resultDate) {
        this.resultDate = resultDate;
    }

    public void setResultNow(String resultNow) {
        this.resultNow = resultNow;
    }

    public void setResultOpen(String resultOpen) {
        this.resultOpen = resultOpen;
    }

    public void setResultUp(String resultUp) {
        this.resultUp = resultUp;
    }

    public void setResultDown(String resultDown) {
        this.resultDown = resultDown;
    }

    public Long getId() {

        return id;
    }

    public String getResultDate() {
        return resultDate;
    }

    public String getResultNow() {
        return resultNow;
    }

    public String getResultOpen() {
        return resultOpen;
    }

    public String getResultUp() {
        return resultUp;
    }

    public String getResultDown() {
        return resultDown;
    }
}

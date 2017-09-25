package com.portal.dto;

/**
 * Created by zhenghua.zhang on 2017/9/19.
 */
public class ShareInsertDto {
    private String resultDate;
    private String resultNow;
    private String resultOpen;
    private String resultUp;
    private String resultDown;

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

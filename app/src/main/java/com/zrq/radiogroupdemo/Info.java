package com.zrq.radiogroupdemo;

public class Info {
    private String title;
    private String detail;
    private int img;

    public Info(String title, String detail, int img) {
        this.title = title;
        this.detail = detail;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

}

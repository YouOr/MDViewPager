package com.Liufeng.MyViewPager.model;

/**
 * Created by Administrator on 2017/5/25.
 */
public class Mcontact {
    //昵称
    private String nickName;
    //首字母,排序
    private String headerletter;

    public Mcontact() {
    }

    public Mcontact(String nickName, String headerletter) {
        this.nickName = nickName;
        this.headerletter = headerletter;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeaderletter() {
        return headerletter;
    }

    public void setHeaderletter(String headerletter) {
        this.headerletter = headerletter;
    }
}

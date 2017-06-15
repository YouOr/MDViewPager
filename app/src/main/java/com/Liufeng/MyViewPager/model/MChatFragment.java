package com.Liufeng.MyViewPager.model;

/**
 * Created by Administrator on 2017/5/24.
 */
public class MChatFragment {

    private String imgUrl;
    private String nickName;
    private String timeOut;
    private String context;

    public MChatFragment() {
    }

    public MChatFragment(String imgUrl, String nickName, String timeOut,String context) {
        this.imgUrl = imgUrl;
        this.nickName = nickName;
        this.timeOut = timeOut;
        this.context=context;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }
    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

}

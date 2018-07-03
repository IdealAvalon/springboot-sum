package com.zhangdq.springbootsum.pojo;

/**
 * @author: zhangdq
 * @Description:
 * @Date: Create in 12:34 2018/6/14
 */
public class Picture {

    private String id;
    private String pictureSrc;
    private String user;
    private String title;
    private String describe;
    private String count;
    private String protoUser;
    private String isOrigin;

    public Picture() {
    }

    public Picture(String id, String pictureSrc, String user, String title, String describe, String count, String protoUser, String isOrigin) {
        this.id = id;
        this.pictureSrc = pictureSrc;
        this.user = user;
        this.title = title;
        this.describe = describe;
        this.count = count;
        this.protoUser = protoUser;
        this.isOrigin = isOrigin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPictureSrc() {
        return pictureSrc;
    }

    public void setPictureSrc(String pictureSrc) {
        this.pictureSrc = pictureSrc;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getProtoUser() {
        return protoUser;
    }

    public void setProtoUser(String protoUser) {
        this.protoUser = protoUser;
    }

    public String getIsOrigin() {
        return isOrigin;
    }

    public void setIsOrigin(String isOrigin) {
        this.isOrigin = isOrigin;
    }

}

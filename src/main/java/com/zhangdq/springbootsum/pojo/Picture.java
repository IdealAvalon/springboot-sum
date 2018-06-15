package com.zhangdq.springbootsum.pojo;

/**
 * @author: zhangdq
 * @Description:
 * @Date: Create in 12:34 2018/6/14
 */
public class Picture {

    String title;
    String preview;
    String introduce;

    public Picture(String title, String introduce, String preview) {
        this.title = title;
        this.preview = preview;
        this.introduce = introduce;

    }



    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

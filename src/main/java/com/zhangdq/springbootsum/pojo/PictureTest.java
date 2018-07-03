package com.zhangdq.springbootsum.pojo;

import java.io.Serializable;

/**
 * @author: zhangdq
 * @Description:
 * @Date: Create in 17:01 2018/7/3
 */
public class PictureTest implements Serializable{
    private String title;
    private String preview;

    public PictureTest(String title, String preview) {
        this.title = title;
        this.preview = preview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }
}

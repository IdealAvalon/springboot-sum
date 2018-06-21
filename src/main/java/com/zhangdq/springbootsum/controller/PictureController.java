package com.zhangdq.springbootsum.controller;

import com.zhangdq.springbootsum.pojo.FastDFSFile;
import com.zhangdq.springbootsum.pojo.Picture;
import com.zhangdq.springbootsum.utils.FastDFSClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangdq
 * @Description:
 * @Date: Create in 12:31 2018/6/14
 */
@RestController
public class PictureController {
    private static final Logger logger = LoggerFactory.getLogger(PictureController.class);

    @RequestMapping("/pictures")
    public List<Picture> loadPictures(Model model){

        List<Picture> list = new ArrayList<>();
        for (int i=0;i<20;i++) {
            list.add(new Picture("aa", "zheshi " + i, "/assets/images/" + i + ".jpg"));
        }
        model.addAttribute("data",list);
        return list;
    }

    @PostMapping("/picture")
    public String upload(){

        return
    }

}

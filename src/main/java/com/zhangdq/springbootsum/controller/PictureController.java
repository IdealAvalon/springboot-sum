package com.zhangdq.springbootsum.controller;

import com.zhangdq.springbootsum.pojo.Picture;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangdq
 * @Description:
 * @Date: Create in 12:31 2018/6/14
 */
@RestController
public class PictureController {

    @RequestMapping("/pictures")
    public List<Picture> loadPictures(Model model){

        List<Picture> list = new ArrayList<>();
        for (int i=0;i<20;i++) {
            list.add(new Picture("aa", "zheshi " + i, "/assets/images/" + i + ".jpg"));
        }
        model.addAttribute("data",list);
        return list;
    }
}

package com.zhangdq.springbootsum.controller;

import com.zhangdq.springbootsum.mapper.PictureMapper;
import com.zhangdq.springbootsum.pojo.Picture;
import com.zhangdq.springbootsum.pojo.PictureTest;
import com.zhangdq.springbootsum.utils.FastDFSClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zhangdq
 * @Description:
 * @Date: Create in 12:31 2018/6/14
 */
@Controller
public class PictureController {
    private static final Logger logger = LoggerFactory.getLogger(PictureController.class);

    @Autowired
    PictureMapper pictureMapper;
    /**
     * 首页获取图片
     * @param model
     * @return
     */
    @RequestMapping("/pictures")
    @ResponseBody
    public List<Picture> loadPictures(Model model) {

        List<Picture> pictures = pictureMapper.getPictures();

        model.addAttribute("data", pictures);
        return pictures;

    }

    /**
     * 跳转到图片上传
     * @return
     */
    @GetMapping("/toPictureUpload")
    public String toUpload() {
        return "user-center/publish/upload";
    }

    /**
     * 图片上传
     */
    @Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;

    @PostMapping(value = "/picture", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResponseBody
    public String upload(MultipartFile uploadFile) {
        try {
            //接收上传的文件
            byte[] content = uploadFile.getBytes();
            //取文件的扩展名
            String originalFilename = uploadFile.getOriginalFilename();
            String ext = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            //把文件内容上传到图片服务器。
            FastDFSClient fastDFSClient = new FastDFSClient("fdfs_client.conf");
            String url = fastDFSClient.uploadFile(content, ext);
            //从配置文件中取图片服务器的url
            //创建返回结果对象
            Map result = new HashMap<>();
            result.put("error", 0);
            result.put("url", IMAGE_SERVER_URL + url);
            System.out.println(IMAGE_SERVER_URL + url);

            Picture picture = new Picture();
            picture.setPictureSrc(IMAGE_SERVER_URL + url);
            pictureMapper.insertPicture(picture);
            //返回结果
            return "user-center/publish/home";
        } catch (Exception e) {
            e.printStackTrace();
            Map result = new HashMap<>();
            result.put("error", 1);
            result.put("message", "图片上传失败");
            return "user-center/publish/home";
        }
    }


}

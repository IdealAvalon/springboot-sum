package com.zhangdq.springbootsum.mapper;

import com.zhangdq.springbootsum.pojo.Picture;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: zhangdq
 * @Description:
 * @Date: Create in 15:34 2018/7/3
 */
public interface PictureMapper {
    /**
     * 获取所有图片
     * @return
     */
    @Select("select * from picture")
    public List<Picture> getPictures();

    /**
     * 保存图片信息
     */
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into picture(picture_src,user,title,`describe`,count,proto_user,is_origin) values(#{pictureSrc},#{user},#{title},#{describe},#{count},#{protoUser},#{isOrigin})")
    public int insertPicture(Picture picture);

}

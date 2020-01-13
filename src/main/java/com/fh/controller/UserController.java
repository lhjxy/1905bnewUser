package com.fh.controller;

import com.fh.bean.User;
import com.fh.service.UserService;
import com.fh.uitl.PageBean;
import com.fh.uitl.xiazai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("toImgPath")
    public Map<String,Object> toImgPath(@RequestParam("userPhoto") MultipartFile img, HttpServletRequest request){
        Map map=new HashMap();
        //保存文件 的名称 需要重命名
        //获取上传文件的名称
        String originalFilename = img.getOriginalFilename();
        //获取格式
        String fileType=originalFilename.substring(originalFilename.lastIndexOf("."));
        //重命名 文件名必须保证唯一
        String newFileName= UUID.randomUUID().toString()+fileType;
        //拷贝
        try {
            InputStream is = img.getInputStream();
            String imgPath = xiazai.uploadImg(is, "lhj/imgs/" + newFileName);
            map.put("code",200);
            map.put("imgPat",imgPath);
        } catch (IOException e) {
            e.printStackTrace();
            map.put("code",201);
            map.put("info",e.getMessage());
        }
        return map;
    }

    @RequestMapping("addUserList")
    public User addUserList(User user,HttpServletRequest request){
        user.setIsDel(1);
        String remoteAddr = request.getRemoteAddr();
        user.setIpaaaa(remoteAddr);
        userService.addUserList(user);
        return user;
    }

    @RequestMapping("queryUserList")
    public PageBean<User> queryUserList(PageBean<User> page){
        userService.queryUserList(page);
        return page;
    }

    @RequestMapping("queryUserById")
    public User queryUserById(Integer id){
        User user=userService.queryUserById(id);
        return user;
    }

    @RequestMapping("updateUserList")
    public User updateUserList(User user){
        userService.updateUserList(user);
        return user;
    }

    @RequestMapping("deleteUser")
    public User deleteUser(Integer id){
        User user=userService.queryUserById(id);
        user.setIsDel(0);
        userService.deleteUser(user);
        return user;
    }
}

package com.fh.controller;

import com.fh.bean.User;
import com.fh.service.UserService;
import com.fh.uitl.ExceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@CrossOrigin
public class aaaaaaa {

    @Autowired
    private UserService userService;
    // 导出excel
    @RequestMapping("getExcel")
    public void getExcel(HttpServletResponse response){
        List<User> list=userService.getquerylist();
        ExceUtil.exceleUtil(list,response);

    }
}

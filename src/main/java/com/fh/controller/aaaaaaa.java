package com.fh.controller;

import com.fh.bean.User;
import com.fh.common.Excel;
import com.fh.service.UserService;
import com.fh.uitl.ExceUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin
public class aaaaaaa {
    @Autowired
    private UserService userService;
    // 导出excel
    @RequestMapping("getExcel")
    public void getExcel(HttpServletResponse response, XSSFWorkbook book){

        List<User> list=userService.getquerylist();
        Class<User> studentClass = User.class;
        Field[] fields  = studentClass.getDeclaredFields();
        List<String> li=new ArrayList<>();
        List<String> st=new ArrayList<>();
        for(Field field : fields){
            Excel annotation = field.getAnnotation(Excel.class);
            if(annotation!=null){
                li.add(annotation.value());
                st.add(annotation.name());
            }
        }
        ExceUtil.exceleUtil(list,st,li,response,book);

    }
}

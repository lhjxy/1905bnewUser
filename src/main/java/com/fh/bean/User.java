package com.fh.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fh.common.Excel;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@TableName("user")
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField("name")
    @Excel(name="学生姓名",value = "name")
    private String name;
    @TableField("age")
    @Excel(name="学生年龄",value = "age")
    private Integer age;
    @Excel(name="学生生日",value = "birthday")
    @TableField("birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @TableField("address")
    private String address;
    @TableField("imgPath")
    private String imgPath;
    @TableField("isDel")
    private Integer isDel;
    @TableField("ipaaaa")
    private String ipaaaa;

    public String getIpaaaa() {
        return ipaaaa;
    }

    public void setIpaaaa(String ipaaaa) {
        this.ipaaaa = ipaaaa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}

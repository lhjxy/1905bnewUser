package com.fh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.bean.User;
import com.fh.uitl.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao extends BaseMapper<User> {
    long queryUserCount();

    List<User> queryUserList(@Param("page") PageBean<User> page);

}

package com.fh.service;

import com.fh.bean.User;
import com.fh.uitl.PageBean;

import java.util.List;

public interface UserService {
    void addUserList(User user);

    void queryUserList(PageBean<User> page);

    User queryUserById(Integer id);

    void updateUserList(User user);

    void deleteUser(User user);

    List<User> getquerylist();
}

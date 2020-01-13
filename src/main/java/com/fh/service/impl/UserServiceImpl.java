package com.fh.service.impl;

import com.fh.bean.User;
import com.fh.dao.UserDao;
import com.fh.service.UserService;
import com.fh.uitl.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public void addUserList(User user) {
        userDao.insert(user);
    }

    @Override
    public void queryUserList(PageBean<User> page) {
        long count=userDao.queryUserCount();
        page.setRecordsFiltered(count);
        page.setRecordsTotal(count);
        List<User> list=userDao.queryUserList(page);
        page.setData(list);
    }

    @Override
    public User queryUserById(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public void updateUserList(User user) {
        userDao.updateById(user);
    }

    @Override
    public void deleteUser(User user) {
         userDao.updateById(user);
    }
}

package com.tang.bos.service;

import com.tang.bos.dao.UserDao;
import com.tang.bos.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tang on 17-5-17.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    public User login(String username, String pwd) {
        User user = userDao.findByNameAndPwd(username, pwd);
        return user;
    }

    public boolean updatePwd(String password,User user){
        User u2 = userDao.findByNameAndPwd(user.getUsername(), user.getPassword());
        int count = 0;
        try{
            count=userDao.updatePassword(password, u2.getId());
        }catch (Exception e){
            e.printStackTrace();
        }

       if(count>0) return true;
        else return false;
    }
}
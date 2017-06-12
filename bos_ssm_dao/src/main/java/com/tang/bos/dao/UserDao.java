package com.tang.bos.dao;

import com.tang.bos.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by tang on 17-5-17.
 */
@Repository
public interface UserDao {

    User findByNameAndPwd(@Param("username") String username, @Param("password") String password);

    int updatePassword(@Param("password") String password,@Param("id") int id);

    User findByName(String username);
}

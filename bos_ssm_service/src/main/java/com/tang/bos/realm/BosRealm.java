package com.tang.bos.realm;

import com.tang.bos.dao.UserDao;
import com.tang.bos.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tang on 17-6-13.
 */
@Component
public class BosRealm extends AuthorizingRealm{

    @Autowired
    private UserDao userDao;

    //授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("staff-list");
        User user1= (User) SecurityUtils.getSubject().getPrincipal();
        User user2= (User) principalCollection.getPrimaryPrincipal();
        System.out.println(user1.equals(user2));
        return info;
    }

    //认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo
    (AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upt= (UsernamePasswordToken) token;
        String username = upt.getUsername();
        User user = userDao.findByName(username);
        if (user==null){
            return null;
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo
                (user, user.getPassword(), this.getName());
        return info;
    }
}

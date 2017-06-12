package com.tang.bos.web.controller;

import com.tang.bos.entity.User;
import com.tang.bos.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by tang on 17-5-17.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String login(User user, HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        String password = user.getPassword();
        String username = user.getUsername();
        if (password!=null&&username!=null&username!=""&&password!=""){
            UsernamePasswordToken token =
                    new UsernamePasswordToken(user.getUsername(), user.getPassword());
            try {
                subject.login(token);
            }catch (Exception e){
                e.printStackTrace();
                return "/login";
            }

            User user2= (User) subject.getPrincipal();
            session.setAttribute("user",user2);
        }
        return "/WEB-INF/views/common/index";
    }

    @RequestMapping("/user/updatePwd")
    public void updatePwd(@RequestParam String password,
                          HttpSession session, HttpServletResponse response){
        String result="0";
        response.setContentType("text/html;charset=utf-8");
        User user= (User) session.getAttribute("user");
        if (user!=null){
            boolean b = userService.updatePwd(password, user);
            if(b) result="1";
        }
        try(PrintWriter w=response.getWriter()){
            w.write(result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        session.setAttribute("user",null);
        return "/login";
    }
}






















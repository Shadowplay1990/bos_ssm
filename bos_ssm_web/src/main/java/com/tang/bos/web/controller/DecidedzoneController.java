package com.tang.bos.web.controller;

import com.tang.bos.entity.Decidedzone;
import com.tang.bos.service.DecidedzoneService;
import com.tang.bos.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tang on 17-5-20.
 */
@Controller
@RequestMapping("/dz/")
public class DecidedzoneController extends BaseController<Decidedzone>{

    @RequestMapping("show")
    public String show(){
        return "/WEB-INF/views/base/decidedzone";
    }
    @Autowired
    private DecidedzoneService service;

    @ResponseBody
    @RequestMapping("pageQuery")
    public Page<Decidedzone> pageQuery(@RequestParam int page,@RequestParam int rows){
        pageBean.setCount(rows);
        pageBean.setCurrentPage(page);
        Page<Decidedzone> page2 = service.findByPage(pageBean);
        return page2;
    }
}

package com.tang.bos.web.controller;

import com.tang.bos.entity.Function;
import com.tang.bos.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by tang on 17-6-13.
 */
@Controller
@RequestMapping("/function/")
public class FunctionController extends BaseController<Function>{

    @Autowired
    private FunctionService functionService;

    @RequestMapping("findParents")
    @ResponseBody
    public List<Function> findParents(){
        List<Function> allParents = functionService.findAllParents();
        return allParents;
    }

    @ResponseBody
    @RequestMapping("findMenus")
    public List<Function> findMenus(){
        return functionService.findMenus();
    }

}

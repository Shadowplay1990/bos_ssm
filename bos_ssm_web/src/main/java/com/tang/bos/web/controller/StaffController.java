package com.tang.bos.web.controller;

import com.tang.bos.entity.Staff;
import com.tang.bos.service.StaffService;
import com.tang.bos.utils.Page;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tang on 17-5-18.
 */
@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;
    @Autowired
    private Page<Staff> pageBean;
    @RequestMapping("/show")
    public String show(){
        return "/WEB-INF/views/base/staff";
    }

    @ResponseBody
    @RequestMapping("/byPage")
    public List<Staff> byPage(@RequestParam int page,@RequestParam int rows){
        pageBean.setCurrentPage(page);
        pageBean.setCount(rows);
        List<Staff> list = staffService.findByPage(pageBean);
        return list;
    }

    @RequestMapping(value = "/addStaff",method = RequestMethod.POST)
    public String addStaff(Staff staff){
        staff.setDeltag("0");
        staffService.addStaff(staff);
        return "/WEB-INF/views/base/staff";
    }


    @RequestMapping("/batchDel/{ids}")
    @RequiresPermissions("del-staff")
    public String batchDel(@PathVariable String ids){
        String[] idArray = ids.split(",");
        staffService.batchDel(idArray);
        return "/WEB-INF/views/base/staff";
    }

    @RequestMapping("/editStaff")
    public String editStaff(Staff staff){
        staffService.updateStaff(staff);
        return "/WEB-INF/views/base/staff";
    }

}

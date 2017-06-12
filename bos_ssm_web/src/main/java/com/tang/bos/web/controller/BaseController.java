package com.tang.bos.web.controller;

import com.tang.bos.entity.Staff;
import com.tang.bos.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tang on 17-5-19.
 */
public class BaseController<T>{
    @Autowired
    protected Page<T> pageBean;
}

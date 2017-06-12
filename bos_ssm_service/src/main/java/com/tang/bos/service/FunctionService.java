package com.tang.bos.service;

import com.tang.bos.dao.FunctionDao;
import com.tang.bos.entity.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tang on 17-6-13.
 */
@Service
@Transactional
public class FunctionService {

    @Autowired
    private FunctionDao functionDao;

    public List<Function> findAllParents(){
        return functionDao.findAllParents();
    }

    public List<Function> findMenus(){
        return functionDao.findMenus();
    }
}

package com.tang.bos.service;

import com.tang.bos.dao.DecidedzoneDao;
import com.tang.bos.entity.Decidedzone;
import com.tang.bos.utils.Page;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tang on 17-5-20.
 */
@Service
@Transactional
public class DecidedzoneService {

    @Autowired
    private DecidedzoneDao dao;

    public Page<Decidedzone> findByPage(Page<Decidedzone> page){

        int offset=(page.getCurrentPage()-1)*page.getCount();
        List<Decidedzone> list = dao.findPage(new RowBounds(offset, page.getCount()));
        page.setRows(list);

        page.setTotal(dao.findTotal());
        return page;
    }
}























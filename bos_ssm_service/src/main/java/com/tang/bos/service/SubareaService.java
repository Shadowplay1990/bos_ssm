package com.tang.bos.service;

import com.tang.bos.dao.SubareaDao;
import com.tang.bos.entity.Subarea;
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
public class SubareaService {

    @Autowired
    private SubareaDao dao;

    public Page<Subarea> pageQuery(Page<Subarea> page,Subarea subarea){
        int count = dao.findCount();
        page.setTotal(count);
        int offset=(page.getCurrentPage()-1)*page.getCount();
        List<Subarea> list=null;
        if(subarea.getRegion()!=null||subarea.getAddresskey()!=null){
             list= dao.findPage(new RowBounds(offset, page.getCount()),subarea);
        }else{
             list=dao.findByPage(new RowBounds(offset, page.getCount()));
        }
        page.setRows(list);
        return page;
    }

    public boolean addSub(Subarea subarea){
        int result=0;
        result=dao.addSub(subarea);
        if(result>0) return true;
        else return false;
    }

    public void updateB(Subarea subarea,String ids){
        String[] strs = ids.split(",");
        for(String idStr:strs){
            int id=Integer.valueOf(idStr);
            dao.editSub(subarea,id);
        }
    }

    public void delB(String ids){
        String[] strs = ids.split(",");
        for(String aid:strs){
            int id=Integer.valueOf(aid);
            dao.del(id);
        }
    }

    public List<Subarea> findAll(){
        return dao.findAll();
    }
}

























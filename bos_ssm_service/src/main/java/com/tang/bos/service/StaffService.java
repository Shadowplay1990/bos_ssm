package com.tang.bos.service;

import com.tang.bos.dao.StaffDao;
import com.tang.bos.entity.Staff;
import com.tang.bos.utils.Page;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tang on 17-5-18.
 */
@Service
@Transactional
public class StaffService {

    @Autowired
    private StaffDao staffDao;

    public List<Staff> findByPage(Page<Staff> page){
        int offset=(page.getCurrentPage()-1)*page.getCount();
        RowBounds rowBounds = new RowBounds(offset, page.getCount());
        List<Staff> list =null;
        try{
            list=staffDao.findByPage(rowBounds);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public boolean addStaff(Staff staff){
        int result=0;
        try{
            result=staffDao.addStaff(staff);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(result>0) return true;
        else return false;
    }

    public boolean batchDel(String[] ids){
        if(ids.length>0&&ids!=null){
            for(String id:ids){
                int idInt=Integer.valueOf(id);
                int count = staffDao.deleteById(idInt);
                if(count>0) return true;
                else return false;
            }
        }
        return false;
    }

    public void updateStaff(Staff staff){
        staffDao.updateStaff(staff);
    }

}

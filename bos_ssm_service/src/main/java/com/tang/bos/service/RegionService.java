package com.tang.bos.service;

import com.tang.bos.dao.RegionDao;
import com.tang.bos.entity.Region;
import com.tang.bos.utils.Page;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tang on 17-5-19.
 */
@Service
@Transactional
public class RegionService {

    @Autowired
    private RegionDao regionDao;

    public List<Region> findPage(Page<Region> page){
        int total=regionDao.getTotalCount();
        page.setTotal(total);
        int offset=(page.getCurrentPage()-1)*page.getCount();
        return regionDao.listByPage(new RowBounds(offset,page.getCount()));
    }

    public void addRegions(List<Region> list){
        if (list!=null){
            for(Region region:list){
                regionDao.saveRegion(region);
            }
        }
    }

    public List<Region> ajaxList(){
        return regionDao.findNameAndId();
    }

    public Region findById(int id){
        return regionDao.findById(id);
    }

    public void add(Region region){
        regionDao.saveRegion(region);
    }

    public void delete(int id){
        regionDao.delete(id);
    }
}

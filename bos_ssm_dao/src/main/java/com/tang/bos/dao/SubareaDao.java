package com.tang.bos.dao;

import com.tang.bos.entity.Subarea;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tang on 17-5-20.
 */
@Repository
public interface SubareaDao {

    List<Subarea> findPage(RowBounds rowBounds,Subarea subarea);

    List<Subarea> findByPage(RowBounds rowBounds);

    int findCount();

    int addSub(Subarea subarea);

    int editSub(@Param("subarea") Subarea subarea, @Param("id") int id);

    int del(int id);

    List<Subarea> findAll();
}

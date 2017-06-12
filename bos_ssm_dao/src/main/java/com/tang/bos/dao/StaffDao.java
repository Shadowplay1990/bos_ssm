package com.tang.bos.dao;

import com.tang.bos.entity.Staff;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tang on 17-5-18.
 */
@Repository
public interface StaffDao {

    List<Staff> findByPage(RowBounds rowBounds);

    int addStaff(Staff staff);

    int deleteById(int id);

    void updateStaff(Staff staff);

    Staff findById(int id);

}

package com.tang.bos.dao;

import com.tang.bos.entity.Region;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tang on 17-5-19.
 */
@Repository
public interface RegionDao {

    List<Region> listByPage(RowBounds rowBounds);

    int saveRegion(Region region);

    int getTotalCount();

    Region findById(int id);

    List<Region> findNameAndId();

    int delete(int id);
}

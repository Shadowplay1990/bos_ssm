package com.tang.bos.dao;

import com.tang.bos.entity.Decidedzone;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tang on 17-5-20.
 */
@Repository
public interface DecidedzoneDao {

    List<Decidedzone> findPage(RowBounds rowBounds);

    int findTotal();
}

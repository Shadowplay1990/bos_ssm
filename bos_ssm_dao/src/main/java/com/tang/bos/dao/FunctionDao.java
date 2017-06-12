package com.tang.bos.dao;

import com.tang.bos.entity.Function;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tang on 17-6-13.
 */
@Repository
public interface FunctionDao {

   List<Function> findAllParents();

   List<Function> findMenus();

   Function getFunctionById(int id);

   List<Function> getChildren(int pid);
}

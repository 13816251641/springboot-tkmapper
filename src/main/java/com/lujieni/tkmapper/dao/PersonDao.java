package com.lujieni.tkmapper.dao;

import com.lujieni.tkmapper.domain.po.PersonPO;
import com.lujieni.tkmapper.mybatis.basedao.BaseDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDao extends BaseDao<PersonPO> {

    List<PersonPO> queryPersonByName(@Param("name") String name);
}

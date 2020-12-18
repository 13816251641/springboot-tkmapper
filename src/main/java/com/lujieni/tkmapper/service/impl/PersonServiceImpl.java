package com.lujieni.tkmapper.service.impl;

import com.lujieni.tkmapper.dao.PersonDao;
import com.lujieni.tkmapper.domain.po.PersonPO;
import com.lujieni.tkmapper.mybatis.service.AbstractBaseService;
import com.lujieni.tkmapper.service.IPersonService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Package: com.lujieni.tkmapper.service.impl
 * @ClassName: PersonServiceImpl
 * @Author: lujieni
 * @Description: Person服务实现类
 * @Date: 2020-12-17 17:36
 * @Version: 1.0
 */
@Service
public class PersonServiceImpl extends AbstractBaseService<PersonDao, PersonPO> implements IPersonService {

    @Override
    public List<PersonPO> queryPersonByName(String name) {
     /*   Example example = new Example(PersonPO.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name",name);
        List<PersonPO> list = super.selectByExample(example);
        return list;*/
        List<PersonPO> list = super.dao.queryPersonByName(name);
        return list;
    }
}
package com.lujieni.tkmapper.service.impl;

import com.lujieni.tkmapper.common.RequestDTO;
import com.lujieni.tkmapper.mybatis.service.AbstractBaseService;
import com.lujieni.tkmapper.dao.StudentDao;
import com.lujieni.tkmapper.domain.po.StudentPO;
import com.lujieni.tkmapper.domain.vo.StudentVO;
import com.lujieni.tkmapper.service.IStudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl extends AbstractBaseService<StudentPO,StudentDao> implements IStudentService {

    @Override
    public List<StudentVO> findStudentByName() {
        //super.deleteByPrimaryKey(1);
        return super.dao.findStudentByName("陆捷旎");
    }

}

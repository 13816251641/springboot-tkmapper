package com.lujieni.tkmapper.mybatis.service;

import com.lujieni.tkmapper.mybatis.basedao.BaseDao;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <D extends BaseDao<T>, T> 中的最后一个T一定要
 * @param <D>
 * @param <T>
 * <D extends BaseDao<T>,T>
 *
 *  AbstractBaseService<D extends BaseDao<T>,T> implements IBaseService<T>
 */
public class AbstractBaseService<D extends BaseDao<T>, T> implements IBaseService<T> {

    /*
        @Autowired必不可少
        这样写也可以,但是StudentDao的自定义方法就要强转了
        protected BaseDao dao;
    */
    @Autowired
    protected D dao;

    @Transactional
    public int save(T record) {
        return dao.insert(record);
    }

    @Transactional
    public int saveSelective(T record) {
        return dao.insertSelective(record);
    }

    @Transactional
    public int deleteByPrimaryKey(Object key) {
        return dao.deleteByPrimaryKey(key);
    }

    @Transactional
    public int delete(T record) {
        return dao.delete(record);
    }

    @Transactional
    public int deleteByExample(Object example) {
        return dao.deleteByExample(example);
    }

    @Transactional
    public int updateByPrimaryKey(T record) {
        return dao.updateByPrimaryKey(record);
    }

    @Transactional
    public int updateByPrimaryKeySelective(T record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    @Transactional
    public int updateByExample(@Param("record") T record, @Param("example") Object example) {
        return dao.updateByExample(record, example);
    }

    @Transactional
    public int updateByExampleSelective(@Param("record") T record, @Param("example") Object example) {
        return dao.updateByExampleSelective(record, example);
    }

    public T selectOne(T record) {
        return dao.selectOne(record);
    }

    public List<T> select(T record) {
        return dao.select(record);
    }

    public List<T> selectAll() {
        return dao.selectAll();
    }

    public int selectCount(T record) {
        return dao.selectCount(record);
    }

    public T selectByPrimaryKey(Object key) {
        return dao.selectByPrimaryKey(key);
    }

    public List<T> selectByExample(Object example) {
        return dao.selectByExample(example);
    }

    public int selectCountByExample(Object example) {
        return dao.selectCountByExample(example);
    }

    public List<T> selectByRowBounds(T record, RowBounds rowBounds) {
        return dao.selectByRowBounds(record, rowBounds);
    }

    public List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
        return dao.selectByExampleAndRowBounds(example, rowBounds);
    }
}

package com.lujieni.tkmapper.mybatis.service;

import com.lujieni.tkmapper.mybatis.service.delete.IDeleteService;
import com.lujieni.tkmapper.mybatis.service.insert.IInsertService;
import com.lujieni.tkmapper.mybatis.service.select.ISelectService;
import com.lujieni.tkmapper.mybatis.service.update.IUpdateService;

/**
 * 接口可以是多继承的
 * @param <T>
 */
public interface IBaseService<T> extends IDeleteService<T>, IInsertService<T>, IUpdateService<T>, ISelectService<T> {


}

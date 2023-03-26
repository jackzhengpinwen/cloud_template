package com.zpw.sprintboot.sprintboottemplate.system.service.impl;

import com.zpw.sprintboot.sprintboottemplate.system.dao.BaseDao;
import com.zpw.sprintboot.sprintboottemplate.system.entity.BaseEntity;
import com.zpw.sprintboot.sprintboottemplate.system.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseServiceImpl<D extends BaseDao<T>, T extends BaseEntity> implements BaseService<T> {

    @Autowired
    protected D dao;


    @Override
    public T findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public void save(T entity) {
        dao.save(entity);
    }

    @Override
    public void updateById(T entity) {
        dao.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }
}



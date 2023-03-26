package com.zpw.sprintboot.sprintboottemplate.system.service;


import com.zpw.sprintboot.sprintboottemplate.system.entity.BaseEntity;

public interface BaseService<T extends BaseEntity> {


    T findById(Long id);

    void save(T entity);

    void updateById(T entity);

    void deleteById(Long id);
}


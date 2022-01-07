package com.increff.employee.service;

import java.util.List;

import javax.transaction.Transactional;

import com.increff.employee.dao.BrandCategoryDao;
import com.increff.employee.pojo.BrandCategoryPojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandCategoryService {
    @Autowired
    private BrandCategoryDao dao;

    @Transactional(rollbackOn = ApiException.class)
    public void add(BrandCategoryPojo p) throws ApiException {
        dao.insert(p);
    }

    public List<BrandCategoryPojo> getAll() {
        return dao.selectAll();
    }

    public BrandCategoryPojo get(int id) throws ApiException {
        return dao.select(id);
    }

}

package com.increff.employee.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.increff.employee.model.ProductData;
import com.increff.employee.model.ProductForm;
import com.increff.employee.pojo.BrandCategoryPojo;
import com.increff.employee.pojo.ProductPojo;
import com.increff.employee.service.ApiException;
import com.increff.employee.service.BrandCategoryService;
import com.increff.employee.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
public class ProductApiController {

    @Autowired
    private ProductService productService;
    @Autowired
    private BrandCategoryService brandCategoryService;

    @ApiOperation(value = "Adds a product")
    @RequestMapping(path = "/api/product", method = RequestMethod.POST)
    public void add(@RequestBody ProductForm form) throws ApiException {
        BrandCategoryPojo brandCategory = brandCategoryService.get(form.getBrandCategory());
        ProductPojo p = convert(form, brandCategory);
        productService.add(p);
    }

    @ApiOperation(value = "Get all products")
    @RequestMapping(path = "/api/product", method = RequestMethod.GET)
    public List<ProductData> getAll() {
        List<ProductPojo> list = productService.getAll();
        List<ProductData> list2 = new ArrayList<ProductData>();
        for (ProductPojo p : list) {
            list2.add(convert(p));
        }
        return list2;
    }

    @ApiOperation(value = "Get product by id")
    @RequestMapping(path = "/api/product/{id}", method = RequestMethod.GET)
    public ProductData get(int id) throws ApiException {
        ProductPojo p = productService.get(id);
        return convert(p);
    }

    @ApiOperation(value = "Delete a product by id")
    @RequestMapping(path = "/api/product/{id}", method = RequestMethod.DELETE)
    public void delete(int id) throws ApiException {
        productService.delete(id);
    }

    @ApiOperation(value = "Update product by id")
    @RequestMapping(path = "/api/product/{id}", method = RequestMethod.PUT)
    public void update(int id, @RequestBody ProductForm form) throws ApiException {
        ProductPojo p = convert(form);
        p.setId(id);
        productService.update(p);
    }

    private static ProductPojo convert(ProductForm form, BrandCategoryPojo brandCategory) {
        ProductPojo p = new ProductPojo();
        p.setBrandCategory(brandCategory);
        p.setName(form.getName());
        p.setMrp(form.getMrp());
        p.setBarcode(UUID.randomUUID().toString());
        return p;
    }

    private static ProductPojo convert(ProductForm form) {
        ProductPojo p = new ProductPojo();
        p.setName(form.getName());
        p.setMrp(form.getMrp());
        p.setBarcode(UUID.randomUUID().toString());
        return p;
    }

    private static ProductData convert(ProductPojo p) {
        ProductData d = new ProductData();
        d.setBrandCategory(p.getBrandCategory().getId());
        d.setName(p.getName());
        d.setMrp(p.getMrp());
        d.setId(p.getId());
        d.setBarcode(p.getBarcode());
        return d;
    }
}

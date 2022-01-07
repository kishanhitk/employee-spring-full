package com.increff.employee.model;

public class ProductForm {
    private String name;
    private int brandCategoryId;
    private Double mrp;

    public String getName() {
        return name;
    }

    public Double getMrp() {
        return mrp;
    }

    public void setMrp(Double mrp) {
        this.mrp = mrp;
    }

    public int getBrandCategory() {
        return brandCategoryId;
    }

    public void setBrandCategory(int brandCategory) {
        this.brandCategoryId = brandCategory;
    }

    public void setName(String name) {
        this.name = name;
    }
}

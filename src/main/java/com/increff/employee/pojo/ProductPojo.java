package com.increff.employee.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity()
@Table(name = "Products", uniqueConstraints = @UniqueConstraint(columnNames = { "barcode" }))
public class ProductPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String barcode;

    private String name;

    private Double mrp;

    @ManyToOne
    @JoinColumn(name = "BRAND_CATEGORY_ID", referencedColumnName = "ID")
    private BrandCategoryPojo brandCategory;

    public int getId() {
        return id;
    }

    public BrandCategoryPojo getBrandCategory() {
        return brandCategory;
    }

    public void setBrandCategory(BrandCategoryPojo brandCategory) {
        this.brandCategory = brandCategory;
    }

    public void setId(int id) {
        this.id = id;
    }

    // TODO Generate UUID for barcode
    public String getBarcode() {
        return barcode;
    }

    public Double getMrp() {
        return mrp;
    }

    public void setMrp(Double mrp) {
        this.mrp = mrp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

}

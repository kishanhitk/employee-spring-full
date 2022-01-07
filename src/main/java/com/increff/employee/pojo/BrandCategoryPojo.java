package com.increff.employee.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity()
@Table(name = "BrandCategory")
public class BrandCategoryPojo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String category;

    @OneToMany
    @JoinColumn(name = "BRAND_CATEGORY_ID", referencedColumnName = "ID")
    private List<ProductPojo> courses;

    public int getId() {
        return id;
    }

    public List<ProductPojo> getCourses() {
        return courses;
    }

    public void setCourses(List<ProductPojo> courses) {
        this.courses = courses;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}

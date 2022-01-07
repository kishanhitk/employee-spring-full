package com.increff.employee.pojo;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity()
@Table(name = "Orders")
public class OrderPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp()
    private Timestamp orderDate;

    @OneToMany
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID")
    private List<OrderItemPojo> orderItems;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }
}

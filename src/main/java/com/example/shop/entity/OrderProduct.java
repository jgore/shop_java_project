package com.example.shop.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class OrderProduct implements Identifable{
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "create_data", updatable = false)
    @CreationTimestamp
    private Timestamp createData;

    @Column(name = "update_data")
    private Timestamp updateData;

    public OrderProduct() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Timestamp getCreateData() {
        return createData;
    }

    public void setCreateData(Timestamp createData) {
        this.createData = createData;
    }

    public Timestamp getUpdateData() {
        return updateData;
    }

    public void setUpdateData(Timestamp updateData) {
        this.updateData = updateData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderProduct that = (OrderProduct) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(product, that.product) &&
                Objects.equals(order, that.order) &&
                Objects.equals(createData, that.createData) &&
                Objects.equals(updateData, that.updateData);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, product, order, createData, updateData);
    }
}

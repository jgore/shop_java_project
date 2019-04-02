package com.example.shop.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "order_table")
public class Order implements Identifable {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    @CreationTimestamp
    @Column(name = "create_data", updatable = false)
    private Timestamp createData;

    @CreationTimestamp
    @Column(name = "update_data")
    private Timestamp updateData;

    @OneToMany(mappedBy = "order", fetch = LAZY, cascade = ALL, orphanRemoval = true)
    private List<OrderLineItem> orderLineItemList;


    public Order() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<OrderLineItem> getOrderLineItemList() {
        return orderLineItemList;
    }

    public void setOrderLineItemList(List<OrderLineItem> orderLineItemList) {
        this.orderLineItemList = orderLineItemList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(createData, order.createData) &&
                Objects.equals(updateData, order.updateData) &&
                Objects.equals(orderLineItemList, order.orderLineItemList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createData, updateData, orderLineItemList);
    }
}

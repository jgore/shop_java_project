package com.example.shop.entity;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ORDER_TABLE")
public class Order implements Identifable {

    private Long id;
    private List<OrderLineItem> orderLineItems;

    private LocalDate created;
    private LocalDate updated;

    @Id
    @GeneratedValue
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.EAGER, orphanRemoval = true)
    public List<OrderLineItem> getOrderLineItems() {
        return orderLineItems;
    }


    @CreationTimestamp
    @Column(name = "CREATE_DATA", updatable = false)
    public LocalDate getCreated() {
        return created;
    }

    @UpdateTimestamp
    @Column(name = "UPDATE_DATA", updatable = true)
    public LocalDate getUpdated() {
        return updated;
    }

    public void setOrderLineItems(List<OrderLineItem> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }
}

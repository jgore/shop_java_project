package com.example.shop.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ORDER_LINE_ITEM_TABLE")
public class OrderLineItem implements Identifable {

    private Long id;

    private Product product;

    private Order order;

    private int amount;

    private LocalDate created;

    private LocalDate updated;

    @Id
    @GeneratedValue
    @Override
    public Long getId() {
        return id;
    }

    @ManyToOne(targetEntity = Product.class, fetch = FetchType.EAGER)
    @JoinColumn(name="product_id", nullable = false)
    public Product getProduct() {
        return product;
    }

    @ManyToOne(targetEntity = Order.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="order_id", nullable = false)
    public Order getOrder() {
        return order;
    }

    public int getAmount() {
        return amount;
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

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }
}

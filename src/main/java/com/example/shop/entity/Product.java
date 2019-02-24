package com.example.shop.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Product implements Identifable {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    private String name;
    private BigDecimal price;
    private int quantity;

    @Column(name = "create_data", updatable = false)
    @CreationTimestamp
    private Timestamp createData;

    @Column(name = "update_data")
    @UpdateTimestamp
    private Timestamp updateData;

    @OneToMany(mappedBy = "product")
    private List<OrderProduct> orderedProducts;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public List<OrderProduct> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<OrderProduct> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return quantity == product.quantity &&
                Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                Objects.equals(createData, product.createData) &&
                Objects.equals(updateData, product.updateData) &&
                Objects.equals(orderedProducts, product.orderedProducts);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, price, quantity, createData, updateData, orderedProducts);
    }
}

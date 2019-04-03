package com.example.shop.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT_TABLE")
public class Product implements Identifable {

    private Long id;
    private String title;
    private String description;

    private BigDecimal price;

    private Timestamp createData;
    private Timestamp updateData;

    @Id
    @GeneratedValue
    @Override
    public Long getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }


    public String getDescription() {
        return description;
    }


    public BigDecimal getPrice() {
        return price;
    }

    @Column(name = "create_data", updatable = false)
    @CreationTimestamp
    public Timestamp getCreateData() {
        return createData;
    }

    @Column(name = "update_data")
    @UpdateTimestamp
    public Timestamp getUpdateData() {
        return updateData;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCreateData(Timestamp createData) {
        this.createData = createData;
    }

    public void setUpdateData(Timestamp updateData) {
        this.updateData = updateData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(getId(), product.getId()) &&
                Objects.equals(getTitle(), product.getTitle()) &&
                Objects.equals(getDescription(), product.getDescription()) &&
                Objects.equals(getPrice(), product.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getDescription(), getPrice(), getCreateData(), getUpdateData());
    }
}

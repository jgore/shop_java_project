package com.example.shop.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "ORDER_TABLE")
public class Order implements Identifable {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;


    @Column(name = "create_data", updatable = false)
    @CreationTimestamp
    private Timestamp createData;

    @Column(name = "update_data")
    @UpdateTimestamp
    private Timestamp updateData;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "order")
    private List<OrderProduct> productOrders;

    public Order() {
    }

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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<OrderProduct> getProductOrders() {
        return productOrders;
    }

    public void setProductOrders(List<OrderProduct> productOrders) {
        this.productOrders = productOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(createData, order.createData) &&
                Objects.equals(updateData, order.updateData) &&
                Objects.equals(account, order.account) &&
                Objects.equals(productOrders, order.productOrders);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, createData, updateData, account, productOrders);
    }
}

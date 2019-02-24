package com.example.shop.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Account implements Identifable {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    @Column(name = "create_data", updatable = false)
    @CreationTimestamp
    private Timestamp createData;

    @Column(name = "update_data")
    @UpdateTimestamp
    private Timestamp updateData;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User userAccount;

    @OneToMany(mappedBy = "account")
    private List<Order> orders;

    public Account() {
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

    public User getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(User userAccount) {
        this.userAccount = userAccount;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(createData, account.createData) &&
                Objects.equals(updateData, account.updateData) &&
                Objects.equals(userAccount, account.userAccount) &&
                Objects.equals(orders, account.orders);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, createData, updateData, userAccount, orders);
    }
}

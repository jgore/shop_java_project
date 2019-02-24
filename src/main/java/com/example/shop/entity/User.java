package com.example.shop.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "USER_TABLE")
public class User implements Identifable {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    private String login;
    private String email;
    private String password;

    @Column(name = "create_data", updatable = false)
    @CreationTimestamp
    private Timestamp createData;

    @Column(name = "update_data")
    @UpdateTimestamp
    private Timestamp updateData;

    @OneToOne(mappedBy = "userAccount")
    private Account accountOwner;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Account getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(Account accountOwner) {
        this.accountOwner = accountOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(login, user.login) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(createData, user.createData) &&
                Objects.equals(updateData, user.updateData) &&
                Objects.equals(accountOwner, user.accountOwner);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login, email, password, createData, updateData, accountOwner);
    }
}

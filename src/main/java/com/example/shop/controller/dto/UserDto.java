package com.example.shop.controller.dto;

public class UserDto {

    private Long id;
    private String login;
    private String email;
    private String password;

    private AccountDto account;

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


    public AccountDto getAccountDto() {
        return account;
    }

    public void setAccountDto(AccountDto account) {
        this.account = account;
    }
}

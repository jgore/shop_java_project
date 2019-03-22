package com.example.shop.dto;

import java.util.Objects;

public class UserDto {
    private Long id;
    private String login;
    private String email;
    private String password;

    private AccountDto accountDto;

    public UserDto() {
    }

    public UserDto(Long id, String login, String email, String password, AccountDto accountDto) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.accountDto = accountDto;
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

    public AccountDto getAccountDto() {
        return accountDto;
    }

    public void setAccountDto(AccountDto accountDto) {
        this.accountDto = accountDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id) &&
                Objects.equals(login, userDto.login) &&
                Objects.equals(email, userDto.email) &&
                Objects.equals(password, userDto.password) &&
                Objects.equals(accountDto, userDto.accountDto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login, email, password, accountDto);
    }
}

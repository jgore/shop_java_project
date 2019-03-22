package com.example.shop.dto;

import java.util.Objects;

public class AccountDto {
    private Long id;

    public AccountDto() {
    }

    public AccountDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

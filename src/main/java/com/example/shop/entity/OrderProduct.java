package com.example.shop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;


}

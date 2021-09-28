package com.manbalboy.jpa.bookmanaber.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Address {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

}
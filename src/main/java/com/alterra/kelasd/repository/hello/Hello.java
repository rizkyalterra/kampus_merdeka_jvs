package com.alterra.kelasd.repository.hello;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "hello")
public class Hello {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "hello", length = 100, nullable = true)
    private String hello;
}

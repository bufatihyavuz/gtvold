package com.gametopvideos.entity;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORY")
public class Category {
    @Id
    @GeneratedValue(generator = "category_generator")
    @SequenceGenerator(
            name = "category_generator",
            sequenceName = "category_sequence",
            initialValue = 1000
    )
    private Long id;

    @Basic
    @Column(name = "name",nullable = false)
    private String name;
}

package com.gametopvideos.entity;

import javax.persistence.*;

@Entity
@Table(name = "ACTIONTYPE")
public class ActionType {
    @Id
    @GeneratedValue(generator = "actiontype_generator")
    @SequenceGenerator(
            name = "actiontype_generator",
            sequenceName = "actiontype_sequence",
            initialValue = 1000
    )
    private Long id;

    @Basic
    @Column(name = "name",nullable = false)
    private String name;
}

package com.gametopvideos.entity;

import javax.persistence.*;

@Entity
@Table(name = "ACTION")
public class Action {
    @Id
    @GeneratedValue(generator = "action_generator")
    @SequenceGenerator(
            name = "action_generator",
            sequenceName = "action_sequence",
            initialValue = 1000
    )
    private Long id;

    @Basic
    @Column(name = "isValid",nullable = false)
    private boolean isValid;

    @Basic
    @Column(name = "user",nullable = false)
    private User user;

    @Basic
    @Column(name = "video",nullable = false)
    private Video video;

    @Basic
    @Column(name = "actionType",nullable = false)
    private ActionType actionType;
}

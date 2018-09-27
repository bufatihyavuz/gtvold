package com.gametopvideos.entity;

import javax.persistence.*;

@Entity
@Table(name = "VIDEO")
public class Video {

    @Id
    @GeneratedValue(generator = "video_generator")
    @SequenceGenerator(
            name = "video_generator",
            sequenceName = "video_sequence",
            initialValue = 1000
    )
    @Column(name = "id" , nullable = false)
    private Long id;

    @Basic
    @Column(name = "title",nullable = false)
    private String title;

    @Basic
    @Column(name = "url",nullable = false)
    private String url;

    @Basic
    @Column(name = "view",nullable = false)
    private Long view;

    @Basic
    @Column(name = "duraion",nullable = false)
    private Long duration;

    @Basic
    @Column(name = "size",nullable = false)
    private Long size;

    @Basic
    @Column(name = "category",nullable = false)
    private Category category;

    @Basic
    @Column(name = "user",nullable = false)
    private User user;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public Long getView() {
        return view;
    }
    public void setView(Long view) {
        this.view = view;
    }

    public Long getDuration() {
        return duration;
    }
    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getSize() {
        return size;
    }
    public void setSize(Long size) {
        this.size = size;
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}

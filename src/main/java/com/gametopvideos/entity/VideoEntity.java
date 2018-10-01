package com.gametopvideos.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "VIDEO", schema = "gametopvideos", catalog = "gtv")
public class VideoEntity {
    private int id;
    private String title;
    private String url;
    private Integer view;
    private Integer duration;
    private Integer size;
    private Integer categoryId;
    private Integer userId;
    private Collection<ActionEntity> actionsById;
    private CategoryEntity categoryByCategoryId;
    private UserEntity userByUserId;

    public VideoEntity(){}

    public VideoEntity(int id, String title, String url, Integer view, Integer duration, Integer size, Integer categoryId, Integer userId, Collection<ActionEntity> actionsById, CategoryEntity categoryByCategoryId, UserEntity userByUserId) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.view = view;
        this.duration = duration;
        this.size = size;
        this.categoryId = categoryId;
        this.userId = userId;
        this.actionsById = actionsById;
        this.categoryByCategoryId = categoryByCategoryId;
        this.userByUserId = userByUserId;
    }

    @Id
    @GeneratedValue(generator = "video_generator")
    @SequenceGenerator(
            name = "video_generator",
            sequenceName = "video_sequence",
            initialValue = 1000
    )
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 70)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "url", nullable = true, length = 50)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "view", nullable = true)
    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    @Basic
    @Column(name = "duration", nullable = true)
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "size", nullable = true)
    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Basic
    @Column(name = "category_id", nullable = true)
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "user_id", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VideoEntity that = (VideoEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (view != null ? !view.equals(that.view) : that.view != null) return false;
        if (duration != null ? !duration.equals(that.duration) : that.duration != null) return false;
        if (size != null ? !size.equals(that.size) : that.size != null) return false;
        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (view != null ? view.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "videoByVideoId")
    public Collection<ActionEntity> getActionsById() {
        return actionsById;
    }

    public void setActionsById(Collection<ActionEntity> actionsById) {
        this.actionsById = actionsById;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id",insertable = false,updatable = false)
    public CategoryEntity getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(CategoryEntity categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id",insertable = false,updatable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }
}

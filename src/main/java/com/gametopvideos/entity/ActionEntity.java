package com.gametopvideos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "action", schema = "gametopvideos", catalog = "gtv")
public class ActionEntity {
    private int id;
    private String active;
    private Integer userId;
    private Integer videoId;
    private Integer actiontypeId;
    private UserEntity userByUserId;
    private VideoEntity videoByVideoId;
    private ActiontypeEntity actiontypeByActiontypeId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "active", nullable = true, length = 1)
    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Basic
    @Column(name = "user_id", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "video_id", nullable = true)
    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    @Basic
    @Column(name = "actiontype_id", nullable = true)
    public Integer getActiontypeId() {
        return actiontypeId;
    }

    public void setActiontypeId(Integer actiontypeId) {
        this.actiontypeId = actiontypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActionEntity that = (ActionEntity) o;

        if (id != that.id) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (videoId != null ? !videoId.equals(that.videoId) : that.videoId != null) return false;
        if (actiontypeId != null ? !actiontypeId.equals(that.actiontypeId) : that.actiontypeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (videoId != null ? videoId.hashCode() : 0);
        result = 31 * result + (actiontypeId != null ? actiontypeId.hashCode() : 0);
        return result;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id",insertable = false,updatable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "video_id", referencedColumnName = "id",insertable = false,updatable = false)
    public VideoEntity getVideoByVideoId() {
        return videoByVideoId;
    }

    public void setVideoByVideoId(VideoEntity videoByVideoId) {
        this.videoByVideoId = videoByVideoId;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "actiontype_id", referencedColumnName = "id",insertable = false,updatable = false)
    public ActiontypeEntity getActiontypeByActiontypeId() {
        return actiontypeByActiontypeId;
    }

    public void setActiontypeByActiontypeId(ActiontypeEntity actiontypeByActiontypeId) {
        this.actiontypeByActiontypeId = actiontypeByActiontypeId;
    }
}

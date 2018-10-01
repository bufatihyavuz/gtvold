package com.gametopvideos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collection;

@Entity
@Table(name = "USER", schema = "gametopvideos", catalog = "gtv")
public class UserEntity {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String active;
    private BigInteger roleId;
    private Collection<ActionEntity> actionsById;
    private RoleEntity roleByRoleId;
    private Collection<VideoEntity> videosById;

    @Id
    @GeneratedValue(generator = "user_generator")
    @SequenceGenerator(
            name = "user_generator",
            sequenceName = "user_sequence",
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
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname", nullable = true, length = 20)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 30)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    @Column(name = "role_id", nullable = true)
    public BigInteger getRoleId() {
        return roleId;
    }

    public void setRoleId(BigInteger roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<ActionEntity> getActionsById() {
        return actionsById;
    }

    public void setActionsById(Collection<ActionEntity> actionsById) {
        this.actionsById = actionsById;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id",insertable = false,updatable = false)
    public RoleEntity getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(RoleEntity roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "userByUserId")
    public Collection<VideoEntity> getVideosById() {
        return videosById;
    }

    public void setVideosById(Collection<VideoEntity> videosById) {
        this.videosById = videosById;
    }
}

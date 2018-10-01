package com.gametopvideos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ROLE", schema = "gametopvideos", catalog = "gtv")
public class RoleEntity {
    private int id;
    private String name;
    private Collection<UserEntity> usersById;

    @Id
    @GeneratedValue(generator = "role_generator")
    @SequenceGenerator(
            name = "role_generator",
            sequenceName = "role_sequence",
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleEntity that = (RoleEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<UserEntity> getUsersById() {
        return usersById;
    }

    public void setUsersById(Collection<UserEntity> usersById) {
        this.usersById = usersById;
    }
}

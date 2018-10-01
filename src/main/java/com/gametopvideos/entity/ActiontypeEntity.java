package com.gametopvideos.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ACTIONTYPE", schema = "gametopvideos", catalog = "gtv")
public class ActiontypeEntity {
    private int id;
    private String name;
    private Collection<ActionEntity> actionsById;

    @Id
    @GeneratedValue(generator = "actiontype_generator")
    @SequenceGenerator(
            name = "actiontype_generator",
            sequenceName = "actiontype_sequence",
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

        ActiontypeEntity that = (ActiontypeEntity) o;

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

    @OneToMany(mappedBy = "actiontypeByActiontypeId")
    public Collection<ActionEntity> getActionsById() {
        return actionsById;
    }

    public void setActionsById(Collection<ActionEntity> actionsById) {
        this.actionsById = actionsById;
    }
}

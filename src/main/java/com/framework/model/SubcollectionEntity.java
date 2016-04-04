package com.framework.model;

import javax.persistence.*;

/**
 * Created by WangYudan on 2016/4/3.
 */
@Entity
@Table(name = "subcollection", schema = "public", catalog = "postgres")
public class SubcollectionEntity {
    private int id;
    private String name;
    private int pid;
    private CollectionEntity coById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "pid", nullable = true)
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubcollectionEntity that = (SubcollectionEntity) o;

        if (id != that.id) return false;
        if (pid != that.pid) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + pid;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "pid", referencedColumnName = "id",insertable = false, updatable = false)
    public CollectionEntity getCoById() {
        return coById;
    }

    public void setCoById(CollectionEntity coById) {
        this.coById = coById;
    }
}

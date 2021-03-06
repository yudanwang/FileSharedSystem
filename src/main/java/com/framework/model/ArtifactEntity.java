package com.framework.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Abi on 2016-03-23.
 */
@Entity
@Table(name = "artifact", schema = "public", catalog = "postgres")
public class ArtifactEntity {
    private int id;
    private String name;
    private List<CollectionEntity> collectionById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArtifactEntity that = (ArtifactEntity) o;

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

    @ManyToMany
    @JoinTable(name = "artifact_collection", catalog = "postgres", schema = "public", joinColumns = @JoinColumn(name = "artifact_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "collection_id", referencedColumnName = "id"))
    public List<CollectionEntity> getCollectionById() {
        return collectionById;
    }

    public void setCollectionById(List<CollectionEntity> collectionById) {
        this.collectionById = collectionById;
    }
}

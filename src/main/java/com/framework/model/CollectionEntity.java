package com.framework.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Abi on 2016-03-24.
 */
@Entity
@Table(name = "collection", schema = "public", catalog = "postgres")
public class CollectionEntity {
    private int id;
    private String name;
    private String key;
    private List<ArtifactEntity> artifactById;
    private List<SubcollectionEntity> subById;

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
    @Column(name = "key", nullable = true, length = -1)
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollectionEntity that = (CollectionEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (key != null ? !key.equals(that.key) : that.key != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (key != null ? key.hashCode() : 0);
        return result;
    }

    @ManyToMany(mappedBy = "collectionById")
    public List<ArtifactEntity> getArtifactById() {
        return artifactById;
    }

    public void setArtifactById(List<ArtifactEntity> artifactById) {
        this.artifactById = artifactById;
    }

    @OneToMany(mappedBy = "coById")
    public List<SubcollectionEntity> getSubById() {
        return subById;
    }

    public void setSubById(List<SubcollectionEntity> subById) {
        this.subById = subById;
    }
}

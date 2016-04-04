package com.framework.model;

import javax.persistence.*;

/**
 * Created by WangYudan on 2016/4/1.
 */
@Entity
@Table(name = "artifact_collection", schema = "public", catalog = "postgres")
public class ArtifactCollectionEntity {
    private int id;
    private int collectionId;
    private int artifactId;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "collection_id", nullable = true)
    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    @Basic
    @Column(name = "artifact_id", nullable = true)
    public int getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(int artifactId) {
        this.artifactId = artifactId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArtifactCollectionEntity that = (ArtifactCollectionEntity) o;

        if (id != that.id) return false;
        if (collectionId != that.collectionId) return false;
        if (artifactId != that.artifactId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + collectionId;
        result = 31 * result + artifactId;
        return result;
    }
}

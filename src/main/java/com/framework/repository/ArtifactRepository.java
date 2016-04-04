package com.framework.repository;

/**
 * Created by WangYudan on 2016/3/17.
 */

import com.framework.model.ArtifactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface ArtifactRepository extends JpaRepository<ArtifactEntity, Integer>{

    @Query("select artifact from ArtifactEntity artifact join artifact.collectionById collectionId where collectionId.id=:qId")
    List<ArtifactEntity> info(@Param("qId") int id);
}


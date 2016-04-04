package com.framework.repository;

import com.framework.model.ArtifactCollectionEntity;
import com.framework.model.SubcollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by WangYudan on 2016/4/1.
 */

@Repository
public interface ArCoRepository extends JpaRepository<ArtifactCollectionEntity, Integer> {

   @Query("select articollEntity.id from ArtifactCollectionEntity articollEntity where articollEntity.artifactId=:aId and articollEntity.collectionId=:cId")
   int removeId(@Param("aId") int artifactId, @Param("cId") int collectionId);

   @Query("select articoll from ArtifactCollectionEntity articoll where articoll.collectionId=:cId")
   List<ArtifactCollectionEntity> artilist(@Param("cId") int cid);

}

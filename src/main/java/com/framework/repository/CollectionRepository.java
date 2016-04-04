package com.framework.repository;


import com.framework.model.CollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Abi on 2016-03-23.
 */
    @Repository
    public interface CollectionRepository extends JpaRepository<CollectionEntity, Integer> {

    @Query("select collection.key from CollectionEntity collection")
    List<CollectionEntity> key();

    @Query("select collection.id from CollectionEntity collection where collection.key=:qKey")
    int id(@Param("qKey") String key);

    @Query("select collection.name from CollectionEntity collection where collection.id=:qId")
    String name(@Param("qId") int id);

    @Query("select collection from CollectionEntity collection join collection.subById subById where subById.pid=:sId")
    List<CollectionEntity> deleteCollection(@Param("sId") int id);

    @Query("select collection.id from CollectionEntity collection where collection.name=:qName")
    int deleteId(@Param("qName") String name);
    }


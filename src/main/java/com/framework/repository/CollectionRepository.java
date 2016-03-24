package com.framework.repository;


import com.framework.model.CollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Abi on 2016-03-23.
 */
    @Repository
    public interface CollectionRepository extends JpaRepository<CollectionEntity, Integer> {
    }


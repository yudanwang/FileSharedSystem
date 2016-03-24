package com.framework.repository;

/**
 * Created by WangYudan on 2016/3/17.
 */

import com.framework.model.ArtifactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtifactRepository extends JpaRepository<ArtifactEntity, Integer>{
}


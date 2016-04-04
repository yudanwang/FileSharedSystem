package com.framework.repository;

import com.framework.model.SubcollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by WangYudan on 2016/4/3.
 */

@Repository
public interface SubCollectionRepository extends JpaRepository<SubcollectionEntity, Integer> {

    @Query("select subcollection from SubcollectionEntity subcollection where subcollection.pid=:pId")
    List<SubcollectionEntity> sublist(@Param("pId") int id);

    @Query("select subcollection.name from SubcollectionEntity subcollection where subcollection.pid=:pId")
    List<String> name(@Param("pId") int id);

    @Query("select subcollection.id from SubcollectionEntity subcollection where subcollection.pid=:pId")
    List getId(@Param("pId") int id);
}

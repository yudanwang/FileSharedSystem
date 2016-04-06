package com.framework.controller;

/**
 * Created by WangYudan on 2016/3/23.
 */

import com.framework.model.ArtifactEntity;
import com.framework.model.SubcollectionEntity;
import com.framework.repository.ArtifactRepository;
import com.framework.repository.CollectionRepository;
import com.framework.repository.SubCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ViewCollectionController {

    @Autowired
    CollectionRepository collectionRepository;

    @Autowired
    ArtifactRepository artifactRepository;

    @Autowired
    SubCollectionRepository subCollectionRepository;

    @RequestMapping(value = "/admin/collection/view/{id}", method = RequestMethod.GET)
    public String showCollection(@PathVariable("id") int collectionId, ModelMap modelMap) {

        List<ArtifactEntity> artifactList = artifactRepository.info(collectionId);

        modelMap.addAttribute("artifactList", artifactList);

        List<SubcollectionEntity> subcollectionList = subCollectionRepository.sublist(collectionId);

        modelMap.addAttribute("subcollectionList", subcollectionList);

        modelMap.addAttribute("collectionId", collectionId);

        String name = collectionRepository.name(collectionId);

        modelMap.addAttribute("name", name);

        return "admin/collectionInfo";
    }
}

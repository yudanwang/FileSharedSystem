package com.framework.controller;

/**
 * Created by WangYudan on 2016/3/31.
 */

import com.framework.model.ArtifactCollectionEntity;
import com.framework.model.ArtifactEntity;
import com.framework.model.CollectionEntity;
import com.framework.model.SubcollectionEntity;
import com.framework.repository.ArCoRepository;
import com.framework.repository.ArtifactRepository;
import com.framework.repository.CollectionRepository;
import com.framework.repository.SubCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AddElementController {
    @Autowired
    CollectionRepository collectionRepository;

    @Autowired
    ArtifactRepository artifactRepository;

    @Autowired
    ArCoRepository arCoRepository;

    @Autowired
    SubCollectionRepository subCollectionRepository;

    @RequestMapping(value = "/admin/collection/view/{collectionId}/add", method = RequestMethod.GET)
    public String addInfo(@PathVariable int collectionId, ModelMap modelMap) {

        List<ArtifactEntity> artifactList = artifactRepository.findAll();

        modelMap.addAttribute("collectionId", collectionId);

        modelMap.addAttribute("artifactList", artifactList);

        return "admin/addArtifact";
    }

    @RequestMapping(value = "/admin/collection/view/{collectionId}/add", method = RequestMethod.POST)
    public String add(@PathVariable int collectionId,
                      @ModelAttribute("artifact") @RequestParam("artifact.name") int id,
                      ArtifactCollectionEntity artifactCollectionEntity) {

        artifactCollectionEntity.setCollectionId(collectionId);
        artifactCollectionEntity.setArtifactId(id);
        arCoRepository.saveAndFlush(artifactCollectionEntity);

        return "redirect:/admin/collection";
    }

    @RequestMapping(value = "/admin/collection/view/{collectionId}/addc", method = RequestMethod.GET)
    public String addCollectionInfo(@PathVariable int collectionId, ModelMap modelMap) {


        List<CollectionEntity> collectionList = collectionRepository.findAll();

        modelMap.addAttribute("collectionId", collectionId);

        modelMap.addAttribute("collectionList", collectionList);

        return "/admin/addCollection";
    }

    @RequestMapping(value = "/admin/collection/view/{collectionId}/addc", method = RequestMethod.POST)
    public String addCollection(@PathVariable int collectionId,
                                @ModelAttribute("collection") @RequestParam("collection.name") int id,
                                SubcollectionEntity subcollectionEntity){

        String name = collectionRepository.name(id);
        subcollectionEntity.setId(id);
        subcollectionEntity.setPid(collectionId);
        subcollectionEntity.setName(name);
        subCollectionRepository.saveAndFlush(subcollectionEntity);

        return "/admin/collection";
    }
}

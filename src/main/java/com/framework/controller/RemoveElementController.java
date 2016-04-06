package com.framework.controller;

/**
 * Created by WangYudan on 2016/4/3.
 */

import com.framework.model.ArtifactEntity;
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
public class RemoveElementController {

    @Autowired
    CollectionRepository collectionRepository;

    @Autowired
    ArtifactRepository artifactRepository;

    @Autowired
    ArCoRepository arCoRepository;

    @Autowired
    SubCollectionRepository subCollectionRepository;

    @RequestMapping(value = "/admin/collection/view/{collectionId}/remove", method = RequestMethod.GET)
    public String removeInfo(@PathVariable int collectionId, ModelMap modelMap){

        List<ArtifactEntity> artifactList = artifactRepository.info(collectionId);
        modelMap.addAttribute("collectionId", collectionId);
        modelMap.addAttribute("artifactList", artifactList);
        return "admin/removeArtifact";
    }
    @RequestMapping(value = "/admin/collection/view/{collectionId}/remove", method = RequestMethod.POST)
    public String removeArtifact(@PathVariable int collectionId,@ModelAttribute("artifact") @RequestParam("artifact.name") int id){

        int idd = arCoRepository.removeId(id,collectionId);
        arCoRepository.delete(idd);
        arCoRepository.flush();
        return "redirect:/admin/collection/view/" + collectionId;
    }

    @RequestMapping(value = "/admin/collection/view/{collectionId}/removec", method = RequestMethod.GET)
    public String removeCollectionInfo(@PathVariable int collectionId, ModelMap modelMap){

        List<SubcollectionEntity> collectionList = subCollectionRepository.sublist(collectionId);
        modelMap.addAttribute("collectionId", collectionId);
        modelMap.addAttribute("collectionList", collectionList);
        return "admin/removeCollection";
    }

    @RequestMapping(value = "/admin/collection/view/{collectionId}/removec", method = RequestMethod.POST)
    public String removeCollection(@PathVariable int collectionId,
                                   @ModelAttribute("collection") @RequestParam("collection.name") int id,
                                   SubcollectionEntity subcollectionEntity){
        subCollectionRepository.delete(id);
        subCollectionRepository.flush();
        return "redirect:/admin/collection/view/" + collectionId;
    }
}

package com.framework.controller;

/**
 * Created by WangYudan on 2016/3/30.
 */

import com.framework.model.ArtifactEntity;
import com.framework.model.SubcollectionEntity;
import com.framework.repository.ArtifactRepository;
import com.framework.repository.CollectionRepository;
import com.framework.repository.SubCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SharedCollectionController {

    @Autowired
    CollectionRepository collectionRepository;

    @Autowired
    ArtifactRepository artifactRepository;

    @Autowired
    SubCollectionRepository subCollectionRepository;


    @RequestMapping(method = RequestMethod.POST, value = "/admin/collection/shared")
    public String shared(@ModelAttribute("collection") @RequestParam("token") String token ,
                         ModelMap modelMap) {

        List keys = collectionRepository.key();

        if (keys.contains(token)) {

            int id = collectionRepository.id(token);

            List<ArtifactEntity> artifactList = artifactRepository.info(id);

            List<SubcollectionEntity> subcollectionList = subCollectionRepository.sublist(id);

            modelMap.addAttribute("artifactList", artifactList);

            modelMap.addAttribute("subcollectionList", subcollectionList);

            modelMap.addAttribute("collectionId", id);

            return "admin/collectionInfo";
        }
        else{
            return "redirect:/admin/collection";
        }
    }
}

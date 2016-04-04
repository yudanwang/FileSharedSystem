package com.framework.controller;

/**
 * Created by WangYudan on 2016/3/30.
 */

import com.framework.model.ArtifactEntity;
import com.framework.repository.ArtifactRepository;
import com.framework.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SharedCollectionController {

    @Autowired
    CollectionRepository collectionRepository;

    @Autowired
    ArtifactRepository artifactRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/admin/collection/shared")
    public String shared(@ModelAttribute("collection") @RequestParam("token")
                                 String token, ModelMap modelMap) {

        List keys = collectionRepository.key();

        if (keys.contains(token)) {

            int id = collectionRepository.id(token);

            List<ArtifactEntity> artifactList = artifactRepository.info(id);

            modelMap.addAttribute("artifactList", artifactList);

            return "admin/collectionInfo";
        }
        else{
            return "redirect:/admin/collection";
        }
    }
}

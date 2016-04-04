package com.framework.controller;

/**
 * Created by WangYudan on 2016/3/16.
 */

import com.framework.model.ArtifactCollectionEntity;
import com.framework.model.ArtifactEntity;
import com.framework.repository.ArCoRepository;
import com.framework.repository.ArtifactRepository;
import com.framework.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {

    @Autowired
    ArtifactRepository artifactRepository;

    @Autowired
    CollectionRepository collectionRepository;

    @Autowired
    ArCoRepository arCoRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/admin/collection/view/{id}/upload")
    public String provideUploadInfo(@PathVariable("id") int collectionId, ModelMap modelMap) {

        modelMap.addAttribute("collectionId", collectionId);
        return "admin/fileupload";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/admin/collection/view/{collectionId}/upload")
    public String fileUpload(@PathVariable int collectionId, @RequestParam("fileUpload") @ModelAttribute("artifact")
            CommonsMultipartFile file, ArtifactEntity artifactEntity, ArtifactCollectionEntity acEntity, ModelMap modelMap) {

        modelMap.addAttribute("collectionId", Integer.valueOf(collectionId));

        System.out.println(file.getContentType());
        System.out.println(file.getSize());
        System.out.println(file.getOriginalFilename());

        if (!file.isEmpty()) {

            String path = "D:/" + file.getOriginalFilename();
            File localFile = new File(path);
            try {
                file.transferTo(localFile);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        artifactEntity.setName(file.getOriginalFilename());
        int id = (int) (Math.random() * 1000);
        artifactEntity.setId(id);
        artifactRepository.saveAndFlush(artifactEntity);

        acEntity.setArtifactId(id);
        acEntity.setCollectionId(collectionId);
        arCoRepository.saveAndFlush(acEntity);
        return "/admin/collection";
    }
}



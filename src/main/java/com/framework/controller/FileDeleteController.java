package com.framework.controller;

/**
 * Created by WangYudan on 2016/3/18.
 */

import com.framework.model.ArtifactEntity;
import com.framework.repository.ArtifactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;

@Controller
public class FileDeleteController {

    @Autowired
    ArtifactRepository artifactRepository;

    @RequestMapping(value = "/admin/artifact/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") Integer artifactId) {

        ArtifactEntity artifactEntity = artifactRepository.findOne(artifactId);
        String name = artifactEntity.getName();
        File deletefile = new File("D:/" + name);
        deletefile.delete();

        artifactRepository.delete(artifactId);
        artifactRepository.flush();
        return "redirect:/admin/artifact";
    }
}

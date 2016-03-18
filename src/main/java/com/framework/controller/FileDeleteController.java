package com.framework.controller;

/**
 * Created by WangYudan on 2016/3/18.
 */

import com.framework.model.ArtifactEntity;
import com.framework.repository.ArtifactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FileDeleteController {

    @Autowired
    ArtifactRepository artifactRepository;

    @RequestMapping(value = "/artifact/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") Integer artifactId) {

        ArtifactEntity artifactEntity = artifactRepository.findOne(artifactId);
        String name = artifactEntity.getName();
        File deletefile = new File("D:/" + name);
        deletefile.delete();
        
        artifactRepository.delete(artifactId);
        artifactRepository.flush();
        return "redirect:/artifact";
    }
}

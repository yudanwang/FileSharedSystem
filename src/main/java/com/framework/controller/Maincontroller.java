package com.framework.controller;

/**
 * Created by WangYudan on 2016/3/15.
 */

import com.framework.model.ArtifactEntity;
import com.framework.repository.ArtifactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class Maincontroller {
    @Autowired
    ArtifactRepository artifactRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/artifact", method = RequestMethod.GET)
    public String getUsers(ModelMap modelMap) {

        List<ArtifactEntity> artifactList = artifactRepository.findAll();
        long a = artifactRepository.count();
        modelMap.addAttribute("artifactList", artifactList);

        return "artifact";
    }
}

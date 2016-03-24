package com.framework.controller;

import com.framework.model.ArtifactEntity;
import com.framework.repository.ArtifactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import java.io.File;
import java.io.IOException;

/**
 * Created by WangYudan on 2016/3/19.
 */

@Controller
public class FileUpdateController {

    @Autowired
    ArtifactRepository artifactRepository;

    @RequestMapping(value = "/artifact/update/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") Integer artifactId) {

        ArtifactEntity artifactEntity = artifactRepository.findOne(artifactId);
        String name = artifactEntity.getName();
        File deletefile = new File("D:/" + name);
        deletefile.delete();
        return "fileupdate";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public String fileUpload(@RequestParam("fileUpdate")
                             CommonsMultipartFile file) {


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
        return "redirect:artifact";
    }
}

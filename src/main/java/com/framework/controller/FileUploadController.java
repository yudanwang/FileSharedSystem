package com.framework.controller;

/**
 * Created by WangYudan on 2016/3/16.
 */

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.framework.model.ArtifactEntity;
import com.framework.repository.ArtifactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileUploadController {

    @Autowired
    ArtifactRepository artifactRepository;

    public static String ROOT = "upload-dir";

    @RequestMapping(method = RequestMethod.GET, value = "/upload")
    public String provideUploadInfo(Model model){
        return "fileupload";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/upload")
    public String fileUpload(@RequestParam("fileUpload") @ModelAttribute("artifact")
                                 CommonsMultipartFile file, ArtifactEntity artifactEntity) {

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
        int id = (int)(Math.random()*1000);
        artifactEntity.setId(id);
        artifactRepository.saveAndFlush(artifactEntity);
        return "redirect:artifact";
    }
}



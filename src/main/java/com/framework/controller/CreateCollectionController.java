package com.framework.controller;


import com.framework.model.CollectionEntity;
import com.framework.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.List;
import java.util.Random;

/**
 * Created by Abi on 2016-03-22.
 */
@Controller
public class CreateCollectionController {

    @Autowired
    CollectionRepository collectionRepository;


    @RequestMapping(method = RequestMethod.GET, value = "/admin/collection")
    public String provideUploadInfo(ModelMap modelMap) {

        List<CollectionEntity> collectionList = collectionRepository.findAll();
        long c = collectionRepository.count();
        modelMap.addAttribute("collectionList", collectionList);

        return "/admin/collection";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/admin/collection")
    public String addCollection(@ModelAttribute("collection") @RequestParam("txtCollection")
                                        String name, CollectionEntity collectionEntity) {

        String path = "D:/" + name;
        File fileDir = new File(path);
        fileDir.mkdir();

        collectionEntity.setName(name);
        int id = (int) (Math.random() * 1000);
        collectionEntity.setId(id);

        String key = getToken(10);
        collectionEntity.setKey(key);

        collectionRepository.saveAndFlush(collectionEntity);
        return "redirect:/admin/collection";
    }

    private static final Random random = new Random();
    private static final String CHAR = "abcdefghijkmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ234567890!@#$";

    public static String getToken(int length) {
        StringBuilder token = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            token.append(CHAR.charAt(random.nextInt(CHAR.length())));
        }
        return token.toString();
    }
}
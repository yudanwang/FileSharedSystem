package com.framework.controller;

import com.framework.model.ArtifactCollectionEntity;
import com.framework.model.CollectionEntity;
import com.framework.model.SubcollectionEntity;
import com.framework.repository.ArCoRepository;
import com.framework.repository.CollectionRepository;
import com.framework.repository.SubCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.File;
import java.util.List;

@Controller
public class DeleteCollectionController {

    @Autowired
    CollectionRepository collectionRepository;

    @Autowired
    SubCollectionRepository subCollectionRepository;

    @Autowired
    ArCoRepository arCoRepository;

    @RequestMapping(value = "/admin/collection/delete/{id}", method = RequestMethod.GET)
    public String deleteCollection(@PathVariable("id") Integer collectionId) {

        CollectionEntity collectionEntity = collectionRepository.findOne(collectionId);
        String name = collectionEntity.getName();

        List<SubcollectionEntity> subCollection = subCollectionRepository.sublist(collectionId);
        List<String> subCollectionList = subCollectionRepository.name(collectionId);
        List<CollectionEntity> collection = collectionRepository.deleteCollection(collectionId);
        List<ArtifactCollectionEntity> arco = arCoRepository.artilist(collectionId);

        int[] cid = new int[subCollectionList.size()];

        if (!subCollection.isEmpty()){
            for(int i=0; i<=subCollectionList.size()-1;i++){
                String na = subCollectionList.get(i);
                cid[i] = collectionRepository.deleteId(na);
                deleteFile(na);

            }
            subCollectionRepository.delete(subCollection);

            for(int i =0; i<= cid.length-1; i++){
                System.out.println(i);
                collectionRepository.delete(cid[i]);
                collectionRepository.flush();
            }
            arCoRepository.delete(arco);

        }
        deleteFile(name);
        collectionRepository.delete(collectionId);
        collectionRepository.flush();

        return "redirect:/admin/collection";

    }
    public static void deleteFile(String name){
        String path = "D:/" + name;
        File fileDir = new File(path);
        fileDir.delete();
    }
}



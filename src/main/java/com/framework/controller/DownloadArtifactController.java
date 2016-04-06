package com.framework.controller;

/**
 * Created by WangYudan on 2016/3/19.
 */

import com.framework.model.ArtifactEntity;
import com.framework.repository.ArtifactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class DownloadArtifactController {

    @Autowired
    ArtifactRepository artifactRepository;

    private static final int BUFFER_SIZE = 4096;

    @RequestMapping(value = "/admin/artifact/download/{id}", method = RequestMethod.GET)
    public String download(@PathVariable("id") Integer artifactId,
                           HttpServletRequest request,
                           HttpServletResponse response) throws IOException {

        ArtifactEntity artifactEntity = artifactRepository.findOne(artifactId);
        String name = artifactEntity.getName();
        File downloadFile = new File("D:/" + name);
        FileInputStream inputStream = new FileInputStream(downloadFile);
        response.setContentLength((int) downloadFile.length());

        // set headers for the response
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                downloadFile.getName());
        response.setHeader(headerKey, headerValue);

        // get output stream of the response
        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;

        // write bytes read from the input stream into the output stream
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outStream.close();

        return "redirect:/admin/artifact";
    }
}

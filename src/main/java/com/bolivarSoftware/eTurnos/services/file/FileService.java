package com.bolivarSoftware.eTurnos.services.file;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileService {

    @Value("${folderBanners}")
    private String folderBanners;  //= "C:\\Program Files (x86)\\Apache Software Foundation\\Apache2.2\\htdocs\\banners";

    public void save(MultipartFile file) {
        if (file.isEmpty())
            return;
        try {

            File fileImage = this.getVersionFile(file);
            file.transferTo(fileImage);

        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
    }

    public File getVersionFile(MultipartFile file) {
        Integer version = 1;
        File theDir = new File(folderBanners);
        if (!theDir.exists())
            theDir.mkdir();
        theDir = new File(folderBanners, file.getOriginalFilename());

        while (theDir.exists()) {
            theDir = new File(folderBanners, getFileName(theDir) + "_V" + version + "." + getFileExtension(theDir));
            version++;
        }

        return theDir;
    }

    public String getFileExtension(File file) {
        return file.getName().substring(file.getName().lastIndexOf(".") + 1);
    }


    public String getFileName(File file) {
        return file.getName().substring(0, file.getName().lastIndexOf("."));
    }
}

package com.bolivarSoftware.eTurnos.web.banner;

import com.bolivarSoftware.eTurnos.domain.Banner;
import com.bolivarSoftware.eTurnos.services.file.FileService;
import com.bolivarSoftware.eTurnos.services.interfaces.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Fede Beron on 23/9/2017.
 */
@Controller
@RequestMapping("bannerUpload")
public class BannerUploadController {

    @Autowired
    private FileService fileService;

    @Autowired
    private IBannerService bannerService;

    @RequestMapping("uploadFile")
    public String uploadFile(@ModelAttribute("banner") Banner banner) {
        fileService.save(banner.getFile());
        banner.setNombreDeLaImagen(banner.getFile().getOriginalFilename());
        bannerService.save(banner);

        return "redirect:/banner/list";
    }

}

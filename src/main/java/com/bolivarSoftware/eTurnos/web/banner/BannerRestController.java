package com.bolivarSoftware.eTurnos.web.banner;

import com.bolivarSoftware.eTurnos.domain.Banner;
import com.bolivarSoftware.eTurnos.services.interfaces.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("restBanner")
public class BannerRestController {

    @Autowired
    private IBannerService bannerService;

    @RequestMapping("list")
    public @ResponseBody List<Banner> getBanners(){
        return bannerService.obtenerBannerAPublicar();
    }
}

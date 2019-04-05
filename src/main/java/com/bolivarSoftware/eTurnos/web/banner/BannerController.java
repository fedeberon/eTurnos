package com.bolivarSoftware.eTurnos.web.banner;


import com.bolivarSoftware.eTurnos.domain.Banner;
import com.bolivarSoftware.eTurnos.services.file.FileService;
import com.bolivarSoftware.eTurnos.services.interfaces.IBannerService;
import com.bolivarSoftware.eTurnos.websocket.IWebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("banner")
public class BannerController {

    @Autowired
    private FileService fileService;

    @Autowired
    private IBannerService bannerService;

    @Autowired
    private IWebSocketService webSocketService;


    @RequestMapping("list")
    public String list(@RequestParam(defaultValue = "1") Integer page, Model model){
        model.addAttribute("banners", bannerService.findAll(page));
        model.addAttribute("page", page);

        return "banner/list";
    }

    @RequestMapping("formUpload")
    public String formUpload() {
        return "banner/formUpload";
    }

    @ModelAttribute("banner")
    public Banner getBanner() {
        return new Banner();
    }

    @RequestMapping("buscar")
    public String buscar(@RequestParam String valor, Model model) {
        model.addAttribute("banners", bannerService.buscar(valor));

        return "banner/list";
    }

    @RequestMapping("publicar")
    public String publicar(@RequestParam Long id){
        bannerService.publicar(id);
        webSocketService.actualizarVideosCartel();
        return "redirect:list";
    }

    @RequestMapping("noPublicar")
    public String noPublicar(@RequestParam Long id){
        bannerService.noPublicar(id);
        webSocketService.actualizarVideosCartel();
        return "redirect:list";
    }

}

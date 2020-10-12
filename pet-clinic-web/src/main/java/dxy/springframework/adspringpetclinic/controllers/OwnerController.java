package dxy.springframework.adspringpetclinic.controllers;

import dxy.springframework.adspringpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author AD
 * @date 2020/10/10
 */
@RequestMapping("/owners")
@Controller
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"","/index","/index.html"})
    public String listOwners(Model model){
        model.addAttribute("owners",ownerService.findAll());
        return "owners/index";
    }
}

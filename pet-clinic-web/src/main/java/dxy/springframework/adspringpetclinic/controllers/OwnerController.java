package dxy.springframework.adspringpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author AD
 * @date 2020/10/10
 */
@RequestMapping("/owners")
@Controller
public class OwnerController {
    @RequestMapping({"","/index","/index.html"})
    public String listOwners(){
        return "owners/index";
    }
}

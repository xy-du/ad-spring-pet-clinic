package dxy.springframework.adspringpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author AD
 * @date 2020/10/10
 */
@Controller
public class VetController {

    @RequestMapping({"vets","vets/index","vets/index.html"})
    public String listVets(){
        return "/vets/index";
    }
}

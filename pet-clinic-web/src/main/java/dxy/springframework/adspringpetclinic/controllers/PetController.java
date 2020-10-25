package dxy.springframework.adspringpetclinic.controllers;

import dxy.springframework.adspringpetclinic.model.Owner;
import dxy.springframework.adspringpetclinic.model.PetType;
import dxy.springframework.adspringpetclinic.services.OwnerService;
import dxy.springframework.adspringpetclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @author AD
 * @date 2020/10/25
 */
@Controller
@RequestMapping("/owners/{ownersId}")
public class PetController {
    private PetTypeService petTypeService;
    private OwnerService ownerService;


    public PetController(PetTypeService petTypeService, OwnerService ownerService) {
        this.petTypeService = petTypeService;
        this.ownerService = ownerService;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable Long OwnerId) {
        return ownerService.findById(OwnerId);
    }

    @InitBinder
    public void initOwnerBind(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

}

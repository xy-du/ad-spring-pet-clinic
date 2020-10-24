package dxy.springframework.adspringpetclinic.controllers;

import dxy.springframework.adspringpetclinic.model.Owner;
import dxy.springframework.adspringpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    @InitBinder
    public void setAllowedField(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }

    @RequestMapping({"", "/index", "/index.html"})
    public String listOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners() {
        return "/notimplemented";
    }

    @RequestMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable Long ownerId) {
        Owner owner = ownerService.findById(ownerId);
        ModelAndView modelAndView = new ModelAndView("owners/ownerDetails");
        modelAndView.addObject(owner);
        return modelAndView;
    }

    @GetMapping("/find")
    public String findOwners(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return "/owners/findOwners";
    }

    @GetMapping("")
    public String processFindForm(Owner owner, BindingResult bindingResult, Model model) {
        if (owner.getLastName() == null) {
            owner.setLastName("");
        }

        List<Owner> ownerList = ownerService.findAllByLastNameLike("%"+owner.getLastName()+"%");

        if (ownerList.isEmpty()) {
            bindingResult.rejectValue("lastName", "notFound", "not found");
            return "/owners/findOwners";
        } else if (ownerList.size() == 1) {
            Owner ownerFound = ownerList.get(0);
            return "redirect:/owners/" + ownerFound.getId();
        } else {
            model.addAttribute("selections", ownerList);
            return "/owners/ownerList";
        }

    }

}

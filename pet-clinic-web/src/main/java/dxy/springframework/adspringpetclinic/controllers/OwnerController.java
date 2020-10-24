package dxy.springframework.adspringpetclinic.controllers;

import dxy.springframework.adspringpetclinic.model.Owner;
import dxy.springframework.adspringpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
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
    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";


    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedField(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
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

        List<Owner> ownerList = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");

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

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        Owner owner = Owner.builder().build();
        model.addAttribute("owner", owner);
        return "owners/createOrUpdateOwnerForm";
    }


    @PostMapping("/new")
    public String processCreationForm(Owner owner, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable Long ownerId, Model model) {
        Owner owner = ownerService.findById(ownerId);
        model.addAttribute("owner", owner);
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(@PathVariable Long ownerId, Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            owner.setId(ownerId);
            Owner updatedOwner = ownerService.save(owner);
            return "redirect:/owners/" + updatedOwner.getId();
        }
    }


}

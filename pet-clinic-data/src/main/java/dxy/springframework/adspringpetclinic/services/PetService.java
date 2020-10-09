package dxy.springframework.adspringpetclinic.services;

import dxy.springframework.adspringpetclinic.model.Pet;

import java.util.Set;

/**
 * @author AD
 * @date 2020/10/09
 */
public interface PetService {
    Pet findById(long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}

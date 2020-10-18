package dxy.springframework.adspringpetclinic.services.springdatajpa;

import dxy.springframework.adspringpetclinic.model.Pet;
import dxy.springframework.adspringpetclinic.repositories.PetRepository;
import dxy.springframework.adspringpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author AD
 * @date 2020/10/18
 */

@Service
@Profile("springdatajpa")
public class PetTypeService implements PetService {

    private final PetRepository petRepository;

    public PetTypeService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets=new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}

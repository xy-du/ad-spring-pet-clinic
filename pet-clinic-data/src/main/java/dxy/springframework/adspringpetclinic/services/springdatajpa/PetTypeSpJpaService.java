package dxy.springframework.adspringpetclinic.services.springdatajpa;

import dxy.springframework.adspringpetclinic.model.PetType;
import dxy.springframework.adspringpetclinic.repositories.PetTypeRepository;
import dxy.springframework.adspringpetclinic.services.PetTypeService;
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
public class PetTypeSpJpaService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeSpJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes=new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}

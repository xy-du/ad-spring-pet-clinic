package dxy.springframework.adspringpetclinic.services.map;

import dxy.springframework.adspringpetclinic.model.Owner;
import dxy.springframework.adspringpetclinic.model.Pet;
import dxy.springframework.adspringpetclinic.model.PetType;
import dxy.springframework.adspringpetclinic.services.OwnerService;
import dxy.springframework.adspringpetclinic.services.PetService;
import dxy.springframework.adspringpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author AD
 * @date 2020/10/10
 */
@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            Set<Pet> pets = object.getPets();
            if (pets != null && pets.size() != 0) {
                pets.forEach(pet -> {
                    PetType petType = pet.getPetType();
                    if (petType != null) {
                        if (petType.getId() == null) {
                            pet.setPetType(petTypeService.save(petType));
                        }
                    } else {
                        throw new RuntimeException("PetType Required");
                    }
                    if (pet.getId() == null) {
                        Pet savingPet = petService.save(pet);
                        savingPet.setId(savingPet.getId());
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }


}

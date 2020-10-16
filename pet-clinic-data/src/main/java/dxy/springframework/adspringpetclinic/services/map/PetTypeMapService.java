package dxy.springframework.adspringpetclinic.services.map;

import dxy.springframework.adspringpetclinic.model.PetType;
import dxy.springframework.adspringpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author AD
 * @date 2020/10/16
 */
@Service
public class PetTypeMapService extends AbstractMapService<PetType,Long> implements PetTypeService {

    @Override
    public Set<PetType> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(PetType object) {

    }

    @Override
    public PetType save(PetType object) {
        return null;
    }

    @Override
    public PetType findById(Long id) {
        return null;
    }
}

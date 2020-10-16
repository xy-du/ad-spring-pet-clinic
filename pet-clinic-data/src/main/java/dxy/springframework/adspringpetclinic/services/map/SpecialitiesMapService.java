package dxy.springframework.adspringpetclinic.services.map;

import dxy.springframework.adspringpetclinic.model.Speciality;
import dxy.springframework.adspringpetclinic.services.SpecialitiesService;

import java.util.Set;

/**
 * @author AD
 * @date 2020/10/16
 */
public class SpecialitiesMapService extends AbstractMapService<Speciality,Long> implements SpecialitiesService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}

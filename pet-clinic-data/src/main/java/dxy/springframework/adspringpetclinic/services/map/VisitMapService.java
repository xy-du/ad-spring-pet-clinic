package dxy.springframework.adspringpetclinic.services.map;

import dxy.springframework.adspringpetclinic.model.Visit;
import dxy.springframework.adspringpetclinic.services.VisitService;

import java.util.Set;

/**
 * @author AD
 * @date 2020/10/18
 */
public class VisitMapService extends AbstractMapService<Visit,Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit object) {
        if(object.getPet()==null||object.getPet().getOwner()==null||object.getPet().getOwner().getId()==null
        ||object.getPet().getId()==null){
            throw new RuntimeException("Invalid Data Object");
        }
        return super.save(object);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}

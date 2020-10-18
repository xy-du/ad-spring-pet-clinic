package dxy.springframework.adspringpetclinic.repositories;

import dxy.springframework.adspringpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * @author AD
 * @date 2020/10/18
 */
public interface OwnerRepository extends CrudRepository<Owner,Long> {
}

package dxy.springframework.adspringpetclinic.repositories;

import dxy.springframework.adspringpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author AD
 * @date 2020/10/18
 */
public interface OwnerRepository extends CrudRepository<Owner,Long> {
    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}

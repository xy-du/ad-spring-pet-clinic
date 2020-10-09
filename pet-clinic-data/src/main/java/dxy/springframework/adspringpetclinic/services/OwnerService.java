package dxy.springframework.adspringpetclinic.services;

import dxy.springframework.adspringpetclinic.model.Owner;

import java.util.Set;

/**
 * @author AD
 * @date 2020/10/09
 */
public interface OwnerService {
    Owner findByLastName(String lastName);

    Owner findById(long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}

package dxy.springframework.adspringpetclinic.services;

import dxy.springframework.adspringpetclinic.model.Owner;

/**
 * @author AD
 * @date 2020/10/09
 */
public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}

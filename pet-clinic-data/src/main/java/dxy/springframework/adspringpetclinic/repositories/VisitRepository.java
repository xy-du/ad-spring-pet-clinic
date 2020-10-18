package dxy.springframework.adspringpetclinic.repositories;

import dxy.springframework.adspringpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

/**
 * @author AD
 * @date 2020/10/18
 */
public interface VisitRepository extends CrudRepository<Visit,Long> {
}

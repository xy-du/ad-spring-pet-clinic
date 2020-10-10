package dxy.springframework.adspringpetclinic.services;

import java.util.Set;

/**
 * @author AD
 * @date 2020/10/10
 */
public interface CrudService<T, ID> {
    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}

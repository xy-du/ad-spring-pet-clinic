package dxy.springframework.adspringpetclinic.services;

import dxy.springframework.adspringpetclinic.model.Vet;

import java.util.Set;

/**
 * @author AD
 * @date 2020/10/09
 */
public interface VetService {
    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}

package dxy.springframework.adspringpetclinic.services.springdatajpa;

import dxy.springframework.adspringpetclinic.model.Vet;
import dxy.springframework.adspringpetclinic.repositories.VetRepository;
import dxy.springframework.adspringpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author AD
 * @date 2020/10/18
 */
@Service
@Profile(("springdatajpa"))
public class VetSpJpaService implements VetService {
    private final VetRepository vetRepository;

    public VetSpJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}

package dxy.springframework.adspringpetclinic.services.springdatajpa;

import dxy.springframework.adspringpetclinic.model.Owner;
import dxy.springframework.adspringpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


/**
 * @author AD
 * @date 2020/10/20
 */

@ExtendWith(MockitoExtension.class)
class OwnerSpJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSpJpaService ownerSpJpaService;

    Long id = 1L;

    String lastName = "smith";

    Owner resOwner;

    @BeforeEach
    void setUp() {
        resOwner = Owner.builder().lastName(lastName).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(resOwner);

        Owner owner = ownerSpJpaService.findByLastName(lastName);

        assertEquals(lastName, owner.getLastName());

        verify(ownerRepository, times(1)).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        Owner owner1 = Owner.builder().id(1L).build();
        Owner owner2 = Owner.builder().id(2L).build();
        owners.add(owner1);
        owners.add(owner2);

        when(ownerRepository.findAll()).thenReturn(owners);


        assertNotNull(ownerSpJpaService.findAll());
        assertEquals(2, ownerSpJpaService.findAll().size());
    }

    @Test
    void findById() {
        Owner owner = Owner.builder().id(id).build();
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));

        Owner resOwner = ownerSpJpaService.findById(id);

        assertNotNull(resOwner);
        assertEquals(id, resOwner.getId());

    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner resOwner = ownerSpJpaService.findById(anyLong());

        assertNull(resOwner);
    }

    @Test
    void save() {
        Owner saveOwner = Owner.builder().build();

        when(ownerRepository.save(any())).thenReturn(resOwner);

        Owner owner = ownerSpJpaService.save(saveOwner);

        assertEquals(resOwner, owner);
    }

    @Test
    void delete() {
        ownerSpJpaService.delete(new Owner());
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSpJpaService.deleteById(id);
        verify(ownerRepository, times(1)).deleteById(anyLong());
    }
}
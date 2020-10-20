package dxy.springframework.adspringpetclinic.services.map;

import dxy.springframework.adspringpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author AD
 * @date 2020/10/20
 */
class OwnerMapServiceTest {

    private OwnerMapService ownerMapService;

    private static final String lastName = "smith";
    private static final Long id = 1L;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(id).lastName(lastName).build());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(lastName);
        assertNotNull(owner);
        assertEquals(lastName, owner.getLastName());
    }

    @Test
    void findAll() {
        assertEquals(1, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(id);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(id));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void saveExistingID() {
        Long id = 2L;
        Owner owner = new Owner();
        owner.setId(id);
        Owner savedOwner = ownerMapService.save(owner);
        assertNotNull(savedOwner);
        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoID() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(id);
        assertNotNull(owner);
        assertEquals(id, owner.getId());
    }
}
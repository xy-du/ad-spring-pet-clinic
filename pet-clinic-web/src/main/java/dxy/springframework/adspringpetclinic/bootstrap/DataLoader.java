package dxy.springframework.adspringpetclinic.bootstrap;

import dxy.springframework.adspringpetclinic.model.*;
import dxy.springframework.adspringpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;

/**
 * @author AD
 * @date 2020/10/12
 */
@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (petTypeService.findAll().size() == 0) {
            loadData();
        }
    }

    private void loadData() {

        System.out.println("Loaded Owners and Pets....");

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType dogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType catType = petTypeService.save(cat);


        /*
         add @Builder on the Owner entity can give you this approach, but the firstName and lastName
         are inherited from parent class and require special treatment about the Constructor method.
         for details, have a look at Entity Class Owner, Person, BaseEntity.
         */
        Owner owner1 = Owner.builder().firstName("Michael").lastName("Weston").address("123 Brickerel").city("Miami")
                .telephone("1231231234").pets(new HashSet<>()).build();

//        Owner owner1 = new Owner();
//        owner1.setFirstName("Michael");
//        owner1.setLastName("Weston");
//        owner1.setAddress("123 Brickerel");
//        owner1.setCity("Miami");
//        owner1.setTelephone("1231231234");

        Pet mikeDog = new Pet();
        mikeDog.setPetType(dogType);
        mikeDog.setBirthDate(LocalDate.now());
        mikeDog.setName("mike-dog");
        mikeDog.setOwner(owner1);
        owner1.getPets().add(mikeDog);


        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("1231231234");

        Pet fionasCat = new Pet();
        fionasCat.setName("fionas-cat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(catType);
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        System.out.println("Loaded Vets and Specialities....");

        Speciality surgerySpec = new Speciality();
        surgerySpec.setDescription("surgery");
        specialityService.save(surgerySpec);

        Speciality radiologySpec = new Speciality();
        radiologySpec.setDescription("radiology");
        specialityService.save(radiologySpec);

        Speciality dentistrySpec = new Speciality();
        dentistrySpec.setDescription("dentistry");
        specialityService.save(dentistrySpec);


        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(surgerySpec);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(radiologySpec);

        vetService.save(vet2);

        System.out.println("Load Visit....");

        Visit catVisit = new Visit();
        catVisit.setPet(fionasCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);
    }
}

package dxy.springframework.adspringpetclinic.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author AD
 * @date 2020/10/09
 */
public class Vet extends Person {
    private Set<Speciality> specialities=new HashSet<>();

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}

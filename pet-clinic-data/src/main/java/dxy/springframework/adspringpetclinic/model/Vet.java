package dxy.springframework.adspringpetclinic.model;

import java.util.Set;

/**
 * @author AD
 * @date 2020/10/09
 */
public class Vet extends Person {
    private Set<Speciality> specialities;

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}

package dxy.springframework.adspringpetclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author AD
 * @date 2020/10/09
 */
@MappedSuperclass
public class Person extends BaseEntity{
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

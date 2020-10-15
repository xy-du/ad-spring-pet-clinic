package dxy.springframework.adspringpetclinic.model;

/**
 * @author AD
 * @date 2020/10/15
 */
public class Speciality extends BaseEntity {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

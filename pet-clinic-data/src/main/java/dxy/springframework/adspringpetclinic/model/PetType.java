package dxy.springframework.adspringpetclinic.model;

/**
 * @author AD
 * @date 2020/10/09
 */
public class PetType extends BaseEntity{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

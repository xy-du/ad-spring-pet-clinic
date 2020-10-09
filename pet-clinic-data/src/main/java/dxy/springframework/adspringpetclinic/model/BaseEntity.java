package dxy.springframework.adspringpetclinic.model;

import java.io.Serializable;

/**
 * @author AD
 * @date 2020/10/09
 */
public class BaseEntity implements Serializable {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

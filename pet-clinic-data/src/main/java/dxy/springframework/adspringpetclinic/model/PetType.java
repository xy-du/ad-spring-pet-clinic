package dxy.springframework.adspringpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author AD
 * @date 2020/10/09
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "types")
public class PetType extends BaseEntity{
    @Column(name = "name")
    private String name;
}

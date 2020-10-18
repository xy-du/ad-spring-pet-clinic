package dxy.springframework.adspringpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author AD
 * @date 2020/10/15
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "specialities")
public class Speciality extends BaseEntity {
    @Column(name = "description")
    private String description;
}

package dxy.springframework.adspringpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

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
@Table(name = "pets")
public class Pet extends BaseEntity {
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "birthDate")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits;
}

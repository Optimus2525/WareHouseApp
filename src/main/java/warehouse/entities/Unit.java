package warehouse.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "units")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String unitName;

    @OneToMany(mappedBy = "units")
    private Set<Product> product = new HashSet<>();

    public Unit(String unitName,
                Set<Product> product) {
        this.unitName = unitName;
        this.product = product;
    }
}

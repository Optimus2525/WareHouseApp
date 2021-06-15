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
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String phone;

    @OneToMany(mappedBy = "suppliers")
    private final Set<Product> product = new HashSet<>();

    public Supplier(String name,
                    String address,
                    String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
}

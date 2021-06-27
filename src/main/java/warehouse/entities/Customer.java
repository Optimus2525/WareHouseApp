package warehouse.entities;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String phone;

    @OneToMany(mappedBy = "customers")
    private Set<Order> orders = new HashSet<>();

    public Customer(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
}

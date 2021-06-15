package warehouse.entities;

import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "unit_id", insertable = false, updatable = false)
    private Unit units;

    @ManyToOne
    @JoinColumn(name = "supplier_id", insertable = false, updatable = false)
    private Supplier suppliers;

    @Column
    private Double unitPrice;

    @Column
    private Integer unitsInStock;

    @OneToMany(mappedBy = "product")
    private Set<Cart> cart = new HashSet<>();

    public Product(String name,
                   Unit units,
                   Supplier suppliers,
                   Double unitPrice,
                   Integer unitsInStock,
                   Set<Cart> cart) {
        this.name = name;
        this.units = units;
        this.suppliers = suppliers;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
        this.cart = cart;
    }
}

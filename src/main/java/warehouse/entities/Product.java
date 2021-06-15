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
    private long id;

    @Column
    private String name;

    @Column(name="unit_id")
    private Integer unitId;

    @Column(name="supplier_id")
    private Integer supplierId;

    @Column
    private Double unitPrice;

    @Column
    private Integer unitsInStock;

    @ManyToOne
    @JoinColumn(name = "supplier_id", insertable = false, updatable = false)
    private Supplier suppliers;

    @ManyToOne
    @JoinColumn(name = "unit_id", insertable = false, updatable = false)
    private Unit units;

    @OneToMany(mappedBy = "product")
    private Set<Cart> carts = new HashSet<>();

    public Product(String name,
                   Integer unitId,
                   Integer supplierId,
                   Double unitPrice,
                   Integer unitsInStock,
                   Supplier suppliers,
                   Unit units) {
        this.name = name;
        this.unitId = unitId;
        this.supplierId = supplierId;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
        this.suppliers = suppliers;
        this.units = units;
    }
}

package warehouse.entities;

import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="customer_id")
    private Long customerId;

    @Column
    private Date orderDate;

    @Column
    private Double totalSum;

    @Column
    private Boolean isPaid;

    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private Customer customers;

    @OneToMany(mappedBy = "orders")
    private final Set<Order> carts = new HashSet<>();

    public Order(Long customer_id, Date orderDate, Double totalSum, Boolean isPaid, Customer customers) {
        this.customer_id = customer_id;
        this.orderDate = orderDate;
        this.totalSum = totalSum;
        this.isPaid = isPaid;
        this.customers = customers;
    }
}

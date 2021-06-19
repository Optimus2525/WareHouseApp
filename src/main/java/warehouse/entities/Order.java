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
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private Customer customer;

    @Column
    private Date orderDate;

    @Column
    private Double totalSum;

    @Column
    private Boolean isPaid;

    @OneToMany(mappedBy = "orders")
    private Set<Cart> cart;

    public Order(Customer customer, Date orderDate, Double totalSum, Boolean isPaid, Set<Cart> cart) {
        this.customer = customer;
        this.orderDate = orderDate;
        this.totalSum = totalSum;
        this.isPaid = isPaid;
        this.cart = cart;
    }
}

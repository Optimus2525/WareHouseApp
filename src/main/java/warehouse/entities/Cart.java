package warehouse.entities;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="order_id", insertable = false, updatable = false)
    private Order orders;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @Column
    private Integer quantity;

    public Cart(Order orders, Product product, Integer quantity) {
        this.orders = orders;
        this.product = product;
        this.quantity = quantity;
    }
}

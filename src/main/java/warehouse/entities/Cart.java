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
    private Long id;

    @Column(name="order_id")
    private Integer orderId;

    @Column(name="product_id")
    private Integer productId;

    @Column
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order orders;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Order products;

    public Cart(Integer orderId,
                Integer productId,
                Integer quantity,
                Order orders,
                Order products) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.orders = orders;
        this.products = products;
    }
}

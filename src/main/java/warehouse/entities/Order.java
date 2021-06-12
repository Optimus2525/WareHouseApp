package warehouse.entities;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "product_id")
    private long productId;

    public Order() {
    }

    public Order(long customerId, long productId) {
        this.customerId = customerId;
        this.productId = productId;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Id=" + Id +
                ", customerId=" + customerId +
                ", productId=" + productId +
                '}';
    }
}

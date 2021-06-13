package warehouse.entities;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long customer_id;
    @Column
    private Long product_id;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private Customer customers;

    public Order() {
    }

    public Order(Product product, Customer customer) {
        this.product = product;
        this.customers = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customers;
    }

    public void setCustomer(Customer customer) {
        this.customers = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", product_id=" + product_id +
                ", product=" + product +
                ", customers=" + customers +
                '}';
    }
}

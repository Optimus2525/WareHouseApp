package warehouse.repository;

import org.hibernate.Session;
import warehouse.entities.Order;
import warehouse.entities.Customer;

import java.util.List;

public class OrderRepository<result> extends CrudRepository<Order> {
    private static final String HIBERNATE_SELECT_QUERY = "from Order";

    //private static final String HIBERNATE_SELECT_QUERY = "From Order a, Customer b Where a.customer_id = b.id";

    //private static final String HIBERNATE_SELECT_QUERY =
    //"FROM Order o INNER JOIN Customer c ON o.customer_id = c.id";
    //"FROM Order as o INNER JOIN o.customers as cu";

    private static final String ID_PARAM = "ordersId";

    private static final String DELETE_QUERY = "delete from Order o where o.id = :" + ID_PARAM;

    public void delete(Integer id) {
        runInTransaction((session) ->
                session.createQuery(DELETE_QUERY)
                        .setParameter(ID_PARAM, id)
                        .executeUpdate());
    }

    public Order findOne(Integer id) {
        return super.findOne(id, Order.class);
    }

    public List<Order> findAll() {
        return super.findAll(HIBERNATE_SELECT_QUERY, Order.class);
    }
}

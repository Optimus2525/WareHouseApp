package warehouse.repository;

import warehouse.entities.Customer;
import warehouse.entities.Order;

import java.util.List;

public class OrderRepository extends CrudRepository<Order> {
    private static final String HIBERNATE_SELECT_QUERY = "from Order";

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

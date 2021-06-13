package warehouse.repository;

import warehouse.entities.Customer;

import java.util.List;

public class CustomerRepository extends CrudRepository<Customer> {
    private static final String HIBERNATE_SELECT_QUERY = "from Customer";

    private static final String ID_PARAM = "customersId";
    private static final String DELETE_QUERY = "delete from Customer c where c.id = :" + ID_PARAM;

    public void delete(Long id) {
        runInTransaction((session) ->
                session.createQuery(DELETE_QUERY)
                        .setParameter(ID_PARAM, id)
                        .executeUpdate());
    }

    public Customer findOne(Long id) {
        return super.findOne(id, Customer.class);
    }

    public List<Customer> findAll() {
        return super.findAll(HIBERNATE_SELECT_QUERY, Customer.class);
    }

}

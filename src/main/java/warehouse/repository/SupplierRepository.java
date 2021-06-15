package warehouse.repository;

import warehouse.entities.Supplier;

import java.util.List;

public class SupplierRepository extends CrudRepository<Supplier> {

    private static final String HIBERNATE_SELECT_QUERY = "from Supplier";
    private static final String ID_PARAM = "supplierId";
    private static final String DELETE_QUERY = "delete from Supplier s where s.id = :" + ID_PARAM;

    public void delete(Long id) {
        runInTransaction((session) ->
                session.createQuery(DELETE_QUERY)
                        .setParameter(ID_PARAM, id)
                        .executeUpdate());
    }

    public Supplier findOne(Integer id) {
        return super.findOne(id, Supplier.class);
    }

    public List<Supplier> findAll() {
        return super.findAll(HIBERNATE_SELECT_QUERY, Supplier.class);
    }
}

package warehouse.repository;

import warehouse.entities.Product;
import java.util.List;

public class ProductRepository extends CrudRepository<Product> {
    private static final String HIBERNATE_SELECT_QUERY = "from Product";

    private static final String ID_PARAM = "id";
    private static final String DELETE_QUERY = "delete from Product p where p.id = :" + ID_PARAM;

    public void delete(Integer id) {
        runInTransaction((session) ->
                session.createQuery(DELETE_QUERY)
                        .setParameter(ID_PARAM, id)
                        .executeUpdate());
    }

    public Product findOne(Integer id) {
        return super.findOne(id, Product.class);
    }

    public List<Product> findAll() {
        return super.findAll(HIBERNATE_SELECT_QUERY, Product.class);
    }
}

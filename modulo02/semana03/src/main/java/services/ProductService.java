package services;

import model.dao.ProductDAO;
import model.persistence.Category;
import model.persistence.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.List;

public class ProductService extends JpaService {
    private final ProductDAO productDAO;
    private final CategoryService categoryService;

    public ProductService(EntityManager entityManager) {
        super(entityManager);
        this.productDAO = new ProductDAO(entityManager);
        this.categoryService = new CategoryService(this.entityManager);
    }

    public void save(Product product) {
        if (product == null) {
            this.LOG.error("O Produto informado está nulo!");
            throw new RuntimeException("Product Null!");
        }
        String categoryName = product.getCategory().getName();
        Category category = this.categoryService.findByName(categoryName);

        if (category != null) {
            this.LOG.info("Categoria '" + categoryName + "' encontrada no banco!");
            product.setCategory(category);
        }
        executeInsideTransaction(entityManager -> productDAO.save(product));
    }

    public void delete(Long id) {
        if (id == null) {
            LOG.error("ID esta nulo!");
            throw new RuntimeException("ID is null");
        }

        Product product = productDAO.getById(id);

        if (product == null) {
            LOG.error("Product not exist");
            throw new EntityNotFoundException("Product not found");
        }

        executeInsideTransaction(entityManager -> productDAO.delete(product));
        LOG.info("Product deleted");
    }

    public List<Product> listAll() {
        return productDAO.listAll();
    }
}

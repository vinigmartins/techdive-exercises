package model.dao;

import model.persistence.Product;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.function.Consumer;

public class ProductDAO implements Dao<Product> {
    private EntityManager entityManager = null;

    public ProductDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Override
    public Product find(long id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public void delete(Product product) {
        entityManager.remove(product);
    }

    public Product getById(Long id) {
        return entityManager.find(Product.class, id);
    }

    public List<Product> listAll() {
        String jpql = "SELECT p FROM Product p";
        return entityManager.createQuery(jpql, Product.class).getResultList();
    }

    public List<Product> listByName(String name) {
        String jpql = "SELECT p FROM Product p WHERE p.name =:name";
        return entityManager.createQuery(jpql, Product.class).setParameter("name", name).getResultList();
    }

    public List<Product> listByCategoryName(String categoryName) {
        String jpql = "SELECT p FROM Product p WHERE p.category.name =:categoryName";
        return entityManager.createQuery(jpql, Product.class).setParameter("categoryName", categoryName).getResultList();
    }
}

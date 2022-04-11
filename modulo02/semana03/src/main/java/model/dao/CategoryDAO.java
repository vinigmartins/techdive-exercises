package model.dao;

import model.persistence.Category;

import javax.persistence.EntityManager;

public class CategoryDAO implements Dao<Category> {
    private final EntityManager entityManager;

    public CategoryDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Category category) {
        entityManager.persist(category);
    }

    @Override
    public void update(Category category) {
        entityManager.merge(category);
    }

    @Override
    public Category find(long id) {
        return entityManager.find(Category.class, id);
    }

    @Override
    public void delete(Category category) {
        entityManager.remove(category);
    }

    public Category findByName(String name) {
        String sql = "SELECT * FROM Category WHERE name =:name";
        return (Category) entityManager.createNativeQuery(sql, Category.class).setParameter("name", name).getSingleResult();
    }
}

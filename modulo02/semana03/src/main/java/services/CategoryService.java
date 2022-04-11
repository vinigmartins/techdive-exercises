package services;

import model.dao.CategoryDAO;
import model.persistence.Category;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class CategoryService extends JpaService {
    private final CategoryDAO categoryDAO;

    public CategoryService(EntityManager entityManager) {
        super(entityManager);
        this.categoryDAO = new CategoryDAO(entityManager);
    }

    public Category findByName(String name) {
        if (name == null || name.isEmpty()) {
            this.LOG.error("O Name não pode ser Nulo!");
            throw new RuntimeException("The name is null!");
        }
        try {
            return this.categoryDAO.findByName(name.toLowerCase());
        } catch (NoResultException r) {
            this.LOG.info("Não foi encontrado Categoria, será criada!");
            return null;
        }
    }
}

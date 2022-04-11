package services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.function.Consumer;

public abstract class JpaService<T> {
    protected Logger LOG = LogManager.getLogger(JpaService.class);
    protected EntityManager entityManager;

    protected JpaService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    protected void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            action.accept(entityManager);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            LOG.error("error at transaction");
        }
    }
}

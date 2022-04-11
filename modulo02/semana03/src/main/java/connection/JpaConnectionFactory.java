package connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaConnectionFactory {
    private final EntityManagerFactory entityManagerFactory;

    public JpaConnectionFactory() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("market");
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}

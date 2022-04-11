package application;

import connection.JpaConnectionFactory;
import model.persistence.Category;
import model.persistence.Product;
import services.ProductService;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class program {
    public static void main(String[] args) {
        EntityManager entityManager = new JpaConnectionFactory().getEntityManager();
        ProductService productService = new ProductService(entityManager);

        Category category = new Category("informatica");
        Product product = new Product("teclado", "18 teclas", new BigDecimal(14.99), category);

        //productService.save(product);
        productService.listAll().forEach(System.out::println);
        productService.delete(5L);
        productService.listAll().forEach(System.out::println);
    }
}

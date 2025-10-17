package aulaSpringJpa.config;

import aulaSpringJpa.entities.Category;
import aulaSpringJpa.entities.Order;
import aulaSpringJpa.entities.Product;
import aulaSpringJpa.entities.User;
import aulaSpringJpa.entities.enums.OrderStatus;
import aulaSpringJpa.repositories.CategoryRepository;
import aulaSpringJpa.repositories.OrderRepository;
import aulaSpringJpa.repositories.ProductRepository;
import aulaSpringJpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Abadia", "maria@gmail.com", "98789-2545", "123456");
        User u2 = new User(null, "José Fonseca", "jose@gmail.com", "98789-2545", "123456");
        userRepository.saveAll(Arrays.asList(u1, u2));

        Order o1 = new Order(null, Instant.parse("2025-06-01T19:55:04Z"), OrderStatus.WAITING_PAYMENT, u1);
        Order o2 = new Order(null, Instant.parse("2025-07-07T09:25:04Z"), OrderStatus.PAID, u2);
        Order o3 = new Order(null, Instant.parse("2025-08-20T13:00:04Z"), OrderStatus.DELIVERED, u1);
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        Category cat1 = new Category(null, "Eletronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipusum", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Lorem ipusum", 2990.5, "");
        Product p3 = new Product(null, "Macbook Pro", "Lorem ipusum", 9990.5, "");
        Product p4 = new Product(null, "PC Gamer", "Lorem ipusum", 7590.5, "");
        Product p5 = new Product(null, "Hobbit", "Lorem ipusum", 100.5, "");
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
    }


}

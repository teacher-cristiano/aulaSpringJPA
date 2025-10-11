package aulaSpringJpa.config;

import aulaSpringJpa.entities.Order;
import aulaSpringJpa.entities.User;
import aulaSpringJpa.repositories.OrderRepository;
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

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Abadia", "maria@gmail.com", "98789-2545", "123456");
        User u2 = new User(null, "José Fonseca", "jose@gmail.com", "98789-2545", "123456");
        userRepository.saveAll(Arrays.asList(u1, u2));

        Order o1 = new Order(null, Instant.parse("2025-06-01T19:55:04Z"));
        Order o2 = new Order(null, Instant.parse("2025-07-07T09:25:04Z"));
        Order o3 = new Order(null, Instant.parse("2025-08-20T13:00:04Z"));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }


}

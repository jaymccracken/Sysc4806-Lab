package Labs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class);
    }

    @Bean
    public CommandLineRunner demo(BuddyInfoInfo repository) {
        return (args) -> {
            // save a few customers
            repository.save(new BuddyInfo("J", "home", "905", 22));
            repository.save(new BuddyInfo("M", "home", "709", 22));
            repository.save(new BuddyInfo("K", "bed", "000", 1));

            // fetch all customers
            log.info("Buddys found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo buddy : repository.findAll()) {
                log.info(buddy.write());
            }
            log.info("");

            // fetch an individual customer by ID
            BuddyInfo buddy = repository.findByAge(22);
            log.info("Buddys found with findById(1L):");
            log.info("--------------------------------");
            log.info(buddy.write());
            log.info("");

            // fetch customers by last name
            log.info("Buddys found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByName("k").forEach(k -> {
                log.info(k.write());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            //  log.info(bauer.toString());
            // }
            log.info("");
        };
    }
}

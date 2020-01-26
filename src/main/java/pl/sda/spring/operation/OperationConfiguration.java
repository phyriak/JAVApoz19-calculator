package pl.sda.spring.operation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OperationConfiguration {
    @Bean
    SubtractionOperation subtractionOperation() {
        return new SubtractionOperation();
    }

    @Bean
    DivisionOperation divisionOperation() {
        return new DivisionOperation("NIe dzielimy przez zero"); }

}

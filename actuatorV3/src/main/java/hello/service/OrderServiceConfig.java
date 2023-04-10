package hello.service;

import hello.service.impl.OrderServiceImpl;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderServiceConfig {

    @Bean
    public OrderService orderService(MeterRegistry registry) {
        return new OrderServiceImpl(registry);
    }
}

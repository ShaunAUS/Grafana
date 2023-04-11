package hello.serviceV1;

import hello.serviceV1.impl.OrderServiceImpl;
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

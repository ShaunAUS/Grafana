package hello.serviceV3;

import hello.serviceV3.impl.OrderServiceImpl;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderServiceConfig {

    @Bean
    OrderService orderService(MeterRegistry registry) {
        return new OrderServiceImpl(registry);
    }

}

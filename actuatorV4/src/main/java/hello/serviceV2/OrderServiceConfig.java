package hello.serviceV2;

import hello.serviceV2.Impl.OrderServiceImpl;
import io.micrometer.core.aop.CountedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderServiceConfig {

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl();
    }

    //CountedAspect를 Bean으로 등록해야 @Counted가 동작한다.
    @Bean
    public CountedAspect countedAspect(MeterRegistry registry) {
        return new CountedAspect(registry);
    }
}

package hello.serviceV4;

import hello.serviceV4.OrderService;
import hello.serviceV4.impl.OrderServiceImpl;
import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderServiceConfig {

    @Bean
    OrderService orderService() {
        return new OrderServiceImpl();
    }
    //@Counted 와 마찬가지로 @Timed AOP 동작을 위해 꼭 빈등록 해줘야함
    @Bean
    public TimedAspect timedAspect(MeterRegistry registry) {
        return new TimedAspect(registry);
    }


}

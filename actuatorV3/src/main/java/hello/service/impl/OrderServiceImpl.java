package hello.service.impl;

import hello.service.OrderService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderServiceImpl implements OrderService {

    private final MeterRegistry registry;
    private AtomicInteger stock = new AtomicInteger(100);

    public OrderServiceImpl(MeterRegistry registry) {
        this.registry = registry;
    }

    @Override
    public void order() {
        log.info("주문");
        stock.decrementAndGet();

         Counter.builder("my.order") // 메트릭 이름
            .tag("class", this.getClass().getName())
            .tag("method", "order") //메서드 이름
            .description("order")
            .register(registry)
            .increment();

    }

    @Override
    public void cancel() {
        log.info("취소");
        stock.incrementAndGet();
        Counter.builder("my.order")
            .tag("class", this.getClass().getName())
            .tag("method", "cancel")
            .description("order")
            .register(registry).increment();
    }

    @Override
    public AtomicInteger getStock() {
        return stock;
    }


}

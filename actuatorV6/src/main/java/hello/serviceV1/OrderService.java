package hello.serviceV1;

import java.util.concurrent.atomic.AtomicInteger;

public interface OrderService {

    void order();

    void cancel();

    AtomicInteger getStock();


}

package chapter2.observable;

import common.Order;
import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Slf4j
public class FromIterableExample {
    public static void main(String[] args) {
        withList();
        withOrderList();
    }

    private static void withList() {
        List<String> names = new ArrayList<>();
        names.add("Homer");
        names.add("Bars");
        names.add("Lisa");

        Observable<String> source = Observable.fromIterable(names);
        source.subscribe(log::info);
    }

    private static void withOrderList() {
        BlockingQueue<Order> orderList = new ArrayBlockingQueue<>(100);
        orderList.add(new Order("ORD-1"));
        orderList.add(new Order("ORD-2"));
        orderList.add(new Order("ORD-3"));

        Observable<Order> source = Observable.fromIterable(orderList);

        source.subscribe(order -> log.info("Order Info : {}", order));
    }
}

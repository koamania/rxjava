package chapter2.hot_observable;

import common.CommonUtil;
import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ConnectableObservableExample {

    private static final Logger SUB1 = LoggerFactory.getLogger("sub1");
    private static final Logger SUB2 = LoggerFactory.getLogger("sub2");
    private static final Logger SUB3 = LoggerFactory.getLogger("sub3");

    public static void main(String[] args) {
//        connectableExample();
        connectable2();
    }

    private static void connectableExample() {
        String[] dt = {"1", "3", "5"};
        Observable<String> balls = Observable.interval(100, TimeUnit.MILLISECONDS)
                .map(Long::intValue)
                .map(i -> dt[i])
                .take(dt.length);

        ConnectableObservable<String> source = balls.publish();
        source.subscribe(data -> SUB1.info("sub 1 : {}", data));
        source.subscribe(data -> SUB2.info("sub 2 : {}", data));
        source.connect();

        CommonUtil.sleep(250);
        source.subscribe(data -> SUB3.info("sub 3 : {}", data));
        CommonUtil.sleep(500);
    }

    private static void connectable2() {
        Observable
                .interval(1, TimeUnit.SECONDS)
                .map(String::valueOf)
                .take(5)
                .blockingForEach(SUB1::info);

        SUB2.info("Say Hello!!");
    }
}

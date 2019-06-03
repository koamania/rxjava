package chapter2.single;

import common.Order;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingleExample {
    public static void main(String[] args) {
        example2();
        withTooManyElement();
    }

    private static void example1() {
        Single<String> source = Single.just("Hello Single");
        source.subscribe((Consumer<String>) log::info);
    }

    private static void example2() {
        // 기존 Observable에서 Single객체 변환
        Observable<String> source = Observable.just("Hello Single");
        Single.fromObservable(source)
                .subscribe(value -> log.info("{}", value));

        // single() 메소드
        Observable.just("Hello Single")
                .single("Deafult item")
                .subscribe(value -> log.info("{}", value));

        // first() 함수
        String[] colors = {"Red", "Green", "Blue"};
        Observable.fromArray(colors)
                .first("Default value")
                .subscribe(value -> log.info("{}", value));

        // empty Observable에서 Single 객체 생성
        Observable.empty()
                .single("Deafult item")
                .subscribe(value -> log.info("{}", value));

        // take() 메소드
        Observable.just(new Order("ORD-1"), new Order("ORD-2"))
                .take(1)
                .single(new Order("default Order"))
                .subscribe(order -> log.info("{}", order));
    }

    private static void withTooManyElement() {
        Observable.just("Too", "Many", "Elements")
                .single("Default element")
                .subscribe((Consumer<String>) log::info);
    }
}

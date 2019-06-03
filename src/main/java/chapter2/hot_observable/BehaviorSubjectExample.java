package chapter2.hot_observable;

import io.reactivex.subjects.BehaviorSubject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BehaviorSubjectExample {
    public static void main(String[] args) {
        BehaviorSubject<String> subject = BehaviorSubject.createDefault("6");

        // subscribe 1
        subject.subscribe(data -> log.info("sub 1 : {}", data));

        subject.onNext("1");
        subject.onNext("3");

        subject.subscribe(data -> log.info("sub 2 : {}", data));

        subject.onNext("5");

        subject.onComplete();
    }
}

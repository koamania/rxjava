package chapter2.hot_observable;

import io.reactivex.subjects.ReplaySubject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReplaySubjectExample {
    private static final Logger SUB1 = LoggerFactory.getLogger("sub1");
    private static final Logger SUB2 = LoggerFactory.getLogger("sub2");

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        ReplaySubject<String> subject = ReplaySubject.create();
        subject.subscribe(data -> SUB1.info("sub 1 : {}", data));

        subject.onNext("1");
        subject.onNext("3");

        subject.subscribe(data -> SUB2.info("sub 2 : {}", data));
        subject.onNext("5");

        subject.onComplete();
    }
}

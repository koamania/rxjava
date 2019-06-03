package chapter2.hot_observable;

import io.reactivex.Observable;
import io.reactivex.subjects.AsyncSubject;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class AsyncSubjectExample {

    private static final Logger obs1 = LoggerFactory.getLogger("Observer 1");
    private static final Logger obs2 = LoggerFactory.getLogger("Observer 2");

    public static void main(String[] args) {
//        asynSubject1();
//        asSubscriber();
        afterComplete();
    }

    private static void asynSubject1() {
        AsyncSubject<String> subject = AsyncSubject.create();

        // subscribe observer1
        subject.subscribe(obs1::info);

        // publish data 1, 2
        subject.onNext("1");
        subject.onNext("3");

        //subscribe observer2
        subject.subscribe(obs2::info);

        // publish data 5
        subject.onNext("5");

        subject.onComplete();
    }

    private static void asSubscriber() {
        Float[] temperature = {10.1f, 13.4f, 12.5f};
        Observable source = Observable.fromArray(temperature);

        AsyncSubject<Float> subject = AsyncSubject.create();
        subject.subscribe(data -> obs1.info("{}",data));

        source.subscribe(subject);
    }

    private static void afterComplete() {
        AsyncSubject<Integer> subject = AsyncSubject.create();
        subject.onNext(10);
        subject.onNext(11);

        subject.subscribe(data -> log.info("Subscriber 1 : {}", data));

        subject.onNext(12);
        subject.onComplete();
        subject.onNext(13);
        subject.subscribe(data -> log.info("Subscriber 2 : {}", data));
        subject.subscribe(data -> log.info("Subscriber 3 : {}", data));
    }
}

package chapter2.observable;

import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;


@Slf4j
public class FromPublisherExample {
    public static void main(String[] args) {
        Publisher<String> publisher = subscriber -> {
            subscriber.onNext("Hello Observable.fromPublisher()");
            subscriber.onComplete();
        };

        Observable<String> source = Observable.fromPublisher(publisher);
        source.subscribe(log::info);
    }
}

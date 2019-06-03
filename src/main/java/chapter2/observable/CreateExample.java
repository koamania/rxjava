package chapter2.observable;

import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateExample {
    public static void main(String[] args) {
        Observable<Integer> source = Observable.create(
                emitter -> {
                    emitter.onNext(100);
                    emitter.onNext(200);
                    emitter.onNext(300);
                    emitter.onComplete();
                }
        );

        //noinspection ResultOfMethodCallIgnored
        source.subscribe(m -> log.info("{}", m));
    }
}

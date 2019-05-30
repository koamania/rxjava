package chapter2;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DisposableExample {

    /**
     * 여기서 알 수 있는 것이 just는 인자로 전달받은 데이터를 연속적으로 발행하기 때문에 동기적으로 실행된다.
     * 해당 메소드가 실행되었을 때 disposable을 이용해 중간에 dispose하려고 했으나 되지 않고 순차적으로 실행이 되었음.
     */
    public static void doIt() {
        Observable<String> source = Observable.just("APPLE", "BANANA", "CAT");

        Disposable disposable = source.subscribe(v -> {
            log.info("onNext() => {}", v);
        }, err -> log.error("onError() call", err), () -> log.info("onComplete()"));

        new Thread(() -> {
            log.info("dispose? => {}", disposable.isDisposed());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                log.error("wt?", e);
            }

            disposable.dispose();

            log.info("dispose? => {}", disposable.isDisposed());
        }).start();
    }

    public static void main(String[] notUsed) {
        DisposableExample.doIt();
    }
}

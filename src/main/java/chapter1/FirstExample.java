package chapter1;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FirstExample {

    private Disposable emit() {
        return Observable.just("Hello", "RxJava 2!!")
                .subscribe(log::info);
    }
    public static void main(String[] a) {
        FirstExample demo = new FirstExample();
        demo.emit();
    }
}

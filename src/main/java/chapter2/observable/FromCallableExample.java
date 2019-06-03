package chapter2.observable;

import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

@Slf4j(topic = "FromCallableExample")
public class FromCallableExample {
    public static void main(String[] args) throws InterruptedException {
        withLambda();
        withoutLambda();
    }

    private static void withLambda() {
        Callable<String> callable = () -> {
            Thread.sleep(1000);
            return "Hello Callable";
        };

        Observable.fromCallable(callable)
                .subscribe(log::info);
    }

    private static void withoutLambda() {
        Callable<String> callable = new Callable<String>() {

            @Override
            public String call() throws Exception {
                return "Hello Callable";
            }
        };

        Observable.fromCallable(callable)
                .subscribe(log::info);
    }
}

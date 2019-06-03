package chapter2.observable;

import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class FromArrayExample {
    public static void main(String[] args) {
        withWrapperType();
        withPrimitiveType();
    }

    private static void withWrapperType() {
        Integer[] arr = {100, 200, 300};
        Observable<Integer> source = Observable.fromArray(arr);
        source.subscribe(v -> log.info("" + v));
    }

    private static void withPrimitiveType() {
        int[] arr = {100, 200, 300};
        Observable<Integer> source = Observable.fromArray(IntStream.of(arr).boxed().toArray(Integer[]::new));
        source.subscribe(v -> log.info("1 : " + v));
    }
}

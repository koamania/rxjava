package chapter3.multiplication;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class MultiplicationExample {
    public static void main(String[] args) {
        gugudan();
    }

    private static void multipleExample() {
        Function<Integer, Observable<String>> multiplier =
                i -> Observable.range(1, 9)
                        .map(j -> i + " * " + j + " = " + (i * j));

        Observable<String> source = Observable.range(1, 9)
                .flatMap(multiplier);

        source.subscribe(result -> log.info("{}", result));
    }

    private static void gugudan() {
        Function<Integer, Observable<String>> multiplier =
                i -> Observable.range(1, 9)
                        .map(j -> i + " * " + j + " = " + (i * j));

        PublishSubject<Integer> subject = PublishSubject.create();
        subject.subscribe(input -> {
            multiplier.apply(input).forEach(result -> log.info("{}", result));
        });

        try (Scanner sc = new Scanner(System.in)) {
            while(true) {
                subject.onNext(Integer.parseInt(sc.nextLine()));
            }
        }
    }
}

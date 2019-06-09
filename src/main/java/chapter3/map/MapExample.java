package chapter3.map;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapExample {
    public static void main(String[] args) {
//        getDiamodExample();
//        matchColorCode();
        flatMapExample();
    }

    private static void getDiamodExample() {
        String[] balls = {"1", "2", "3", "5"};
        Observable<String> source = Observable.fromArray(balls)
                .map(ball -> ball + "†");

        source.subscribe(log::info);
    }

    private static void matchColorCode() {
        Function<String, Integer> ballToIndex = ball -> {
            switch (ball) {
                case "RED": return 1;
                case "YELLOW": return 2;
                case "GREEN": return 3;
                case "BLUE": return 5;
                default: return -1;
            }
        };

        String[] balls = {"RED", "YELLOW", "GREEN", "BLUE"};

        Observable<Integer> source = Observable.fromArray(balls)
                .map(ballToIndex);

        source.subscribe(data -> log.info("{}", data));
    }

    private static void flatMapExample() {
        Function<String, Observable<String>> getDoubleDisamonds =
                ball -> Observable.just(ball + "<>", ball + "<>");

        Observable<String> source = Observable.fromArray("1", "3", "5")
                .flatMap(getDoubleDisamonds);

        source.subscribe(log::info);
    }
}

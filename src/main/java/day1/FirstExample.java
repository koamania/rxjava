package day1;

import io.reactivex.Observable;

public class FirstExample {

    private void emit() {
        Observable.just("Hello", "RxJava 2!!")
                .subscribe(System.out::println);
    }
    public static void main(String[] a) {
        FirstExample demo = new FirstExample();
        demo.emit();
    }
}

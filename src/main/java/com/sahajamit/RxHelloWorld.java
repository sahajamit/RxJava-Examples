package com.sahajamit;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by amitrawat on 9/9/17.
 */
public class RxHelloWorld {
    public static void main(String[] args) throws InterruptedException {
        RxHelloWorld.hello("John","Rob");
        Flowable.just("Hello world").subscribe(System.out::println);

        Flowable.fromCallable(() -> {
            Thread.sleep(1000); //  imitate expensive computation
            return "Done";
        })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(System.out::println, Throwable::printStackTrace);

        Thread.sleep(5000); // <--- wait for the
    }

    public static void hello(String... names) {
        Observable.fromArray(names).subscribe(s -> System.out.println("Hello " + s + "!"));
    }
}

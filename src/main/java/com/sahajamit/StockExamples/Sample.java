package com.sahajamit.StockExamples;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by amitrawat on 10/9/17.
 */
public class Sample {
    private static double maxPrice = 0.0;
    private static Disposable disposable;
    public static void main(String[] args) throws InterruptedException {
        Observable<Double> feed = FxServer.getFeed();
//        feed.subscribe(s -> maxPrice = (s>maxPrice)?s:maxPrice);
        feed
                .filter(currentPrice -> currentPrice > maxPrice)
//                .subscribeOn(Schedulers.io())
                .subscribe(
                        currentPrice -> {
                            System.out.println("Rate Increased !!!");
                            System.out.println(String.format("MaxPrice: %s  CurrentPrice: %s", maxPrice, currentPrice));
                            maxPrice = currentPrice > maxPrice ? currentPrice : maxPrice;
                            disposable.dispose();
                        },
                        error -> System.out.println("ERROR: " + error),
                        () -> System.out.println("DONE"),
                        d -> disposable = d
                );
//        System.out.println("Main is not running the function pipeline anymore");
//        Thread.sleep(50000);



//        feed.subscribe(new Observer<Double>() {
//            private Disposable disposable;
//
//            @Override
//            public void onSubscribe(Disposable disposable) {
//                this.disposable = disposable;
//            }
//
//            @Override
//            public void onNext(Double price) {
//                System.out.println(price);
//                //comment out the following four line to see the completed signal come through
//                if(price > maxPrice) {
//                    System.out.println(String.format("Price Increased by: %s %",((price-maxPrice)/100)*100));
//                    maxPrice
////                    disposable.dispose();
//                }
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//            }
//
//            @Override
//            public void onComplete() {
//                System.out.println("DONE");
//            }
//        });


//        List<String> symbols = Arrays.asList("GOOGL","AAPL","MSFT","INTC");
//        Observable<StockInfo> feed = StockServer.getFeed(symbols);
//        System.out.println("Got Observable");
//        feed.subscribe(System.out::println);
    }
}

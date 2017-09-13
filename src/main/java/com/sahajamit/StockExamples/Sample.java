package com.sahajamit.StockExamples;

import io.reactivex.Observable;

/**
 * Created by amitrawat on 10/9/17.
 */
public class Sample {
    public static double maxPrice = 0.0;
    public static void main(String[] args) {
        Observable<Double> feed = FxServer.getFeed();

//        feed.subscribe(s -> maxPrice = (s>maxPrice)?s:maxPrice);
        feed
                .filter(currentPrice -> currentPrice > maxPrice)
                .subscribe(
                        currentPrice -> {
                            System.out.println("Rate Increased !!!");
                            System.out.println(String.format("MaxPrice: %s  CurrentPrice: %s",maxPrice,currentPrice));
                            maxPrice = currentPrice > maxPrice ? currentPrice : maxPrice;
                        },
                        error -> System.out.println("ERROR: " + error),() -> System.out.println("DONE")
                );



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

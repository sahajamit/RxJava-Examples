package com.sahajamit.StockExamples;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import org.reactivestreams.Subscriber;

import java.util.List;

/**
 * Created by amitrawat on 10/9/17.
 */
public class StockServer {
    public static Observable<StockInfo> getFeed(List<String> symbols){
        return Observable.create(subscriber -> processRequest(subscriber,symbols));
    }

    private static void processRequest(ObservableEmitter<StockInfo> subscriber, List<String> symbols) {
        System.out.println("processing...");
        while (true) {
            for(String symbol:symbols){
                subscriber.onNext(StockFetcher.fetch(symbol));
            }
        }
    }


}

package com.sahajamit.StockExamples;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

public class FxServer {
    public static Observable<Double> getFeed(){
        return Observable.create(subscriber -> processRequest(subscriber));
    }

    private static void processRequest(ObservableEmitter<Double> subscriber) {
        System.out.println("processing...");
        while (!subscriber.isDisposed()) {
            subscriber.onNext(SingX.getPrice());
        }
    }
}

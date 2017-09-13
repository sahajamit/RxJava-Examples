package com.sahajamit.StockExamples;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

public class FxServer {
    public static Observable<Double> getFeed(){
        return Observable.create(emitter -> emit(emitter));
    }

    private static void emit(ObservableEmitter<Double> emitter) {
        System.out.println("processing...");
        int count  = 0;
//        while (count++<5) {
        while (!emitter.isDisposed()) {
            emitter.onNext(SingX.getPrice());
        }
        emitter.onComplete();
    }
}

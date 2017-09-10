package com.sahajamit.StockExamples;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

import static com.sahajamit.StockExamples.StockServer.getFeed;

/**
 * Created by amitrawat on 10/9/17.
 */
public class Sample {
    public static void main(String[] args) {
        List<String> symbols = Arrays.asList("GOOGL","AAPL","MSFT","INTC");
        Observable<StockInfo> feed = StockServer.getFeed(symbols);
        System.out.println("Got Observable");
        feed.subscribe(System.out::println);

    }
}

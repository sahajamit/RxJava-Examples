package com.sahajamit.StockExamples;

/**
 * Created by amitrawat on 10/9/17.
 */
public class StockFetcher {
    public static StockInfo fetch(final String symbol){
        return new StockInfo(symbol, YahooFinance.getPrice(symbol));
    }
}

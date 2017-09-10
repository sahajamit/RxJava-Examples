package com.sahajamit.StockExamples;

public class StockInfo {
    public final String ticker;
    public final double value;

    public StockInfo(final String theTicker, final double theValue) {
        ticker = theTicker;
        value = theValue;
    }

    public String toString() {
        return String.format("%s : %f", ticker, value);
    }
}

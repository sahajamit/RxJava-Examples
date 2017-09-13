package com.sahajamit.StockExamples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

/**
 * Created by amitrawat on 10/9/17.
 */
public class YahooFinance {
    public static double getPrice(final String ticker) {
        try {
            Thread.sleep(1000);
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("x.x.x.x", 8080));
            final URL url =
                    new URL("http://download.finance.yahoo.com/d/quotes.csv?s=" + ticker + "&f=snbaopl1");
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection(proxy);
            final BufferedReader reader =
                    new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final String data = reader.lines().limit(1).findFirst().get();
            final String[] dataItems = data.split(",");
            double price = Double.parseDouble(dataItems[dataItems.length - 1]);
            return price;
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}

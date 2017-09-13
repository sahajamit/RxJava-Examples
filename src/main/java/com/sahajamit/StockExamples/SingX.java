package com.sahajamit.StockExamples;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

public class SingX {
    public static double getPrice() {
        try {
            Thread.sleep(1000);
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("x.x.x.x", 8080));
            final URL url =
                    new URL("https://www.singx.co/singx/secure/CommonRestServiceImpl/getExchangeRates?fromId=SGD&toId=INR&amount=10000.00&receiveAmt=0&fromCountryId=59C3BBD2-5D26-4A47-8FC1-2EFA628049CE&toCountryId=A5001AED-DDA1-4296-8312-223D383F96F5&feeType=0&label=First");
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection(proxy);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            if (conn.getResponseCode() != 201) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            final BufferedReader reader =
                    new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            String output = "";
            while ((line = reader.readLine()) != null) {
                output = output + line;
            }
            JSONObject response = new JSONObject(output);
            double price = response
                    .getJSONObject("response")
                    .getJSONObject("data")
                    .getDouble("exchangeRate");
            return price;
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}

package net.kxinmensch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Rechner {
    private static final String API_URL = "https://api.apilayer.com/exchangerates_data/latest";
    private String apiKey = "1XA50qRlnMc3CCBbdbPVq3glzzQxQqS2";


    // Methode zur Umrechnung von Währungen
    public double getExchangeRate(String baseCurrency, String targetCurrency) {
        try {
            String urlStr = API_URL + "?base=" + baseCurrency + "&symbols=" + targetCurrency;
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("apikey", apiKey); // API-Key setzen

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            connection.disconnect();

            // Extrahiere den Wechselkurs
            String response = content.toString();
            String rateStr = response.split(targetCurrency + "\":")[1].split("}")[0];
            return Double.parseDouble(rateStr);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.0;
    }
}

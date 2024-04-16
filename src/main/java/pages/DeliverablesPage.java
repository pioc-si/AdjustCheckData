package pages;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeliverablesPage {

  String[] shopIds = {
    "677", "506", "491", "413", "327", "329", "402", "167", "191", "616", "683", "163", "165",
    "689", "159", "161", "225", "404", "496", "585", "615", "673", "251", "255", "249", "435",
    "263", "265", "243", "259", "697", "261", "446", "680", "666", "610", "678"
  };
  ArrayList<String> shopIdList = new ArrayList<>(Arrays.asList(shopIds));

  public class Row {
    public String campaign;
  }

  public class ResponseData {
    private List<Row> rows;

    public List<Row> getRows() {
      return rows;
    }

    public void setRows(List<Row> rows) {
      this.rows = rows;
    }
  }

  public ResponseData deliverablesTable = new ResponseData();

  public DeliverablesPage() {

    System.out.println("in the Deliverables page");

    // URL to send the POST request
    String url =
        "https://automate.adjust.com/reports-service/report?full_data=true&attribution_source=first&ad_spend_mode=network&reattributed=all&attribution_type=all&readable_names=false&format_dates=false&metrics=attribution_clicks%2Cclick_conversion_rate%2Cinstalls%2Climit_ad_tracking_install_rate%2Cinstall_unique_events%2Creattributions%2Csessions%2Cdaus%2Cwaus%2Cmaus%2Capp_update_events%2Cadd_cart_events%2Cview_product_events%2Cstart_checkout_events%2Cend_checkout_events%2Ccomplete_reg_events%2Cpurchase_events%2Call_revenue%2Carpdau%2Catt_status_authorized&dimensions=network&cohort_maturity=immature&drilldown=network%3ALICHI+Store+Install+Counter&ironsource_mode=ironsource&sandbox=false&utc_offset=%2B03%3A00&date_period=-15d%3A-1d&coloring_mode=column&limit=5000&sort=-installs";
    HttpURLConnection connection = null;

    try {
      connection = (HttpURLConnection) new URL(url).openConnection();

      connection.setRequestProperty("authority", "automate.adjust.com");
      connection.setRequestProperty("accept", "*/*");
      connection.setRequestProperty("accept-language", "en-US,en;q=0.5");
      connection.setRequestProperty("cache-control", "no-cache");
      connection.setRequestProperty(
          "Cookie",
          "remember_user_token=eyJfcmFpbHMiOnsibWVzc2FnZSI6Ilcxc3lOak0wTVROZExDSWtNbUVrTVRBa2FTNHhSRzVpYkc4dllWZFRTbTlNZFROWVNEZzNaU0lzSWpFM01USTROakE0TVRJdU9UZ3pPRFl3TXlKZCIsImV4cCI6IjIwMjQtMDQtMjVUMTg6NDA6MTIuOTgzWiIsInB1ciI6bnVsbH19--f8349beb1222994a95b82cf3019db9e0989c662f;"
              + " _production_current_session_hash=5ee2ec46ffc673ed337183159638d9e4;"
              + " _production_adjust_session=bzU1UVp0SXVOMS9XSy9kV1VpQm1LWkcwRk5FR3EraEgydCsvbTlmVVdGcHA4U1ZySGVscGdNZXk3K3RYeDVGbzJ6SzhQTDZxMk9tNjdJMlN3N3ZSd1RNdk9PN1J2T1UzU1gzUHYybEpOSFBMeGN2QTV5RGZlZjZwZjZXN0UwcE1jMzVialpRQzRKN0I3UjBydmZQcC95RHNTNmlRQ0drOVI2cFRPc0tCT3FZbWlTRTRLOUVRczZaWXloYTV3MTJFUnRsL29icStVdkdEK1g2N1FRVUZwK2ZKYzB0NkdDVkc3ekRjYk5McFI1bEIxaXI3WU1rMDM2UHJyd1psWnkydmtrUmJvNGRQSlorYk91WlZKeDBvVVJDWGQ0ZzJndnVnbXJqbVYrL2hQcm9nbTdSYXU2dmlWZXdmUitPcEU2SFdEZDJSYTFickJhZElJVEludW9tS3Qvajh6S3dmWHNpb1JqbDczbC90THRIUmlGQTdGY1kzN2JJWVh3b0kwdUNQNVpQYXJmeDg3MTdPaXJTT3VPdG5Vdz09LS1leTB3OUVnaVlOZEVzQlFwL3hZSVlnPT0%3D--fce819bed2e6574b89c6b2ac2b7c5bfb71e401f1;"
              + " _hjSessionUser_2831967=eyJpZCI6IjQ2ZjdjMDFmLTJmY2UtNWJjZi1iMzNmLTllNmMzN2RhYTYyZSIsImNyZWF0ZWQiOjE3MTI4NjA4MTg1NzMsImV4aXN0aW5nIjp0cnVlfQ==;"
              + " _hjSession_2831967=eyJpZCI6ImU4OWEzMWE5LTA5YmYtNDU3YS04OWJmLTVlMjgyZGMyYWM1NSIsImMiOjE3MTMxMDk1MDI2NzQsInMiOjAsInIiOjAsInNiIjowLCJzciI6MCwic2UiOjAsImZzIjowLCJzcCI6MX0=;"
              + " _hjHasCachedUserAttributes=true");
      connection.setRequestProperty("correlation-id", "44a6563d-d2d2-48ce-890c-b1033c9aca7d");
      connection.setRequestProperty("origin", "https://suite.adjust.com");
      connection.setRequestProperty("pragma", "no-cache");
      connection.setRequestProperty("referer", "https://suite.adjust.com/");
      connection.setRequestProperty(
          "sec-ch-ua",
          "\"Chromium\";v=\"112\", \"Google Chrome\";v=\"112\", \"Not:A-Brand\";v=\"99\"");
      connection.setRequestProperty("sec-ch-ua-mobile", "?1");
      connection.setRequestProperty("sec-ch-ua-platform", "\"Android\"");
      connection.setRequestProperty("sec-fetch-dest", "empty");
      connection.setRequestProperty("sec-fetch-mode", "cors");
      connection.setRequestProperty("sec-fetch-site", "same-site");
      connection.setRequestProperty(
          "user-agent",
          "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like"
              + " Gecko) Chrome/112.0.0.0 Mobile Safari/537.36");
      connection.setRequestProperty("x-referer", "https://suite.adjust.com/datascape/report");
      connection.setRequestProperty("x-source", "dash_exp_frontend");

      connection.setDoOutput(true);
      connection.connect();

      // Read the response
      BufferedReader reader =
          new BufferedReader(new InputStreamReader(connection.getInputStream()));
      StringBuilder responseBuilder = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        responseBuilder.append(line);
      }
      reader.close();
      System.out.println("running in the try block");

      // Parse JSON response into array of objects
      Gson gson = new Gson();
      deliverablesTable = gson.fromJson(responseBuilder.toString(), ResponseData.class);

      deliverablesTable.rows.removeIf(row -> shopIdList.contains(row.campaign));

      // Now you can access the parsed data
      System.out.println("Number of non shop deliverable rows: " + deliverablesTable.rows.size());
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      connection.disconnect();
    }
  }
}


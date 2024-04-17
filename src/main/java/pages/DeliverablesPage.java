package pages;

import com.google.gson.Gson;
import config.Props;

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

    Props props = Props.props;

    System.out.println("in the Deliverables page");

    // URL to send the POST request
    String url = props.deliverablesCurlUrl();
    HttpURLConnection connection = null;

    try {
      connection = (HttpURLConnection) new URL(url).openConnection();

      connection.setRequestProperty("authority", props.deliverablesCurlHeaderAuthority());
      connection.setRequestProperty("accept", props.deliverablesCurlHeaderAccept());
      connection.setRequestProperty("accept-language", props.deliverablesCurlHeaderAcceptLanguage());
      connection.setRequestProperty("cache-control", props.deliverablesCurlHeaderCacheControl());
      connection.setRequestProperty(
          "Cookie", props.deliverablesCurlHeaderCookie());
      connection.setRequestProperty("correlation-id", props.deliverablesCurlHeaderCorrelationId());
      connection.setRequestProperty("origin", props.deliverablesCurlHeaderOrigin());
      connection.setRequestProperty("pragma", props.deliverablesCurlHeaderPragma());
      connection.setRequestProperty("referer", props.deliverablesCurlHeaderReferer());
      connection.setRequestProperty(
          "sec-ch-ua", props.deliverablesCurlHeaderSecChUa());
      connection.setRequestProperty("sec-ch-ua-mobile", props.deliverablesCurlHeaderSecChUaMobile());
      connection.setRequestProperty("sec-ch-ua-platform", props.nonShopCurlHeaderSecChUaPlatform());
      connection.setRequestProperty("sec-fetch-dest", props.deliverablesCurlHeaderSecFetchDest());
      connection.setRequestProperty("sec-fetch-mode", props.deliverablesCurlHeaderSecFetchMode());
      connection.setRequestProperty("sec-fetch-site", props.deliverablesCurlHeaderSecFetchSite());
      connection.setRequestProperty(
          "user-agent", props.deliverablesCurlHeaderUserAgent());
      connection.setRequestProperty("x-referer", props.deliverablesCurlHeaderXReferer());
      connection.setRequestProperty("x-source", props.deliverablesCurlHeaderXSource());

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


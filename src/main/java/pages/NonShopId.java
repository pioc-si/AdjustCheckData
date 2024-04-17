package pages;

import com.google.gson.Gson;
import config.Props;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class NonShopId {

  public class Row {
    public String adgroup;
    public String install_unique_events;
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

  public ResponseData nonShopIdUsersTable = new ResponseData();

  public NonShopId(String id) {

    Props props = Props.props;

    // URL to send the POST request
    // 159
    String url = props.nonShopCurlUrl1() + id + props.nonShopCurlUrl2();

    HttpURLConnection connection = null;
    try {
      connection = (HttpURLConnection) new URL(url).openConnection();

      connection.setRequestProperty("authority", props.nonShopCurlHeaderAuthority());
      connection.setRequestProperty("accept", props.nonShopCurlHeaderAccept());
      connection.setRequestProperty("accept-language", props.nonShopCurlHeaderAcceptLanguage());
      connection.setRequestProperty("cache-control", props.nonShopCurlHeaderCacheControl());
      connection.setRequestProperty("Cookie", props.nonShopCurlHeaderCookie());
      connection.setRequestProperty("correlation-id", props.nonShopCurlHeaderCorrelationId());
      connection.setRequestProperty("origin", props.nonShopCurlHeaderOrigin());
      connection.setRequestProperty("pragma", props.nonShopCurlHeaderPragma());
      connection.setRequestProperty("referer", props.nonShopCurlHeaderReferer());
      connection.setRequestProperty("sec-ch-ua", props.nonShopCurlHeaderSecChUa());
      connection.setRequestProperty("sec-ch-ua-mobile", props.nonShopCurlHeaderSecChUaMobile());
      connection.setRequestProperty("sec-ch-ua-platform", props.nonShopCurlHeaderSecChUaPlatform());
      connection.setRequestProperty("sec-fetch-dest", props.nonShopCurlHeaderSecFetchDest());
      connection.setRequestProperty("sec-fetch-mode", props.nonShopCurlHeaderSecFetchMode());
      connection.setRequestProperty("sec-fetch-site", props.nonShopCurlHeaderSecFetchSite());
      connection.setRequestProperty("user-agent", props.nonShopCurlHeaderUserAgent());
      connection.setRequestProperty("x-referer", props.nonShopCurlHeaderXReferer());
      connection.setRequestProperty("x-source", props.nonShopCurlHeaderXSource());

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

      // Parse JSON response into array of objects
      Gson gson = new Gson();
      nonShopIdUsersTable = gson.fromJson(responseBuilder.toString(), ResponseData.class);

      // Now you can access the parsed data
      System.out.println("Number of rows: " + nonShopIdUsersTable.rows.size());
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      connection.disconnect();
    }
  }
}


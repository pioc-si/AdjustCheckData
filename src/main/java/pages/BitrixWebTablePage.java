package pages;

import com.google.gson.Gson;
import config.Props;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BitrixWebTablePage {

  public class ResponseData {
    public int total_employees;
    public List<EmployeeItem> employee_items;
  }

  public class EmployeeItem {
    public int user_id;
    public String shop;
    public String shop_id;
    public String position;
    public String full_name;
    public int installed_count;
  }

  public ResponseData bitrixWebTable = new ResponseData();

  HttpURLConnection connection = null;

  public BitrixWebTablePage() {

    Props props = Props.props;
    // URL to send the POST request
    String url = props.bitrixCurlUrl();

    try {
      // Create a HttpURLConnection
      connection = (HttpURLConnection) new URL(url).openConnection();
      // Set the request method to POST
      connection.setRequestMethod(props.bitrixCurlRequestMethod());

      // Set request headers
      connection.setRequestProperty("authority", props.bitrixCurlHeaderAuthority());
      connection.setRequestProperty("accept", props.bitrixCurlHeaderAccept());
      connection.setRequestProperty("accept-language", props.bitrixCurlHeaderAcceptLanguage());
      connection.setRequestProperty("content-type", props.bitrixCurlHeaderContentType());
      connection.setRequestProperty("cookie", props.bitrixCurlHeaderCookie());

      connection.setDoOutput(true);

      // request body
      String requestBody = props.bitrixCurlRequestBody();
      connection.getOutputStream().write(requestBody.getBytes());

      // Send the request
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
      bitrixWebTable = gson.fromJson(responseBuilder.toString(), ResponseData.class);

      // Now you can access the parsed data
      System.out.println("Total employees: " + bitrixWebTable.total_employees);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      connection.disconnect();
    }
  }
}


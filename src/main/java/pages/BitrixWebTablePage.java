package pages;

import com.google.gson.Gson;
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

    // URL to send the POST request
    String url = "https://employee-qr.spb.lichishop.com/api/v1/statistics/employees";

    try {
      // Create a HttpURLConnection
      connection = (HttpURLConnection) new URL(url).openConnection();
      // Set the request method to POST
      connection.setRequestMethod("POST");

      // Set request headers
      connection.setRequestProperty("authority", "employee-qr.spb.lichishop.com");
      connection.setRequestProperty("accept", "*/*");
      connection.setRequestProperty("accept-language", "en-US,en;q=0.9");
      connection.setRequestProperty(
          "content-type", "application/x-www-form-urlencoded; charset=UTF-8");
      connection.setRequestProperty(
          "cookie",
          "USER_DATA=S3sRASJrGAt0e3ZzRlV2Dm0OYQMSBQsNJjAKDX57UCUBOyJtEgQAbnh7fnBXD3FyADgqYBZXIlttXXpLAihuYVFMd30JYVJpQ3wkdhIx");

      connection.setDoOutput(true);

      // request body
      String requestBody =
          "startDate=2024-4-1&endDate=2024-4-15&query=&page=1&sort=asc&offset=1000&region=";
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


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Api {
    public static void main(String[] args) {
        try {

            URL url = new URL("https://api.zippopotam.us/us/33162");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {

                Scanner scanner = new Scanner(connection.getInputStream());
                StringBuilder response = new StringBuilder();
                while (scanner.hasNextLine()) {
                    response.append(scanner.nextLine());
                }
                scanner.close();


                System.out.println(response.toString());
            } else {
                System.out.println("API request failed with response code: " + responseCode);
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


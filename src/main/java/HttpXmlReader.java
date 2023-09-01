import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpXmlReader {
    public static void main(String[] args) {
        try {
            // Define the URL of the XML resource
            String urlStr = "http://localhost:8080/your-context-path/your-resource.xml";

            // Create a URL object
            URL url = new URL(urlStr);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the HTTP request method to GET
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the XML content from the response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder xmlContent = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    xmlContent.append(line);
                }

                reader.close();

                // Now, you have the XML content in the xmlContent StringBuilder
                System.out.println("XML Content:\n" + xmlContent.toString());
            } else {
                System.err.println("HTTP GET request failed with response code: " + responseCode);
            }

            // Close the connection
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

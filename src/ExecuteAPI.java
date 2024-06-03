import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

public class ExecuteAPI {

    private static final String API_URL = "http://localhost:8080/unit-test-automation/takeScreenshots";
//    private static final String AUTH_TOKEN = "<your_token_here>"; // Replace with your actual token

    public static void main(String[] args) {
        // Create an HttpClient instance
        HttpClient client = HttpClient.newHttpClient();

        // Define the request payload
        Map<String, Object> payload = new HashMap<>();
        payload.put("hostName", "Enter the Hostname");
        payload.put("userName", "Enter the username");
        payload.put("password", "Enter the password");
        payload.put("is31443Requried", true);
        payload.put("requestId", 135);
        payload.put("taskIds", List.of(
                "Enter the 1st task id",
                "Enter the 2nd task id",
                "Enter the 3rd task id",
                "Enter the 4th task id"
        ));

        try {
            // Convert the payload to JSON manually
            String requestBody = mapToJson(payload);

            // Build the HttpRequest
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(API_URL))
                    .header("Content-Type", "application/json")
//                    .header("Authorization", "Bearer " + AUTH_TOKEN)
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            // Send the request and handle the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200 || response.statusCode() == 201) {
                System.out.println("Screenshot taken successfully: " + response.body());
            } else {
                System.err.println("Failed to take screenshot: " + response.statusCode());
                System.err.println("Response body: " + response.body());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Convert a Map to a JSON string manually
    private static String mapToJson(Map<String, Object> map) {
        return map.entrySet()
                .stream()
                .map(entry -> {
                    String key = "\"" + entry.getKey() + "\"";
                    Object value = entry.getValue();
                    if (value instanceof String) {
                        return key + ":\"" + value + "\"";
                    } else if (value instanceof Boolean || value instanceof Number) {
                        return key + ":" + value;
                    } else if (value instanceof List) {
                        List<?> list = (List<?>) value;
                        String listString = list.stream()
                                .map(item -> "\"" + item.toString() + "\"")
                                .collect(Collectors.joining(",", "[", "]"));
                        return key + ":" + listString;
                    } else {
                        return key + ":null";
                    }
                })
                .collect(Collectors.joining(",", "{", "}"));
    }
}

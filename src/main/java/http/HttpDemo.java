package http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class HttpDemo {
    private static final String CREATE_USER_URL = "https://jsonplaceholder.typicode.com/users/1/todos";
    private static final String GET_USER_BY_ID = "https://jsonplaceholder.typicode.com/users/1/todos";

    public static void main(String[] args) throws IOException, InterruptedException {

//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://jsonplaceholder.typicode.com/users/1/todos"))
//                .GET()
//                .timeout(Duration.of(10, ChronoUnit.SECONDS))
//                .build();
//        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println("response.headers() = " + response.headers());
//        System.out.println("response.body() = " + response.body());
//        System.out.println("response.statusCode() = " + response.statusCode());
        //TASK #1
        User user = createDefaultUser();
        final User createdUser = HttpUtil.sendPost(URI.create(CREATE_USER_URL), user);
        System.out.println("TASK #1  " + createdUser);

        //TASK #2
        final String format = String.format("%s?id=%d", GET_USER_BY_ID, createdUser.getId());
        final User user1 = HttpUtil.sendGet(URI.create(format));
        System.out.println("TASK #1  " + user1);

    }

    private static User createDefaultUser() {
        User user = new User();
        user.setUserId(2);
        user.setId(1);
        user.setTitle("win this game");
        user.setCompleted(false);
        return user;
    }
}

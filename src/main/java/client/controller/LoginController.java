package client.controller;

import client.obj.User;
import client.view.GUI;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class LoginController {
    public boolean login(String username, String password) {
        boolean result = false;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
            headers.setContentType(MediaType.APPLICATION_JSON);

            RestTemplate restTemplate = new RestTemplate();

            User user = new User(username, password);
            System.out.println("Login username: " + user.getUsername());
            // Dữ liệu đính kèm theo yêu cầu.
            HttpEntity<User> requestBody = new HttpEntity<>(user, headers);

            // Gửi yêu cầu với phương thức POST.
            String res = restTemplate.postForObject("http://localhost:8081/login", requestBody, String.class);
            if (res == null) {
                System.out.println("Something error!");
                return false;
            }
            System.out.println("Response login: " + res);
            if (res.) {
                return true;
            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

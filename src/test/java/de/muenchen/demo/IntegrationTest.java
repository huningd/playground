package de.muenchen.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.junit.Assert.assertTrue;

/**
 * Created by dennis_huning on 10.02.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebIntegrationTest()
@TestPropertySource(properties = {
        "server.port=0"
})
@SpringApplicationConfiguration(classes = MySpringBootRouter.class)
public class IntegrationTest {

    @Value("${local.server.port}")
    private int port;

    private RestTemplate template = new TestRestTemplate();

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testDemo() {
        final URI uri = URI.create("http://localhost:" + port + "/demo");
        RequestEntity<Message> request = new RequestEntity<>(new Message(10, "Hello World"), HttpMethod.POST, uri);
        ResponseEntity<String> response = template.exchange(request, String.class);

        assertTrue(response.getStatusCode().is2xxSuccessful());
        String msg = response.getBody();
        assertTrue(msg.contains("greater"));
    }


}

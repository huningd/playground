package de.muenchen.demo;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by dennis_huning on 10.02.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MySpringBootRouter.class)
public class MySpringBootRouterTest {

    @Autowired
    private CamelContext context;


    @Test
    public void testDemoRoute() {
        final ProducerTemplate template = context.createProducerTemplate();
        template.requestBody("direct://demo", new Message(10, "Hello World"));
        template.requestBody("direct://demo", new Message(9, "Hello World"));
    }
}

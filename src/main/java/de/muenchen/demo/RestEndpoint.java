package de.muenchen.demo;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dennis_huning on 10.02.16.
 */
@RestController
@RequestMapping("/demo")
public class RestEndpoint {

    @Produce(uri = "direct:demo")
    private ProducerTemplate template;

    @RequestMapping(method = RequestMethod.POST)
    public String demo(@RequestBody Message msg) {
        return template.requestBody(msg, String.class);
    }
}

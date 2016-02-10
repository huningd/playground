package de.muenchen.demo;

import org.apache.camel.spring.boot.FatJarRouter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MySpringBootRouter extends FatJarRouter {

    @Override
    public void configure() {

        from("direct://demo")
                .routeId("DemoRoute")
                .choice()
                .when(simple("${body.amount} < 10"))
                .marshal().json()
                .log("${body} amount is lower")
                .to("file://lower")
                .setBody(constant("lower"))
                .otherwise()
                .marshal().json()
                .log("${body} amount is greater")
                .to("file://greater")
                .setBody(constant("greater"))
                .end()
        ;


    }

    @Bean
    String myBean() {
        return "I'm Spring bean!";
    }

}

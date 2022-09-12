package com.rct.humanresources;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.boot.SpringApplication.run;

/**
 * Spring Boot and Java - Template / Human Resources Application
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
public class TemplateSpringBootApplication {

    /**
     *  Spring Boot Java Template - Human Resources Application
     * @param args the amount of incoming damage
     *
     */
    public static void main(String[] args) {
        run(TemplateSpringBootApplication.class, args);
    }

}

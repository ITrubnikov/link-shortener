package ru.linkshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import util.LoggingStarterAutoConfiguration;

@SpringBootApplication
public class LinkShortenerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinkShortenerApplication.class, args);
        LoggingStarterAutoConfiguration.println("hello my lib");
        System.out.println("Hello World!");
    }

}

package org.vaadin.artur.myproject;

import com.vaadin.flow.server.ApplicationTheme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.vaadin.artur.helpers.LaunchUtil;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication
@ApplicationTheme("inline-theme")
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        ConfigurableApplicationContext app = SpringApplication.run(Application.class, args);
        LaunchUtil.launchBrowserInDevelopmentMode(app);
    }

}

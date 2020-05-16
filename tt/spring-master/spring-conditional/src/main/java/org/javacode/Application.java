package org.javacode;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Author
 */
public class Application {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext applicationContext =
                     new AnnotationConfigApplicationContext(ApplicationConfig.class)) {

            ApplicationConfig.GreeterService greeterService =
                    applicationContext.getBean(ApplicationConfig.GreeterService.class);

            String actual = greeterService.greeting();

            System.out.printf("Greeting: %s.\n", actual);
        }
    }
}

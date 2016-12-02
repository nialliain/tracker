package es.bikeid.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = null;
        try {
            ctx = SpringApplication.run(Application.class, args);
        } finally {
            if(ctx!=null){
                ctx.close();
            }
        }
    }
}

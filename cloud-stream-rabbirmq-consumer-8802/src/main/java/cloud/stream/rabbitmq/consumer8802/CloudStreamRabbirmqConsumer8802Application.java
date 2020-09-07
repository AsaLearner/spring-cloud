package cloud.stream.rabbitmq.consumer8802;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudStreamRabbirmqConsumer8802Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudStreamRabbirmqConsumer8802Application.class, args);
    }

}

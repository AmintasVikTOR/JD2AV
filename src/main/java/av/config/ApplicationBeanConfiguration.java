package av.config;

import av.domain.NotBeanByDefault;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import java.net.http.HttpClient;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    @Scope("singleton")
    @Primary
    public NotBeanByDefault notDefaultBean() {
        return new NotBeanByDefault();
    }

    @Bean
    @Scope("singleton")
    //@Primary
    public NotBeanByDefault notDefaultBean1() {
        return new NotBeanByDefault("TestPrimaryAnnotation");
    }

    @Bean
    public HttpClient httpClient() {
        return HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
    }
}

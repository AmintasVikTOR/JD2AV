package av.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("av")
@EnableAspectJAutoProxy(proxyTargetClass = true) //create bean LogAspect that marked by annotation @Aspect
@Import({DatasourceConfiguration.class, ApplicationBeanConfiguration.class})
public class ApplicationMainConfig {

}

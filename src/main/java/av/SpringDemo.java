package av;

import av.domain.Dealer;
import av.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
        User user1 = (User) context.getBean("user1");
        Dealer dealer1=(Dealer) context.getBean("dealer1");
        System.out.println(user1);
        System.out.println(dealer1);
    }


}

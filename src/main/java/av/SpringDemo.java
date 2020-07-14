package av;

import av.dao.DealerDao;
import av.dao.UserDao;
import av.domain.Dealer;
import av.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo {
    public static void main(String[] args) {

        /*Use application-context.xml*/
        /*
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");

        //Get BEAN
        User user1 = (User) context.getBean("user1");
        Dealer dealer1=(Dealer) context.getBean("dealer1");

        System.out.println(user1);
        System.out.println(dealer1);
*/


        //1. Download pom xml dependencies
        //2. Create application-context.xml or use annotation @Component
        //3. Use @Autowired for DI
        //4. Use @Qualifier for bean name definition
        //5. For test purpose only: use ClassPathXmlApplicationContext or AnnotationConfigApplicationContext
        //   for Spring Context calling and getting bean

        //ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext("av");

        //6. Getting bean by name (possible get bean by class name)
        UserDao userDaoImpl = (UserDao) context.getBean("userDaoImpl");
        DealerDao dealerDaoImpl=(DealerDao) context.getBean("dealerDaoImpl");

        UserDao userDaoImplByClassName = context.getBean(UserDao.class);
        DealerDao dealerDaoImplByClassName=context.getBean(DealerDao.class);
        UserService userService = context.getBean(UserService.class);
        DealerService dealerService=context.getBean(DealerService.class);

        //7. Call method as usual
        String login = userDaoImpl.findOne(Long.parseLong("1")).getLogin();
        String login2 = userDaoImplByClassName.findOne(Long.parseLong("1")).getLogin();
        System.out.println(login);
        System.out.println(login2);
        System.out.println(userService.findOne(Long.parseLong("1")).getLogin());

        String name = dealerDaoImpl.findOne(Long.parseLong("1")).getDealername();
        String name2 = dealerDaoImplByClassName.findOne(Long.parseLong("1")).getDealername();
        System.out.println(name);
        System.out.println(name2);
        System.out.println(dealerService.findOne(Long.parseLong("1")).getDealername());

    }


}

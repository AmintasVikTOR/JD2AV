package av;

import av.dao.CarsDao;
import av.dao.DealerDao;
import av.dao.UserDao;
import av.domain.Cars;
import av.domain.Dealer;
import av.domain.User;
import av.service.CarsService;
import av.service.DealerService;
import av.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDemo {
    private static final Logger log = Logger.getLogger(SpringDemo.class);
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("av");

        System.out.println("======== INFO USER'S ==========");


        UserService userService = (UserService) context.getBean("userService");
        for (User user : userService.findAll()) {
            log.info(user.getLogin());
        }

        System.out.println("======== INFO DEALER'S ==========");


        DealerService dealerService = (DealerService) context.getBean("dealerService");
        for (Dealer dealer : dealerService.findAll()) {
            log.info(dealer.getDealername());
        }

        System.out.println("======== INFO CAR'S ==========");


        CarsService carsService = (CarsService) context.getBean("carsService");
        for (Cars cars : carsService.findAll()) {
      log.info(cars.getModel());
        }
/*


    System.out.println("======== INFO DEALER ==========");

        DealerDao dealerRepositoryJdbcTemplate = (DealerDao) context.getBean("dealerRepositoryJdbcTemplate");
        for (Dealer dealer : dealerRepositoryJdbcTemplate.findAll()) {
            System.out.println(dealer);
        }

        System.out.println("======== INFO CARS ==========");

        CarsDao carRepositoryJdbcTemplate = (CarsDao) context.getBean("carsRepositoryJdbcTemplate");
        for (Cars cars : carRepositoryJdbcTemplate.findAll()) {
            System.out.println(cars);
        }*/
    }


}

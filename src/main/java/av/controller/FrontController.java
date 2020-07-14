package av.controller;

import av.dao.DealerDao;
import av.dao.DealerDaoImpl;
import av.dao.UserDao;
import av.dao.UserDaoImpl;
import av.domain.Dealer;
import av.domain.User;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class FrontController extends HttpServlet {

    public static final String FIND_ONE = "findOne";
    public static final String FIND_BY_ID = "findById";
    public static final String FIND_ALL = "findAll";
    public static final String SAVE = "save";
    public static final String UPDATE = "update";

    //private UserDao userDao = new UserDaoImpl();

    //private DealerDao dealerDao = new DealerDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }

    private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String searchQuery = StringUtils.isNotBlank(req.getParameter("userId")) ? req.getParameter("userId") : "0";
//        String typeOfSearch = StringUtils.isNotBlank(req.getParameter("type")) ? req.getParameter("type") : "0";
//        String userName = StringUtils.isNotBlank(req.getParameter("userName")) ? req.getParameter("userName") : "0";
//
//        String searchQueryDealer = StringUtils.isNotBlank(req.getParameter("dealerId")) ? req.getParameter("dealerId") : "0";
//        String dealerName = StringUtils.isNotBlank(req.getParameter("dealerName")) ? req.getParameter("dealerName") : "0";
//
//        try{
//            RequestDispatcher dispatcher = req.getRequestDispatcher("/bye");
//            if (dispatcher != null) {
//                String resultUsers = "";
//                String resultDealers = "";
//
//                switch (typeOfSearch) {
//                    case FIND_ONE:
//                        resultUsers = userDao.findOne(Long.parseLong(searchQuery)).getLogin();
//                        resultDealers = dealerDao.findOne(Long.parseLong(searchQueryDealer)).getDealername();
//                        break;
//                    case FIND_BY_ID:
//                        //resultUsers = userDao.findById(Long.parseLong(searchQuery)).orElseThrow(ResourceNotFoundException::new).getLogin();
//
//                        Optional<User> optionalUser = userDao.findById(Long.parseLong(searchQuery));
//                        Optional<Dealer> optionalDealer = dealerDao.findById(Long.parseLong(searchQueryDealer));
//
//                        if (optionalUser.isPresent()) {
//                            resultUsers = optionalUser.get().getLogin();
//                            resultDealers = optionalDealer.get().getDealername();
//                        }
//                        break;
//                    case SAVE:
//                        User user = new User();
//                        Dealer dealer = new Dealer();
//                        /*5. Columns mapping*/
//                        user.setUsername(userName);
//                        user.setSurname(userName);
//                        user.setBirthDate(new java.sql.Date(new Date().getTime()));
//                        user.setLogin(UUID.randomUUID().toString());
//                        user.setPassword(UUID.randomUUID().toString());
//                        user.setCreated(new Timestamp(new Date().getTime()));
//                        user.setChanged(new Timestamp(new Date().getTime()));
//                        user.setWeight(85F);
//
//                        dealer.setDealername(dealerName);
//                        dealer.setAddress("Random-address: " + UUID.randomUUID().toString());
//                        dealer.setCapacity(5L);
//                        dealer.setCreated(new Timestamp(new Date().getTime()));
//                        dealer.setChanged(new Timestamp(new Date().getTime()));
//                        dealer.setYear_of_foundation(new java.sql.Date(new Date().getTime()));
//
//                        resultUsers = userDao.save(user).getLogin();
//                        resultDealers = dealerDao.save(dealer).getDealername();
//                        break;
//                    case UPDATE:
//                        User userForUpdate = userDao.findOne(Long.parseLong(searchQuery));
//                        userForUpdate.setUsername(userName);
//                        userForUpdate.setChanged(new Timestamp(new Date().getTime()));
//
//                        Dealer dealerForUpdate = dealerDao.findOne(Long.parseLong(searchQueryDealer));
//                        dealerForUpdate.setDealername(dealerName);
//                        dealerForUpdate.setChanged(new Timestamp(new Date().getTime()));
//
//                        resultUsers = userDao.update(userForUpdate).getLogin();
//                        resultDealers = dealerDao.update(dealerForUpdate).getDealername();
//
//                        break;
//                    case FIND_ALL:
//                    default:
//                        resultUsers = userDao.findAll().stream().map(User::getLogin).collect(Collectors.joining(","));
//                        resultDealers = dealerDao.findAll().stream().map(Dealer::getDealername).collect(Collectors.joining(","));
//
//                        break;
//                }
//
//                req.setAttribute("userNames", resultUsers);
//                req.setAttribute("dealerNames", resultDealers);
//                dispatcher.forward(req, resp);
//            }
//        }
//        catch (Exception e) {
//            RequestDispatcher dispatcher = req.getRequestDispatcher("/error");
//            req.setAttribute("errors", e.getMessage());
//            dispatcher.forward(req, resp);
//
//        /*RequestDispatcher dispatcher = req.getRequestDispatcher("/bye");
//
//        String searchQuery = StringUtils.isNotBlank(req.getParameter("query")) ? req.getParameter("query") : "0";
//
//        String searchQuery2 = StringUtils.isNotBlank(req.getParameter("querydealer")) ? req.getParameter("querydealer") : "0";
//
//        /*if (dispatcher != null) {
//            System.out.println("User! Forward will be done!");
//
//
//            req.setAttribute(
//                    "userNames",
//                    userDao.search(searchQuery).stream().map(User::getLogin).collect(Collectors.joining(","))
//            );
//
//            System.out.println("Dealer! Forward will be done!");
//
//            req.setAttribute(
//                    "dealerNames",
//                    dealerDao.search(searchQuery2).stream().map(Dealer::getDealername).collect(Collectors.joining(","))
//            );
//
//            dispatcher.forward(req, resp);*/
//        }
    }
}

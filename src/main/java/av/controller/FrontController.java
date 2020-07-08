package av.controller;

import av.dao.DealerDao;
import av.dao.DealerDaoImpl;
import av.dao.UserDao;
import av.dao.UserDaoImpl;
import av.domain.Dealer;
import av.domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class FrontController extends HttpServlet {

    private UserDao userDao = new UserDaoImpl();

    private DealerDao dealerDao = new DealerDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }

    private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/bye");

        if (dispatcher != null) {
            System.out.println("User! Forward will be done!");
            req.setAttribute(
                    "userNames",
                    userDao.findAll().stream().map(User::getLogin).collect(Collectors.joining(","))
            );

            System.out.println("Dealer! Forward will be done!");
            req.setAttribute(
                    "dealerNames",
                    dealerDao.findAll().stream().map(Dealer::getDealername).collect(Collectors.joining(";"))
            );

            dispatcher.forward(req, resp);
        }
    }
}

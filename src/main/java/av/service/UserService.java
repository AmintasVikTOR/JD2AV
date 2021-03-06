package av.service;

import av.dao.UserDao;
import av.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserDao userDao;

    public UserService(@Qualifier("userRepositoryJdbcTemplate") UserDao userDao) {
        this.userDao = userDao;
    }

    public User findOne(Long userId) {
        return userDao.findOne(userId);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }
}
package av;

import av.dao.UserDao;
import av.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User findOne(Long userId) {
        return userDao.findOne(userId);
    }
}
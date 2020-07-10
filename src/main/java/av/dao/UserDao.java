package av.dao;

import av.domain.User;

import java.util.List;

public interface UserDao {
    /*CRUD operations*/
    /*Create = Insert*/
    /*Read = select*/
    /*Update*/
    /*Delete*/
    List<User> findAll();

    List<User> search(String searchParam);
}

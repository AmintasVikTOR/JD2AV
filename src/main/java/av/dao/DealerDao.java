package av.dao;

import av.domain.Dealer;
import av.domain.User;

import java.util.List;
import java.util.Optional;

public interface DealerDao {
    /*CRUD operations*/
    /*Create = Insert*/
    /*Read = select*/
    /*Update*/
    /*Delete*/
    List<Dealer> findAll();

    List<Dealer> search(String searchParam);

    Optional<Dealer> findById(Long dealerId);

    Dealer findOne(Long dealerId);

    Dealer save(Dealer dealer);

    Dealer update(Dealer dealer);

    int delete(Dealer dealer);

}

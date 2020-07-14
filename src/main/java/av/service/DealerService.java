package av.service;

import av.dao.DealerDao;
import av.domain.Dealer;
import av.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealerService {

    private DealerDao dealerDao;

    public DealerService(@Qualifier("dealerRepositoryJdbcTemplate") DealerDao dealerDao) {
        this.dealerDao = dealerDao;
    }

    public Dealer findOne(Long dealerId) {
        return dealerDao.findOne(dealerId);
    }
    public List<Dealer> findAll() {
        return dealerDao.findAll();
    }

}
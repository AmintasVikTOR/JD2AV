package av.service;

import av.dao.DealerDao;
import av.domain.Dealer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DealerService {

    private DealerDao dealerDao;

    public DealerService(@Qualifier("dealerRepositoryJdbcTemplate") DealerDao dealerDao) {
        this.dealerDao = dealerDao;
    }

    public Dealer findOne(Long dealerId) {
        return dealerDao.findOne(dealerId);
    }
}
package av;

import av.dao.DealerDao;
import av.domain.Dealer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealerService {
    @Autowired
    private DealerDao dealerDao;

    public Dealer findOne(Long dealerId) {
        return dealerDao.findOne(dealerId);
    }
}

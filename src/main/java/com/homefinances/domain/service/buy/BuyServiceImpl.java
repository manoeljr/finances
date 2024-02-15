package com.homefinances.domain.service.buy;

import com.homefinances.domain.model.Buy;
import com.homefinances.domain.repository.BuyDAO;
import org.springframework.stereotype.Service;

@Service
public class BuyServiceImpl implements BuyService {

    private final BuyDAO repositoy;


    public BuyServiceImpl(BuyDAO repositoy) {
        this.repositoy = repositoy;
    }

    @Override
    public Buy registerBuy(Buy buy) {
        return  repositoy.save(buy);
    }
}

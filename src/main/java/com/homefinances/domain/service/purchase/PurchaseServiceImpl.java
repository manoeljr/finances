package com.homefinances.domain.service.purchase;

import com.homefinances.domain.model.Purchase;
import com.homefinances.domain.repository.PurchaseDAO;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseDAO repositoy;


    public PurchaseServiceImpl(PurchaseDAO repositoy) {
        this.repositoy = repositoy;
    }

    @Override
    public Purchase registerPurchase(Purchase purchase) {
        return  repositoy.save(purchase);
    }
}

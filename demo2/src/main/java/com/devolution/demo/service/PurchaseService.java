package com.devolution.demo.service;

import com.devolution.demo.entity.Purchase;
import com.devolution.demo.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class PurchaseService {

    private PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public PurchaseRepository getPurchaseRepository() {
        return purchaseRepository;
    }

    public Timestamp getTime(){
        Purchase purchase = new Purchase();
        return purchase.getDateCreated();
    }

    //    public Purchase addPurchase(PurchaseRequest purchaseRequest) {
//        Purchase purchase = new Purchase();
//        purchase.getName(purchaseRequest.getName());
//        PurchaseRepository.save(purchase);
//        return purchase;
//    }
}
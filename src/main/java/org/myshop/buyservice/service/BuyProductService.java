package org.myshop.buyservice.service;

import org.myshop.buyservice.repository.BuyProduct;
import org.myshop.buyservice.repository.BuyProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class BuyProductService {

    private final BuyProductRepository buyProductRepository;


    public BuyProductService(BuyProductRepository buyProductRepository) {
        this.buyProductRepository = buyProductRepository;
    }

    public ResponseEntity<BuyProduct> buyProduct(BuyProduct buyProduct){
        buyProduct.setBuyAt(LocalDate.now());
        buyProduct.setId(UUID.randomUUID());
        return ResponseEntity.ok(buyProductRepository.save(buyProduct));
    }


    public ResponseEntity<List<BuyProduct>> getBuyProduct(UUID userId){
        return ResponseEntity.ok(buyProductRepository.findBuyProductsByUserId(userId));
    }

}

package org.myshop.buyservice.controller;


import jakarta.validation.Valid;
import org.myshop.buyservice.repository.BuyProduct;
import org.myshop.buyservice.repository.BuyProductRepository;
import org.myshop.buyservice.service.BuyProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/product")
public class BuyProductController {

    private final BuyProductService buyProductService;

    public BuyProductController(BuyProductService buyProductService) {
        this.buyProductService = buyProductService;
    }

    @PostMapping()
    public ResponseEntity<BuyProduct> buyProduct(@Valid @RequestBody BuyProduct  buyProduct){
        return buyProductService.buyProduct(buyProduct);
    }

    @GetMapping()
    public ResponseEntity<List<BuyProduct>> getBuyProduct(@RequestParam UUID userID){
        return buyProductService.getBuyProduct(userID);
    }

}

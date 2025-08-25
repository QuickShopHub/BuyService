package org.myshop.buyservice.controller;


import org.myshop.buyservice.repository.BuyProduct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/product")
public class BuyProductController {


    @PostMapping()
    public ResponseEntity<BuyProduct> buyProduct(){
        return null;
    }

}

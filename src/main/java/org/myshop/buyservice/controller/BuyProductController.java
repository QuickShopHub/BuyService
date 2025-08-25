package org.myshop.buyservice.controller;


import jakarta.validation.Valid;
import org.myshop.buyservice.repository.BuyProduct;
import org.myshop.buyservice.repository.BuyProductRepository;
import org.myshop.buyservice.repository.Favorites;
import org.myshop.buyservice.service.BuyProductService;
import org.myshop.buyservice.service.FavoritesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/")
public class BuyProductController {

    private final BuyProductService buyProductService;

    private final FavoritesService favoritesService;

    public BuyProductController(BuyProductService buyProductService, FavoritesService favoritesService) {
        this.buyProductService = buyProductService;
        this.favoritesService = favoritesService;
    }

    @PostMapping(path = "/buy")
    public ResponseEntity<BuyProduct> buyProduct(@Valid @RequestBody BuyProduct  buyProduct){
        return buyProductService.buyProduct(buyProduct);
    }

    @GetMapping(path = "/buy")
    public ResponseEntity<List<BuyProduct>> getBuyProduct(@RequestParam UUID userID){
        return buyProductService.getBuyProduct(userID);
    }


    @PostMapping(path = "/favorites")
    public ResponseEntity<Favorites> setFavorites(@Valid @RequestBody Favorites favorites){
        return favoritesService.setFavorites(favorites);
    }

    @GetMapping(path = "/favorites")
    public ResponseEntity<List<Favorites>> getFavorites(@RequestParam UUID userID){
        return favoritesService.getFavorites(userID);
    }

    @DeleteMapping(path = "/favorites")
    public ResponseEntity<Favorites> deleteFavorites(@RequestParam UUID id){
        return favoritesService.deleteFavorites(id);
    }


}

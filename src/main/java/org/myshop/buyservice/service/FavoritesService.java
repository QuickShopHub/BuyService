package org.myshop.buyservice.service;

import org.myshop.buyservice.repository.Favorites;
import org.myshop.buyservice.repository.FavoritesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FavoritesService {

    private final FavoritesRepository favoritesRepository;

    public FavoritesService(FavoritesRepository favoritesRepository) {
        this.favoritesRepository = favoritesRepository;
    }

    public ResponseEntity<Favorites> setFavorites(Favorites favorites){
        favorites.setId(UUID.randomUUID());
        return ResponseEntity.ok(favoritesRepository.save(favorites));
    }

    public ResponseEntity<List<Favorites>> getFavorites(UUID userId){
        return ResponseEntity.ok(favoritesRepository.findFavoritesByUserId(userId));
    }

    public ResponseEntity<Favorites> deleteFavorites(UUID favoriteId){
        Optional<Favorites> delete = favoritesRepository.findById(favoriteId);
        if(delete.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        favoritesRepository.deleteById(favoriteId);
        return ResponseEntity.ok(delete.get());
    }

}

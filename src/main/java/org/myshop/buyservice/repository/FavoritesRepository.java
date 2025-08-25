package org.myshop.buyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface FavoritesRepository extends JpaRepository<Favorites, UUID> {

    @Query(value = "SELECT * FROM favorites WHERE user_id=:userId",  nativeQuery = true)
    List<Favorites> findFavoritesByUserId(UUID userId);
}

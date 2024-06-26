package com.jstiven2000.RestaurantManager.repository;

import com.jstiven2000.RestaurantManager.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByName(String name);

}

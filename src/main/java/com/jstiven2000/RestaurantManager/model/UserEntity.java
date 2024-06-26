package com.jstiven2000.RestaurantManager.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name="users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private ERole role;
}

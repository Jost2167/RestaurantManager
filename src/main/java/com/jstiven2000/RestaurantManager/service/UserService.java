package com.jstiven2000.RestaurantManager.service;

import com.jstiven2000.RestaurantManager.model.ERole;
import com.jstiven2000.RestaurantManager.model.UserEntity;
import com.jstiven2000.RestaurantManager.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //Permite crear un usuario llamado ADMIN al iniciar la aplicacion.
    @PostConstruct
    public void postConstruct() {
        UserEntity admin = new UserEntity();
        admin.setName("ADMIN");
        admin.setRole(ERole.ADMINISTRATOR);
        admin.setPassword(passwordEncoder.encode("2167"));
        userRepository.save(admin);
    }

    //Permite crear usuarios.
    public void createUser(UserEntity user){
        user.setRole(ERole.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    //Permite obtener un usuario registrado por su nombre.
    public UserEntity findByUserOfLogin(String name){
        return userRepository.findByName(name);
    }


}

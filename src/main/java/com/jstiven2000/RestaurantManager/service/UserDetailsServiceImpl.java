package com.jstiven2000.RestaurantManager.service;

import com.jstiven2000.RestaurantManager.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    //Carga los datos necesarios del usuario para su autenticacion. Es invocado por Spring Security.
    //El objeto UserDetails generado, sera utilizado para comprobarlo con los datos ingresados por el usuario.
    //Si la autenticacion es correcta, se creara un SecurityContext, el cual sera utilizado para autorizar las solicitudes basados en su rol y permisos.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userService.findByUserOfLogin(username);
        if(user==null){
            return null;
        }
        return User.builder()
                .username(user.getName())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();
    }
}

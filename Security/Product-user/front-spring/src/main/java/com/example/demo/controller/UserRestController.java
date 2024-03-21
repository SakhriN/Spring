package com.example.demo.controller;

import com.example.demo.dto.BaseResponseDto;
import com.example.demo.dto.UserLoginDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserRestController {


    @Autowired
    UserService userService;


    @PostMapping("/api/auth/register")
    public BaseResponseDto registerUser(@RequestBody User user) {
        if (userService.createUser(user)) {
            return new BaseResponseDto("success");
        } else {
            return new BaseResponseDto("failed");
        }
    }


    @PostMapping("/api/auth/login")
    public BaseResponseDto loginUser(@RequestBody UserLoginDto loginDetails) {
        // Vérifier si l'mail de l'utilisateur existe.
        if (userService.checkUserNameExists(loginDetails.getMail())) {
            // Vérifier si le mot de passe correspond à l'mail.
            if (userService.verifyUser(loginDetails.getMail(), loginDetails.getPassword())) {
                // Si la vérification est réussie, préparer les données de la réponse.
                Map<String, Object> data = new HashMap<>();
                // Générer un token JWT et l'ajouter aux données.
                data.put("token", userService.generateToken(loginDetails.getMail(), loginDetails.getPassword()));
                // Renvoyer une réponse avec les données du token.
                return new BaseResponseDto("success", data);
            } else {
                // Renvoyer une réponse en cas de mot de passe incorrect.
                return new BaseResponseDto("wrong password");
            }
        } else {
            // Renvoyer une réponse si l'utilisateur n'existe pas.
            return new BaseResponseDto("user not exist");
        }
    }

}


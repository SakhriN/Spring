package com.example.base_spring.model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private UUID id;
    @NotNull
    @Size(min = 3, message = "Si tu met pas minimum 3 caractères, va te faire foutre !!!!")
    private String firstname, lastname;

    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,3}$", message = "Veuillez entrer une adresse e-mail valide.")
    private String email;

    @NotNull
    private Integer age;
}

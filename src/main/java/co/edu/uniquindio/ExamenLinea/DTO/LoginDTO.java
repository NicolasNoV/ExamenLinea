package co.edu.uniquindio.ExamenLinea.DTO;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(
        @NotBlank
        String correo,
        @NotBlank
        String password
) {
}
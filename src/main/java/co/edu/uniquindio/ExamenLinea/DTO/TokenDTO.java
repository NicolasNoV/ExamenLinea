package co.edu.uniquindio.ExamenLinea.DTO;

import jakarta.validation.constraints.NotBlank;

public record TokenDTO(
        @NotBlank
        String token
) {
}
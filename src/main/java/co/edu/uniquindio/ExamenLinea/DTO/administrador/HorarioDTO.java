package co.edu.uniquindio.ExamenLinea.DTO.administrador;

import java.time.LocalDateTime;

public record HorarioDTO(

        LocalDateTime dia,
        LocalDateTime hora,
        String lugar

) {
}

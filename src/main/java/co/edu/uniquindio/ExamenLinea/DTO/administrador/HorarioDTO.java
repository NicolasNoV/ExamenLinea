package co.edu.uniquindio.ExamenLinea.DTO.administrador;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record HorarioDTO(

        LocalDateTime dia,
        LocalTime hora,
        String lugar

) {
}

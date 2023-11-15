package co.edu.uniquindio.ExamenLinea.DTO;

import java.time.LocalDateTime;

public record CalificacionDTO(

        String nombreExamen,
        LocalDateTime fechaExamen,
        double nota

) {
}

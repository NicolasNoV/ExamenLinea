package co.edu.uniquindio.ExamenLinea.DTO.profesor;

import java.time.LocalDateTime;

public record ConfiguracionDTO(

        double porcentaje,
        double umbral,
        LocalDateTime hora,
        LocalDateTime fecha,
        int numeroPreguntas,
        LocalDateTime tiempo,
        int idExamen

) {
}

package co.edu.uniquindio.ExamenLinea.DTO.estudiante;

import java.time.LocalDateTime;

public record DiaEvaluacionDTO(

        LocalDateTime dia,
        LocalDateTime fecha,
        LocalDateTime hora

) {
}

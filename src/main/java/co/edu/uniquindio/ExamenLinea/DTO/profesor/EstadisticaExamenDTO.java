package co.edu.uniquindio.ExamenLinea.DTO.profesor;

import java.time.LocalDateTime;

public record EstadisticaExamenDTO(

        LocalDateTime fecha,
        double puntaje,
        LocalDateTime tiempoTranscurrido,
        int idExamen,
        int idEstudiante

) {
}

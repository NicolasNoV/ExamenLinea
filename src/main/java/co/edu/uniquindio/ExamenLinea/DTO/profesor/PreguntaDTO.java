package co.edu.uniquindio.ExamenLinea.DTO.profesor;

import java.time.LocalDateTime;

public record PreguntaDTO(

        double porcentaje,
        LocalDateTime tiempo,
        String texto,
        String tipoPregunta

) {
}

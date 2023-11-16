package co.edu.uniquindio.ExamenLinea.DTO;

import java.time.LocalDateTime;

public record PreguntaDTO(

        double porcentaje,
        LocalDateTime tiempo,
        String texto,
        String tipoPregunta

) {
}

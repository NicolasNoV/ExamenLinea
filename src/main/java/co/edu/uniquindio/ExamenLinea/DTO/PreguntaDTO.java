package co.edu.uniquindio.ExamenLinea.DTO;

import java.time.LocalDateTime;

public record PreguntaDTO(

        int idPregunta,
        double porcentaje,
        LocalDateTime tiempo,
        String pregunta,
        String tipoPregunta

) {
}

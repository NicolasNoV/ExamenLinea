package co.edu.uniquindio.ExamenLinea.DTO.estudiante;

import java.time.LocalDateTime;

public record VerExamenDTO(

        String nombre,
        String descripcion,
        String categoria,
        int cantidadPreguntasBanco,
        int cantidadPreguntasEstudiante,
        LocalDateTime tiempo,
        int idDiaEvaluacion

) {
}

package co.edu.uniquindio.ExamenLinea.DTO.profesor;

import co.edu.uniquindio.ExamenLinea.modelo.enums.EstadoExamen;

import java.time.LocalDateTime;

public record ExamenDTO(

        String nombre,
        String descripcion,
        String categoria,
        EstadoExamen estadoExamen,
        int cantidadPreguntasBanco,
        int cantidadPreguntasEstudiante,
        LocalDateTime tiempoLimite,
        int idDiaEvaluacion

) {
}

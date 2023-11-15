package co.edu.uniquindio.ExamenLinea.DTO.profesor;

public record EstadisticaPreguntaDTO(

        double porcentajeCorrecto,
        int correctas,
        int incorrectas,
        int contestadas,
        int idPregunta

) {
}

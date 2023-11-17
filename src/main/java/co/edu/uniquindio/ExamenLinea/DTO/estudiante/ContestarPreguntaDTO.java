package co.edu.uniquindio.ExamenLinea.DTO.estudiante;

import co.edu.uniquindio.ExamenLinea.DTO.PreguntaDTO;

import java.util.List;

public record ContestarPreguntaDTO(

        List<PreguntaDTO> preguntas,
        int idExamen

) {
}

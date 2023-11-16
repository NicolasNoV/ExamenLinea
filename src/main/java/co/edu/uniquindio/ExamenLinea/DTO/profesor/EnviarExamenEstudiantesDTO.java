package co.edu.uniquindio.ExamenLinea.DTO.profesor;

import java.util.List;

public record EnviarExamenEstudiantesDTO(

        List<Integer> idEstudiantes,
        int idExamen

) {
}

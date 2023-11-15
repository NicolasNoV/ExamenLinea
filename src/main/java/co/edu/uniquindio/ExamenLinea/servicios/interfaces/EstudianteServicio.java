package co.edu.uniquindio.ExamenLinea.servicios.interfaces;

import co.edu.uniquindio.ExamenLinea.DTO.CalificacionDTO;
import co.edu.uniquindio.ExamenLinea.DTO.PreguntaDTO;
import co.edu.uniquindio.ExamenLinea.DTO.estudiante.*;

import java.util.List;

public interface EstudianteServicio {

    List<VerExamenDTO> verListaExamenesPendiente(ExamenesEstudianteDTO examenesEstudianteDTO) throws Exception;

    List<VerExamenDTO> verListaExamenesResueltos(ExamenesEstudianteDTO examenesEstudianteDTO) throws Exception;

    List<NotificacionDTO> verNotificaciones(int idEstudiante) throws Exception;

    List<CalificacionDTO> verNotas(List<Integer> listaIDCalificacion) throws Exception;

    List<PreguntaDTO> resolverExamen(int idExamen) throws Exception;

    void contestarPregunta(RespuestaDTO respuestaDTO) throws Exception;

}

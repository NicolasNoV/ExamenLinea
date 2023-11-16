package co.edu.uniquindio.ExamenLinea.servicios.interfaces;

import co.edu.uniquindio.ExamenLinea.DTO.CalificacionDTO;
import co.edu.uniquindio.ExamenLinea.DTO.PreguntaDTO;
import co.edu.uniquindio.ExamenLinea.DTO.profesor.*;

import java.util.List;

public interface ProfesorServicio {

    boolean crearExamen(ExamenDTO examenDTO) throws Exception;

    boolean agregarPreguntasExamen(PreguntaExamenDTO preguntaExamenDTO) throws Exception;

    boolean configurarExamen(ConfiguracionDTO configuracionDTO) throws Exception;

    EstadisticaExamenDTO estadisticaExamen(int idEstadisticaExamen) throws Exception;

    EstadisticaPreguntaDTO estadisticaPregunta(int idEstadisticaPregunta) throws Exception;

    List<CalificacionDTO> verNotasEstudiante(int idEstudiante) throws Exception;

    boolean crearPregunta(PreguntaDTO preguntaDTO) throws Exception;

    boolean crearTema(String nombreTema) throws Exception;

    boolean crearBancoPreguntas(int idTema) throws Exception;

    boolean enviarExamenEstudiantes(EnviarExamenEstudiantesDTO enviarExamenEstudiantesDTO) throws Exception;
}

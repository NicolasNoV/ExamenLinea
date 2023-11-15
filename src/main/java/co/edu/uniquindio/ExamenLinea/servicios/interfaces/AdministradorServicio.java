package co.edu.uniquindio.ExamenLinea.servicios.interfaces;

import co.edu.uniquindio.ExamenLinea.DTO.administrador.*;

public interface AdministradorServicio {

    boolean crearProfesor(ProfesorDTO profesorDTO) throws Exception;

    ProfesorDTO buscarProfesorId(int idProfesor) throws Exception;

    boolean modificarProfesorId(ProfesorDetalleDTO profesorDetalleDTO) throws Exception;

    boolean eliminarProfesor(int idProfesor) throws Exception;

    boolean crearEstudiante(EstudianteDTO estudianteDTO) throws Exception;

    EstudianteDTO buscarEstudianteId(int idEstudiante) throws Exception;

    boolean modificarEstudianteId(EstudianteDetalleDTO estudianteDetalleDTO) throws Exception;

    boolean eliminarEstudiante(int idEstudiante) throws Exception;

    boolean crearGrupo(GrupoDTO grupoDTO) throws Exception;

    boolean buscarGrupoId(int idGrupo) throws Exception;

    GrupoDTO modificarGrupoId(GrupoDetalleDTO grupoDetalleDTO) throws Exception;

    boolean eliminarGrupo(int idGrupo) throws Exception;

    boolean aniadirEstudianteGrupo(EstudianteGrupoDTO estudianteGrupoDTO) throws Exception;

    boolean eliminarEstudianteGrupo(EstudianteGrupoDTO estudianteGrupoDTO) throws Exception;

    boolean crearPlanEstudio(PlanEstudioDTO planEstudioDTO) throws Exception;

    boolean crearHorario(HorarioDTO horarioDTO) throws Exception;

}

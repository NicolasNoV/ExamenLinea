package co.edu.uniquindio.ExamenLinea.servicios.implementacion;

import co.edu.uniquindio.ExamenLinea.DTO.administrador.*;
import co.edu.uniquindio.ExamenLinea.modelo.entidades.*;
import co.edu.uniquindio.ExamenLinea.modelo.enums.EstadoEntidad;
import co.edu.uniquindio.ExamenLinea.repositorio.*;
import co.edu.uniquindio.ExamenLinea.servicios.interfaces.AdministradorServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AdministradorImpl implements AdministradorServicio {

    private final ProfesorRepo profesorRepo;
    private final EstudianteRepo estudianteRepo;
    private final GrupoRepo grupoRepo;
    private final PlanEstudioRepo planEstudioRepo;
    private final HorarioRepo horarioRepo;


    @Override
    public boolean crearProfesor(ProfesorDTO profesorDTO) throws Exception {
        boolean respuesta = false;

        if (profesorDTO != null){
            Profesor profesor = new Profesor();

            profesor.setNombre(profesorDTO.nombre());
            profesor.setApellido(profesorDTO.apellido());
            profesor.setEstado(EstadoEntidad.ACTIVO);

            profesorRepo.save(profesor);

            respuesta = true;
        }else{
            throw new Exception("No se han todos llenados los campos");
        }
        return respuesta;
    }

    @Override
    public ProfesorDTO buscarProfesorId(int idProfesor) throws Exception {

        Optional<Profesor> opcional = profesorRepo.findById(idProfesor);

        if( opcional.isEmpty() ){
            throw new Exception("No existe un profesor con el código "+idProfesor);
        }

        return new ProfesorDTO(opcional.get().getNombre(), opcional.get().getApellido());
    }

    @Override
    public boolean modificarProfesorId(ProfesorDetalleDTO profesorDetalleDTO) throws Exception {
        boolean respuesta = false;

        if (profesorDetalleDTO != null){
            Optional<Profesor> opcional = profesorRepo.findById(profesorDetalleDTO.idProfesor());

            if (opcional.isEmpty()){
                throw new Exception("No existe un profesor con el código "+profesorDetalleDTO.idProfesor());
            }

            Profesor profesor = opcional.get();

            profesor.setNombre(profesorDetalleDTO.nombre());
            profesor.setApellido(profesorDetalleDTO.apellido());

            profesorRepo.save(profesor);

            respuesta = true;
        }else{
            throw new Exception("No se han llenados todos los campos");
        }
        return respuesta;
    }

    @Override
    public boolean eliminarProfesor(int idProfesor) throws Exception {
        boolean respuesta = false;
        Optional<Profesor> opcional = profesorRepo.findById(idProfesor);

        if( opcional.isEmpty() ){
            throw new Exception("No existe un profesor con el código "+idProfesor);
        }else{
            respuesta = true;
        }

        Profesor buscado = opcional.get();
        buscado.setEstado(EstadoEntidad.INACTIVO);
        profesorRepo.save( buscado );

        return respuesta;
    }

    @Override
    public boolean crearEstudiante(EstudianteDTO estudianteDTO) throws Exception {
        boolean respuesta = false;

        if (estudianteDTO != null){
            Estudiante estudiante = new Estudiante();

            Optional<Grupo> opcional = grupoRepo.findById(estudianteDTO.idGrupo());

            if (opcional.isEmpty()){
                throw new Exception("No existe un grupo con el código "+estudianteDTO.idGrupo());
            }

            estudiante.setNombre(estudianteDTO.nombre());
            estudiante.setApellido(estudianteDTO.apellido());
            estudiante.setGrupo(opcional.get());
            estudiante.setEstado(EstadoEntidad.ACTIVO);

            estudianteRepo.save(estudiante);

            respuesta = true;
        }else{
            throw new Exception("No se han todos llenados los campos");
        }
        return respuesta;
    }

    @Override
    public EstudianteDTO buscarEstudianteId(int idEstudiante) throws Exception {
        Optional<Estudiante> opcional = estudianteRepo.findById(idEstudiante);

        if( opcional.isEmpty() ){
            throw new Exception("No existe un estudiante con el código "+idEstudiante);
        }

        return new EstudianteDTO(opcional.get().getNombre(), opcional.get().getApellido(),
                opcional.get().getId());
    }

    @Override
    public boolean modificarEstudianteId(EstudianteDetalleDTO estudianteDetalleDTO) throws Exception {
        boolean respuesta = false;

        if (estudianteDetalleDTO != null){
            Optional<Estudiante> opcional = estudianteRepo.findById(estudianteDetalleDTO.idEstudiante());
            Optional<Grupo> opcional2 = grupoRepo.findById(estudianteDetalleDTO.idGrupo());

            if (opcional2.isEmpty()){
                throw new Exception("No existe un grupo con el código "+estudianteDetalleDTO.idGrupo());
            }else{
                if (opcional.isEmpty()){
                    throw new Exception("No existe un estudiante con el código "+estudianteDetalleDTO.idEstudiante());
                }
            }

            Estudiante estudiante = opcional.get();

            estudiante.setNombre(estudianteDetalleDTO.nombre());
            estudiante.setApellido(estudianteDetalleDTO.apellido());
            estudiante.setGrupo(opcional2.get());

            estudianteRepo.save(estudiante);

            respuesta = true;
        }else{
            throw new Exception("No se han llenados todos los campos");
        }
        return respuesta;
    }

    @Override
    public boolean eliminarEstudiante(int idEstudiante) throws Exception {
        boolean respuesta = false;
        Optional<Estudiante> opcional = estudianteRepo.findById(idEstudiante);

        if( opcional.isEmpty() ){
            throw new Exception("No existe un estudiante con el código "+idEstudiante);
        }else{
            respuesta = true;
        }

        Estudiante buscado = opcional.get();
        buscado.setEstado(EstadoEntidad.INACTIVO);
        estudianteRepo.save( buscado );

        return respuesta;
    }

    @Override
    public boolean crearGrupo(GrupoDTO grupoDTO) throws Exception {
        boolean respuesta = false;

        if (grupoDTO != null){
            Grupo grupo = new Grupo();

            Optional<PlanEstudio> opcional = planEstudioRepo.findById(grupoDTO.idPlanEstudio());
            Optional<Horario> opcional2 = horarioRepo.findById(grupoDTO.idHorario());
            Optional<Profesor> opcional3 = profesorRepo.findById(grupoDTO.idProfesor());

            if (opcional.isEmpty()){
                throw new Exception("No existe un plan de estudio con el código "+grupoDTO.idPlanEstudio());
            }else {
                if(opcional2.isEmpty()){
                    throw new Exception("No existe un horario con el código "+grupoDTO.idHorario());
                }else {
                    if(opcional3.isEmpty()){
                        throw new Exception("No existe un profesor con el código "+grupoDTO.idProfesor());
                    }
                }
            }

            grupo.setNombre(grupoDTO.nombre());
            grupo.setPlanEstudio(opcional.get());
            grupo.setHorario(opcional2.get());
            grupo.setProfesor(opcional3.get());
            grupo.setEstado(EstadoEntidad.ACTIVO);

            grupoRepo.save(grupo);

            respuesta = true;
        }else{
            throw new Exception("No se han todos llenados los campos");
        }
        return respuesta;
    }

    @Override
    public GrupoDTO buscarGrupoId(int idGrupo) throws Exception {
        Optional<Grupo> opcional = grupoRepo.findById(idGrupo);

        if( opcional.isEmpty() ){
            throw new Exception("No existe un grupo con el código "+idGrupo);
        }

        return new GrupoDTO(opcional.get().getNombre(),opcional.get().getPlanEstudio().getId(),
                opcional.get().getHorario().getId(),opcional.get().getProfesor().getId());
    }

    @Override
    public boolean modificarGrupoId(GrupoDetalleDTO grupoDetalleDTO) throws Exception {
        boolean respuesta = false;

        if (grupoDetalleDTO != null){
            Optional<Grupo> opcional = grupoRepo.findById(grupoDetalleDTO.idGrupo());
            Optional<PlanEstudio> opcional2 = planEstudioRepo.findById(grupoDetalleDTO.idPlanEstudio());
            Optional<Horario> opcional3 = horarioRepo.findById(grupoDetalleDTO.idHorario());
            Optional<Profesor> opcional4 = profesorRepo.findById(grupoDetalleDTO.idProfesor());

            if (opcional.isEmpty()){
                throw new Exception("No existe un grupo con el código "+grupoDetalleDTO.idGrupo());
            }

            Grupo grupo = opcional.get();

            grupo.setNombre(grupoDetalleDTO.nombre());
            grupo.setPlanEstudio(opcional2.get());
            grupo.setHorario(opcional3.get());
            grupo.setProfesor(opcional4.get());

            grupoRepo.save(grupo);

            respuesta = true;
        }else{
            throw new Exception("No se han llenados todos los campos");
        }
        return respuesta;
    }

    @Override
    public boolean eliminarGrupo(int idGrupo) throws Exception {
        boolean respuesta = false;
        Optional<Grupo> opcional = grupoRepo.findById(idGrupo);

        if( opcional.isEmpty() ){
            throw new Exception("No existe un grupo con el código "+idGrupo);
        }else{
            respuesta = true;
        }

        Grupo buscado = opcional.get();
        buscado.setEstado(EstadoEntidad.INACTIVO);
        grupoRepo.save(buscado);

        return respuesta;
    }

    @Override
    public boolean aniadirEstudianteGrupo(EstudianteGrupoDTO estudianteGrupoDTO) throws Exception {
        boolean respuesta = false;

        Optional<Grupo> opcional = grupoRepo.findById(estudianteGrupoDTO.idGrupo());
        Optional<Estudiante> opcional2 = estudianteRepo.findById(estudianteGrupoDTO.idEstudiante());

        if( opcional.isEmpty() ){
            throw new Exception("No existe un grupo con el código "+estudianteGrupoDTO.idGrupo());
        }else{
            if( opcional2.isEmpty() ){
                throw new Exception("No existe un estudiante con el código "+estudianteGrupoDTO.idEstudiante());
            }
        }

        Estudiante estudiante = opcional2.get();
        estudiante.setGrupo(opcional.get());

        return respuesta;
    }

    @Override
    public boolean eliminarEstudianteGrupo(EstudianteGrupoDTO estudianteGrupoDTO) throws Exception {
        boolean respuesta = false;

        Optional<Estudiante> opcional = estudianteRepo.findById(estudianteGrupoDTO.idEstudiante());

        if( opcional.isEmpty() ){
                throw new Exception("No existe un estudiante con el código "+estudianteGrupoDTO.idEstudiante());
        }

        Estudiante estudiante = opcional.get();
        estudiante.setGrupo(null);

        return respuesta;
    }

    @Override
    public boolean crearPlanEstudio(PlanEstudioDTO planEstudioDTO) throws Exception {
        boolean respuesta = false;

        if (planEstudioDTO != null){
            PlanEstudio planEstudio = new PlanEstudio();

            planEstudio.setUnidades(planEstudio.getUnidades());
            planEstudio.setContenido(planEstudio.getContenido());
            planEstudio.setEstado(EstadoEntidad.ACTIVO);

            planEstudioRepo.save(planEstudio);

            respuesta = true;
        }else{
            throw new Exception("No se han todos llenados los campos");
        }
        return respuesta;
    }

    @Override
    public boolean crearHorario(HorarioDTO horarioDTO) throws Exception {
        boolean respuesta = false;

        if (horarioDTO != null){
            Horario horario = new Horario();

            horario.setDia(horarioDTO.dia());
            horario.setHora(horarioDTO.hora());
            horario.setEstado(EstadoEntidad.ACTIVO);

            horarioRepo.save(horario);

            respuesta = true;
        }else{
            throw new Exception("No se han todos llenados los campos");
        }
        return respuesta;
    }
}

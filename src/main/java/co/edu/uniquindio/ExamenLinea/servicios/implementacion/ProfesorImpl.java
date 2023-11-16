package co.edu.uniquindio.ExamenLinea.servicios.implementacion;

import co.edu.uniquindio.ExamenLinea.DTO.CalificacionDTO;
import co.edu.uniquindio.ExamenLinea.DTO.PreguntaDTO;
import co.edu.uniquindio.ExamenLinea.DTO.profesor.*;
import co.edu.uniquindio.ExamenLinea.modelo.entidades.*;
import co.edu.uniquindio.ExamenLinea.modelo.enums.EstadoEntidad;
import co.edu.uniquindio.ExamenLinea.modelo.enums.EstadoExamen;
import co.edu.uniquindio.ExamenLinea.repositorio.*;
import co.edu.uniquindio.ExamenLinea.servicios.interfaces.ProfesorServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProfesorImpl implements ProfesorServicio {

    private final ExamenRepo examenRepo;
    private final DiaEvaluacionRepo diaEvaluacionRepo;
    private final ConfiguracionRepo configuracionRepo;
    private final PreguntaRepo preguntaRepo;
    private final EstadisticaExamenRepo estadisticaExamenRepo;
    private final EstadisticaPreguntaRepo estadisticaPreguntaRepo;
    private final CalificacionRepo calificacionRepo;
    private final TemaRepo temaRepo;
    private final BancoPreguntaRepo bancoPreguntaRepo;
    private final EstudianteRepo estudianteRepo;

    @Override
    public boolean crearExamen(ExamenDTO examenDTO) throws Exception {
        boolean respuesta = false;

        if(examenDTO != null){
            Examen examen = new Examen();

            Optional<DiaEvaluacion> opcional = diaEvaluacionRepo.findById(examenDTO.idDiaEvaluacion());
            Optional<Configuracion> opcional2 = configuracionRepo.findById(examenDTO.idConfiguracion());

            if( opcional.isEmpty() ){
                throw new Exception("No existe un dia de evaluacion con el código "+examenDTO.idDiaEvaluacion());
            }else{
                if(opcional2.isEmpty()){
                    throw new Exception("No existe una configuracion con el código "+examenDTO.idConfiguracion());
                }
            }

            examen.setNombre(examenDTO.nombre());
            examen.setDescripcion(examenDTO.descripcion());
            examen.setCategoria(examenDTO.categoria());
            examen.setEstadoExamen(EstadoExamen.PENDIENTE);
            examen.setCantidadPreguntasBanco(examenDTO.cantidadPreguntasBanco());
            examen.setCantidadPreguntasEstudiante(examenDTO.cantidadPreguntasEstudiante());
            examen.setTiempoLimite(examenDTO.tiempoLimite());
            examen.setDiaEvaluacion(opcional.get());
            examen.setConfiguracion(opcional2.get());
            examen.setEstado(EstadoEntidad.ACTIVO);

            examenRepo.save(examen);

            respuesta = true;
        }else{
            throw new Exception("No se han todos llenados los campos");
        }
        return respuesta;
    }

    @Override
    public boolean agregarPreguntasExamen(PreguntaExamenDTO preguntaExamenDTO) throws Exception {
        boolean respuesta = false;

        Optional<Pregunta> opcional = preguntaRepo.findById(preguntaExamenDTO.idPregunta());
        Optional<Examen> opcional2 = examenRepo.findById(preguntaExamenDTO.idExamen());

        if( opcional.isEmpty() ){
            throw new Exception("No existe una pregunta con el código "+preguntaExamenDTO.idPregunta());
        }else{
            if(opcional2.isEmpty()){
                throw new Exception("No existe un examen con el código "+preguntaExamenDTO.idExamen());
            }
        }

        List<Pregunta> preguntas = preguntaRepo.findAll();
        int cantidadPreguntas = 1;
        for(int i=0; i<preguntas.size();i++){
            for(Pregunta pregunta : preguntas){
                if(pregunta.getExamen().get(i).getId() == preguntaExamenDTO.idExamen()){
                    cantidadPreguntas++;
                }
            }

        }

        if(opcional2.get().getConfiguracion() != null){
            if(opcional2.get().getConfiguracion().getNumeroPreguntas() >= cantidadPreguntas){
                Pregunta pregunta = opcional.get();

                List<Examen> listaExamenes = opcional.get().getExamen();
                listaExamenes.add(opcional2.get());

                pregunta.setExamen(listaExamenes);

                respuesta = true;
            }else{
                throw new Exception("Ya se encuentra el numero maxmimo de preguntas");
            }

        }else{
            throw new Exception("El examen no tiene un configuracion agregada");
        }
        return respuesta;
    }

    @Override
    public boolean configurarExamen(ConfiguracionDTO configuracionDTO) throws Exception {
        boolean respuesta = false;

        if(configuracionDTO != null){
            Configuracion configuracion = new Configuracion();

            Optional<Examen> opcional = examenRepo.findById(configuracionDTO.idExamen());
            if( opcional.isEmpty() ){
                throw new Exception("No existe un examen con el código "+configuracionDTO.idExamen());
            }

            configuracion.setPorcentaje(configuracionDTO.porcentaje());
            configuracion.setUmbral(configuracionDTO.umbral());
            configuracion.setHora(configuracionDTO.hora());
            configuracion.setFecha(configuracionDTO.fecha());
            configuracion.setNumeroPreguntas(configuracionDTO.numeroPreguntas());
            configuracion.setTiempo(configuracionDTO.tiempo());
            configuracion.setEstado(EstadoEntidad.ACTIVO);

            configuracionRepo.save(configuracion);

            Examen examen = opcional.get();
            examen.setConfiguracion(configuracion);
            examenRepo.save(examen);

            respuesta = true;
        }
        return respuesta;
    }

    @Override
    public EstadisticaExamenDTO estadisticaExamen(int idEstadisticaExamen) throws Exception {

        Optional<EstadisticaExamen> opcional = estadisticaExamenRepo.findById(idEstadisticaExamen);

        if( opcional.isEmpty() ){
            throw new Exception("No existe una estadistica de examen con el código "+idEstadisticaExamen);
        }

        return new EstadisticaExamenDTO(opcional.get().getFecha(), opcional.get().getPuntaje(),
                opcional.get().getTiempoTranscurrido(), opcional.get().getExamen().getId(),
                opcional.get().getEstudiante().getId());
    }

    @Override
    public EstadisticaPreguntaDTO estadisticaPregunta(int idEstadisticaPregunta) throws Exception {

        Optional<EstadisticaPregunta> opcional = estadisticaPreguntaRepo.findById(idEstadisticaPregunta);

        if( opcional.isEmpty() ){
            throw new Exception("No existe una estadistica de pregunta con el código "+idEstadisticaPregunta);
        }

        return new EstadisticaPreguntaDTO(opcional.get().getPorcentajeCorrecto(), opcional.get().getCorrectas(),
                opcional.get().getIncorrectas(), opcional.get().getContestadas(), opcional.get().getPregunta().getId());
    }

    @Override
    public List<CalificacionDTO> verNotasEstudiante(int idEstudiante) throws Exception {
        List<CalificacionDTO> notas = new ArrayList<>();

        List<Calificacion> listaCalificaciones = calificacionRepo.findAll();

        for(Calificacion calificacion : listaCalificaciones){
            if(calificacion.getEstudiante().getId() == idEstudiante){
                notas.add(new CalificacionDTO(
                        calificacion.getExamen().getNombre(),
                        calificacion.getExamen().getDiaEvaluacion().getFecha(),
                        calificacion.getNota()
                ));
            }
        }
        return notas;
    }

    @Override
    public boolean crearPregunta(PreguntaDTO preguntaDTO) throws Exception {
        boolean respuesta = false;

        if (preguntaDTO != null){
            Pregunta pregunta = new Pregunta();

            pregunta.setPorcentaje(preguntaDTO.porcentaje());
            pregunta.setTiempo(preguntaDTO.tiempo());
            pregunta.setPregunta(preguntaDTO.pregunta());
            pregunta.setTipoPregunta(preguntaDTO.tipoPregunta());

            preguntaRepo.save(pregunta);

            respuesta = true;
        }

        return respuesta;
    }

    @Override
    public boolean crearTema(String nombreTema) throws Exception {
        boolean respuesta = false;

        if(!nombreTema.isEmpty()){
            Tema tema = new Tema();

            tema.setNombre(nombreTema);
            tema.setEstado(EstadoEntidad.ACTIVO);

            temaRepo.save(tema);
            respuesta = true;
        }
        return respuesta;
    }

    @Override
    public boolean crearBancoPreguntas(int idTema) throws Exception {
        boolean respuesta = false;

        if(idTema != 0){
            Optional<Tema> opcional = temaRepo.findById(idTema);
            BancoPregunta bancoPregunta = new BancoPregunta();

            bancoPregunta.setTema(opcional.get());
            bancoPregunta.setEstado(EstadoEntidad.ACTIVO);

            bancoPreguntaRepo.save(bancoPregunta);
            respuesta = true;
        }
        return respuesta;
    }

    @Override
    public boolean enviarExamenEstudiantes(EnviarExamenEstudiantesDTO enviarExamenEstudiantesDTO) throws Exception {
        boolean respuesta = false;

        Optional<Examen> opcional = examenRepo.findById(enviarExamenEstudiantesDTO.idExamen());
        if(opcional.isEmpty()){
            throw new Exception("No existe un examen con el código "+enviarExamenEstudiantesDTO.idExamen());
        }

        for(int idEstudiante : enviarExamenEstudiantesDTO.idEstudiantes()){
            Optional<Estudiante> opcional2 = estudianteRepo.findById(idEstudiante);
            if(opcional2.isPresent()){
                Estudiante estudiante = opcional2.get();

                List<Examen> examenList = opcional2.get().getExamenes();
                examenList.add(opcional.get());
                estudiante.setExamenes(examenList);

                estudianteRepo.save(estudiante);
                respuesta = true;
            }
        }


        return respuesta;
    }
}

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
            examen.setTiempo(examenDTO.tiempo());
            examen.setDiaEvaluacion(opcional.get());
            examen.setConfiguracion(opcional2.get());
            examen.setEstado(EstadoEntidad.ACTIVO);

            examenRepo.save(examen);

            respuesta = true;
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
            }

        }
        return respuesta;
    }

    @Override
    public boolean configurarExamen(ConfiguracionDTO configuracionDTO) throws Exception {
        boolean respuesta = false;

        if(configuracionDTO != null){
            Configuracion configuracion = new Configuracion();

            configuracion.setPorcentaje(configuracionDTO.porcentaje());
            configuracion.setUmbral(configuracionDTO.umbral());
            configuracion.setHora(configuracionDTO.hora());
            configuracion.setFecha(configuracionDTO.fecha());
            configuracion.setNumeroPreguntas(configuracionDTO.numeroPreguntas());
            configuracion.setTiempo(configuracionDTO.tiempo());
            configuracion.setEstado(EstadoEntidad.ACTIVO);

            configuracionRepo.save(configuracion);

            respuesta = true;
        }
        return respuesta;
    }

    @Override
    public EstadisticaExamenDTO estadisticaExamen(int idEstadisticaExamen) throws Exception {
        boolean respuesta = false;

        Optional<EstadisticaExamen> opcional = estadisticaExamenRepo.findById(idEstadisticaExamen));


        return null;
    }

    @Override
    public EstadisticaPreguntaDTO estadisticaPregunta(int idEstadisticaPregunta) throws Exception {
        return null;
    }

    @Override
    public List<CalificacionDTO> verNotasEstudiante(int idEstudiante) throws Exception {
        return null;
    }

    @Override
    public boolean crearPregunta(PreguntaDTO preguntaDTO) throws Exception {
        return false;
    }

    @Override
    public boolean crearTema(String nombreTema) throws Exception {
        return false;
    }

    @Override
    public boolean crearBancoPreguntas(int idTema) throws Exception {
        return false;
    }
}
